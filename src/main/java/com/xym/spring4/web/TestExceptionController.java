package com.xym.spring4.web;

import com.xym.spring4.exceptions.MyRuntimeException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author xym
 */
@Controller
@RequestMapping("test")
public class TestExceptionController {

    @RequestMapping("/ex2")
    public String ex1(@RequestParam("param") String param) {
        if (param.equals("1")) {

        } else {
            throw new MyRuntimeException("自定义异常");
        }
        return "home";
    }

}
