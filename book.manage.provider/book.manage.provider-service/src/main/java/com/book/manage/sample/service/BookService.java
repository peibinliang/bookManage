package com.book.manage.sample.service;

import com.book.manage.core.dto.req.BookReqDto;
import com.book.manage.core.dto.resp.BookRespDto;
import com.book.manage.core.exception.BusinessException;

import java.util.List;

/**
 * <p>
 *  图书服务类
 * </p>
 *
 * @author liangpeibin
 * @since 2022/5/6
 */
public interface BookService {
    /**
     * 获取图书库书籍列表
     * @param libraryId
     * @return
     */
    List<BookRespDto> listBookByLibraryId(Integer libraryId);

    /**
     * 根据书籍Id列表移除书籍
     * @param bookId
     * @return
     */
    boolean removeBookByBookId(Integer bookId);

    /**
     * 根据书籍Id获取书籍
     * @param bookId
     * @return
     */
    BookRespDto getBookByBookId(Integer bookId);

    /**
     * 编辑书籍信息
     * @param bookReqDto
     * @return
     */
    boolean modifyBook(BookReqDto bookReqDto);

    /**
     * 新增书籍
     * @param bookReqDto
     * @return
     */
    boolean saveBook(BookReqDto bookReqDto) throws BusinessException;

    /**
     * 书籍搜索
     * @param search
     * @return
     */
    List<BookRespDto> searchBook(String search);
}
