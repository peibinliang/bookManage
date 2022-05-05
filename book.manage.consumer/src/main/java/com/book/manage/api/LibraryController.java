package com.book.manage.api;

import com.book.manage.core.dto.resp.LibraryRespDto;
import com.book.manage.sample.service.LibraryService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author liangpeibin
 * @ClassName LibraryController
 * @Description
 * @since 2022/5/4 16:43
 */
@RestController
@RequestMapping("/library")
public class LibraryController {
    @DubboReference
    private LibraryService libraryService;

    @GetMapping("/myLibrary")
    public ModelAndView myLibrary(Integer userId){
        List<LibraryRespDto> libraryList = libraryService.listLibraryByUserId(userId);
        ModelAndView view = new ModelAndView("/myLibrary");
        view.addObject("libraryList",libraryList);
        return view;
    }
}
