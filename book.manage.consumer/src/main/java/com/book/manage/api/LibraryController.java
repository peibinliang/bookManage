package com.book.manage.api;

import com.book.manage.core.dto.req.LibraryReqDto;
import com.book.manage.core.dto.resp.LibraryRespDto;
import com.book.manage.core.exception.BusinessException;
import com.book.manage.sample.service.LibraryService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
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

    @GetMapping("/saveLibrary")
    public ModelAndView saveLibrary(){
        return new ModelAndView("/saveLibrary");
    }

    @PostMapping("/saveLibraryDo")
    public ApiResponse saveLibraryDo(LibraryReqDto libraryReqDto) throws BusinessException {
        libraryService.saveLibrary(libraryReqDto);
        return ApiResponse.success();
    }

    @GetMapping("/modifyLibrary")
    public ModelAndView modifyLibrary(Integer libraryId){
        LibraryRespDto libraryInfo = libraryService.getLibraryByLibraryId(libraryId);
        ModelAndView modelAndView = new ModelAndView("/modifyLibrary");
        modelAndView.addObject("libraryInfo",libraryInfo);
        return modelAndView;
    }

    @PostMapping("/modifyLibraryDo")
    public ApiResponse modifyLibraryDo(LibraryReqDto libraryReqDto) throws BusinessException {
        libraryReqDto.setGmtModify(new Date());
        libraryService.modifyLibrary(libraryReqDto);
        return ApiResponse.success();
    }

}
