package com.book.manage.api.welcome;

import com.book.manage.api.BaseController;
import com.book.manage.sample.service.WelcomeService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * 欢迎接口
 * @author ~
 * @date 2022/04/11 16:14
 */
@RestController
public class WelcomeController extends BaseController {

    @DubboReference
    private WelcomeService welcomeService;

    @GetMapping("/index")
    public ModelAndView getIndex(){
        ModelAndView view = new ModelAndView("index");
        view.addObject("url","");
        return view;
    }
}
