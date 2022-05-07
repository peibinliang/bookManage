package com.book.manage.core.Mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.book.manage.core.dto.resp.BookRespDto;
import com.book.manage.core.entity.Book;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author liangpeibin
 * @since 2022/5/6
 */
public interface BookMapper extends BaseMapper<Book> {
    /**
     * 根据图书库Id获取书籍列表
     * @param libraryId
     * @return
     */
    List<BookRespDto> listBookByLibraryId(@Param("libraryId") Integer libraryId);

    /**
     * 根据书籍Id列表移除书籍
     * @param bookId
     * @return
     */
    Integer removeBookByBookIdList(@Param("bookId") Integer bookId);

    /**
     * 根据书籍名称和图书库Id获取书籍
     * @param bookName
     * @param libraryId
     * @return
     */
    BookRespDto getBookByBookNameAndLibraryId(@Param("bookName") String bookName, @Param("libraryId") Integer libraryId);

    /**
     * 书籍搜索
     * @param search
     * @return
     */
    List<BookRespDto> searchBook(@Param("search") String search);
}
