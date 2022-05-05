package com.book.manage.api;

import com.book.manage.core.dto.req.UserReqDto;
import com.book.manage.core.dto.resp.UserRespDto;
import com.book.manage.core.exception.BusinessException;
import com.book.manage.core.utils.UserUtils;
import com.book.manage.sample.service.UserService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @author liangpeibin
 * @ClassName UserController
 * @Description
 * @since 2022/5/2 21:48
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {
    @DubboReference
    private UserService userService;

    @GetMapping("/saveUser")
    public ModelAndView saveUser(){
        return new ModelAndView("/saveUser");
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("/login");
    }

    @PostMapping("/loginCheck")
    @ResponseBody
    public ApiResponse loginCheck(UserReqDto user, HttpServletRequest request) throws BusinessException {
        UserRespDto respDto = userService.login(user);
        request.getSession().setAttribute("user", respDto);
        return ApiResponse.success(true);
    }

    @GetMapping("/logout")
    public ApiResponse logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return ApiResponse.success(null);
    }

    @GetMapping("/main")
    public ModelAndView main() {
        return new ModelAndView("/main");
    }

    @GetMapping("/forgetPassword")
    public ModelAndView forgetPassword() {
        return new ModelAndView("/forgetPassword");
    }

    @PostMapping("/forgetPasswordDo")
    @ResponseBody
    public ApiResponse forgetPasswordDo(UserReqDto userReqDto) throws BusinessException {
        return ApiResponse.success(userService.forgerPassword(userReqDto));
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("/userRegister");
    }

    @PostMapping("/registerDo")
    @ResponseBody
    public ApiResponse registerDo(UserReqDto userReqDto) throws BusinessException {
        return ApiResponse.success(userService.saveUser(userReqDto));
    }

    @GetMapping("/userInfo")
    public ModelAndView userInfo(Integer userId) {
        UserRespDto user = userService.getUserByUserId(userId);
        user.setRegisterTime(UserUtils.FormatDate(user.getGmtCreate()));
        ModelAndView view = new ModelAndView("/userInfo");
        view.addObject("userInfo", user);
        return view;
    }

    @GetMapping("/modifyPassword")
    public ModelAndView modifyPassword() {
        return new ModelAndView("/modifyPassword");
    }

    @PostMapping("/modifyPasswordDo")
    @ResponseBody
    public ApiResponse modifyPasswordDo(UserReqDto userReqDto) throws BusinessException {
        return ApiResponse.success(userService.modifyPassword(userReqDto));
    }

    @GetMapping("/userList")
    public ModelAndView userList(Integer page, HttpServletRequest request) throws BusinessException {
        if (Objects.isNull(page)) {
            page = 1;
        }
        List<UserRespDto> userList = userService.listUser(page);
        for (UserRespDto user : userList) {
            user.setRegisterTime(UserUtils.FormatDate(user.getGmtCreate()));
        }
        ModelAndView view = new ModelAndView("/userList");
        view.addObject("userList", userList);
        request.setAttribute("userList", userList);
        view.addObject("page", page);
        Integer maxPage = userService.getMaxPage();
        view.addObject("maxPage",maxPage);
        return view;
    }

    @GetMapping("/modifyUser")
    public ModelAndView modifyUser(Integer userId){
        UserRespDto userInfo = userService.getUserByUserId(userId);
        userInfo.setRegisterTime(UserUtils.FormatDate(userInfo.getGmtCreate()));
        ModelAndView view = new ModelAndView("/modifyUser");
        view.addObject("userInfo",userInfo);
        return view;
    }

    @PostMapping("modifyUserDo")
    @ResponseBody
    public ApiResponse modifyUserDo(UserReqDto userReqDto){
        userReqDto.setGmtModify(new Date());
        return ApiResponse.success(userService.modifyUser(userReqDto));
    }
}
