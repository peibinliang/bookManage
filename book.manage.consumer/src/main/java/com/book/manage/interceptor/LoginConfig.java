package com.book.manage.interceptor;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liangpeibin
 * @ClassName LoginConfig
 * @Description
 * @since 2022/5/3 12:11
 */
@Configuration
public class LoginConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //注册TestInterceptor拦截器
        InterceptorRegistration registration = registry.addInterceptor(new UserLoginInterceptor());
        registration.addPathPatterns("/**"); //所有路径都被拦截
        registration.excludePathPatterns(    //添加不拦截路径
                "/user/login",               //登录路径
                "/user/loginCheck",          //登录验证路径
                "/user/forgetPassword",      //忘记密码路径
                "/user/forgetPasswordDo",    //忘记密码修改路径
                "/user/register",            //用户注册路径
                "/user/registerDo",          //用户注册执行路径
                "/user/index",               //首页路径
                "/**/*.html",                //html静态资源
                "/**/*.js",                  //js静态资源
                "/**/*.css",                 //css静态资源
                "/**/*.jpg",                  //照片静态资源
                "/**/*.png"                  //照片静态资源

        );
    }
}
