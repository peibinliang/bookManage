package com.book.manage.sample.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.book.manage.core.Mapper.BookMapper;
import com.book.manage.core.dto.req.BookReqDto;
import com.book.manage.core.dto.resp.BookRespDto;
import com.book.manage.core.entity.Book;
import com.book.manage.core.entity.LibraryLog;
import com.book.manage.core.enums.UserStateCode;
import com.book.manage.core.exception.BusinessException;
import com.book.manage.sample.service.BookService;
import com.book.manage.sample.service.LibraryLogService;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * @author liangpeibin
 * @ClassName BookServiceImpl
 * @Description 图书服务实现类
 * @since 2022/5/6 20:19
 */
@Service("bookService")
@DubboService
public class BookServiceImpl implements BookService {
    @Resource
    private BookMapper bookMapper;
    @Autowired
    private LibraryLogService libraryLogService;

    /**
     * 获取图书库书籍列表
     *
     * @param libraryId
     * @return
     */
    @Override
    public List<BookRespDto> listBookByLibraryId(Integer libraryId) {
        return bookMapper.listBookByLibraryId(libraryId);
    }

    /**
     * 根据书籍Id列表移除书籍
     *
     * @param bookId
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeBookByBookId(Integer bookId) {
        LibraryLog libraryLog = new LibraryLog();
        Book book = bookMapper.selectById(bookId);
        libraryLog.setLibraryId(book.getLibraryId());
        libraryLog.setBookId(bookId);
        libraryLog.setModifyType(2);
        libraryLogService.saveLibraryLog(libraryLog);
        return bookMapper.removeBookByBookIdList(bookId)>0;
    }

    /**
     * 根据书籍Id获取书籍
     *
     * @param bookId
     * @return
     */
    @Override
    public BookRespDto getBookByBookId(Integer bookId) {
        return BeanUtil.toBean(bookMapper.selectById(bookId),BookRespDto.class);
    }

    /**
     * 编辑书籍信息
     *
     * @param bookReqDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean modifyBook(BookReqDto bookReqDto) {
        LibraryLog libraryLog = new LibraryLog();
        Book book = bookMapper.selectById(bookReqDto.getBookId());
        libraryLog.setLibraryId(book.getLibraryId());
        libraryLog.setBookId(bookReqDto.getBookId());
        libraryLog.setModifyType(3);
        libraryLogService.saveLibraryLog(libraryLog);
        return bookMapper.updateById(BeanUtil.toBean(bookReqDto, Book.class))>0;
    }

    /**
     * 新增书籍
     *
     * @param bookReqDto
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean saveBook(BookReqDto bookReqDto) throws BusinessException {
        if (Objects.nonNull(bookMapper.getBookByBookNameAndLibraryId(bookReqDto.getBookName(),bookReqDto.getLibraryId()))){
            throw new BusinessException(UserStateCode.BU10008);
        }
        bookMapper.insert(BeanUtil.toBean(bookReqDto, Book.class));
        LibraryLog libraryLog = new LibraryLog();
        Book book = bookMapper.selectById(bookReqDto.getBookId());
        libraryLog.setLibraryId(book.getLibraryId());
        libraryLog.setBookId(bookReqDto.getBookId());
        libraryLog.setModifyType(1);
        libraryLogService.saveLibraryLog(libraryLog);
        return true;
    }

    /**
     * 书籍搜索
     *
     * @param search
     * @return
     */
    @Override
    public List<BookRespDto> searchBook(String search) {
        return bookMapper.searchBook(search);
    }
}
