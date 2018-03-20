package com.xym.spring4.handler;

import com.xym.spring4.exceptions.MyRuntimeException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * 控制器通知注解类，会包含一个或多个如下类型的方法：
 *
 * @author xym
 * @ExceptionHandler 标注的方法
 * @InitBinder 标注的方法
 * @ModelAttribute 标注的方法
 * <p>
 * 以上所有这些方法会运用到整个应用程序所有控制器中带有@RequestMapping注解的方法上
 */
@ControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(MyRuntimeException.class)
    public String exHandler() {
        System.out.println("发生异常了>>>");
        return "home";
    }
}
