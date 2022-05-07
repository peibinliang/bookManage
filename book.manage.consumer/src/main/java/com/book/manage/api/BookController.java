package com.book.manage.api;

import com.book.manage.core.dto.req.BookReqDto;
import com.book.manage.core.dto.resp.BookRespDto;
import com.book.manage.core.enums.BookTypeEnum;
import com.book.manage.core.exception.BusinessException;
import com.book.manage.sample.service.BookService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;

/**
 * @author liangpeibin
 * @ClassName BookController
 * @Description
 * @since 2022/5/6 20:16
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @DubboReference
    private BookService bookService;

    @GetMapping("/bookList")
    public ModelAndView bookList(Integer libraryId){
        List<BookRespDto> bookList = bookService.listBookByLibraryId(libraryId);
        for (BookRespDto book : bookList){
            book.setTypeName(BookTypeEnum.getTypeNameByTypeId(book.getType()));
        }
        ModelAndView view = new ModelAndView("/bookList");
        view.addObject("bookList",bookList);
        view.addObject("libraryId",libraryId);
        return view;
    }

    @PostMapping("/removeBook")
    @ResponseBody
    public ApiResponse removeBook(Integer bookId){
        boolean result = bookService.removeBookByBookId(bookId);
        return ApiResponse.success(result);
    }

    @GetMapping("/bookInfo")
    public ModelAndView bookInfo(Integer bookId){
        BookRespDto bookInfo = bookService.getBookByBookId(bookId);
        bookInfo.setTypeName(BookTypeEnum.getTypeNameByTypeId(bookInfo.getType()));
        ModelAndView view = new ModelAndView("/bookInfo");
        view.addObject("bookInfo",bookInfo);
        return view;
    }

    @GetMapping("/modifyBook")
    public ModelAndView modifyBook(Integer bookId){
        BookRespDto bookInfo = bookService.getBookByBookId(bookId);
        bookInfo.setTypeName(BookTypeEnum.getTypeNameByTypeId(bookInfo.getType()));
        ModelAndView view = new ModelAndView("/modifyBook");
        view.addObject("bookInfo",bookInfo);
        return view;
    }

    @PostMapping("/modifyBookDo")
    @ResponseBody
    public ApiResponse modifyBookDo(BookReqDto bookReqDto){
        bookReqDto.setGmtModify(new Date());
        boolean result = bookService.modifyBook(bookReqDto);
        return ApiResponse.success(result);
    }

    @GetMapping("/saveBook")
    public ModelAndView saveBook(Integer libraryId){
        ModelAndView view = new ModelAndView("/saveBook");
        view.addObject("libraryId",libraryId);
        return view;
    }

    @PostMapping("/saveBookDo")
    public ApiResponse saveBookDo(BookReqDto bookReqDto) throws BusinessException {
        bookService.saveBook(bookReqDto);
        return ApiResponse.success();
    }

    @PostMapping("/searchBook")
    public ModelAndView searchBook(BookReqDto bookReqDto){
        List<BookRespDto> bookList = bookService.searchBook(bookReqDto.getSearch());
        for (BookRespDto book : bookList){
            book.setTypeName(BookTypeEnum.getTypeNameByTypeId(book.getType()));
        }
        ModelAndView view = new ModelAndView("/bookList");
        view.addObject("bookList",bookList);
        view.addObject("libraryId",bookReqDto.getLibraryId());
        return view;
    }
}
