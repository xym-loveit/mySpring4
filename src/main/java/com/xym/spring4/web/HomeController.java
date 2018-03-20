package com.xym.spring4.web;

import com.xym.spring4.domain.User;
import com.xym.spring4.exceptions.MyRuntimeException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author xym
 */
@Controller
public class HomeController {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(ModelMap modelMap) {
        /**
         * 虽然是重定向，但也能将model里面的数据作为url参数传递（http://localhost:8080/ex1?param=1&param2=2）
         */
        modelMap.addAttribute("param", 1);
        modelMap.addAttribute("param2", 2);
        return "redirect:/ex1";
    }

    @RequestMapping(value = {"/home2"}, method = RequestMethod.GET)
    public String home2(RedirectAttributes redirectAttributes, ModelMap modelMap) {
        /**
         * 重定向无法传递对象需要采用redirectAttributes
         */
        modelMap.addAttribute("param", 1);
        modelMap.addAttribute("param2", 2);
        User user = new User();
        user.setUserId(100);
        user.setUserName("张三");
        user.setPassWord("123456");
        redirectAttributes.addFlashAttribute("user", user);
        return "redirect:/ex1";
    }


    /**
     * home3和home2的区别在于，home2中modelMap无法再redirect场景中传递参数（param、param2）,
     * 而home3采用RedirectAttributes，addAttribute则可以传递（但并不存在重定向目标ex1中的model中）
     * 然使用redirectAttributes.addFlashAttribute可以将参数放入重定向目标ex1中的model中
     * <p>
     * redirectAttributes原理是先将参数放入session中，然后在重定向目标ex1中取出，并放入到ex1中的model中，实现了参数"穿透"
     */
    @RequestMapping(value = {"/home3"}, method = RequestMethod.GET)
    public String home3(RedirectAttributes redirectAttributes) {
        /**
         * 重定向无法传递对象需要采用redirectAttributes
         */
        redirectAttributes.addAttribute("param", 1);
        redirectAttributes.addAttribute("param2", 2);
        User user = new User();
        user.setUserId(100);
        user.setUserName("张三");
        user.setPassWord("123456");
        redirectAttributes.addFlashAttribute("user", user);
        return "redirect:/ex1";
    }

    /**
     * 使用ResponseStatus，将异常转为HTTP状态码
     *
     * @param param
     * @return
     */
    @RequestMapping(value = {"/ex1"}, method = RequestMethod.GET)
    public String ex1(@RequestParam("param") String param, Model model) {
        System.out.println(model.toString());
        System.out.println("param:" + param);
        if (param.equals("1")) {
            System.out.println("1");
        } else {
            throw new MyRuntimeException("自定义异常");
        }
        return "home";
    }

    /**
     * 使用ResponseStatus，将异常转为HTTP状态码
     *
     * @param param
     * @return
     */
    @RequestMapping(value = {"/ex2"}, method = RequestMethod.GET)
    public String ex2(@RequestParam("param") String param) {
        if (param.equals("1")) {
            System.out.println("1");
        } else {
            throw new MyRuntimeException("自定义异常");
        }
        return "home";
    }


    /**
     * 当当前控制器中发生MyRuntimeException类型异常时，采用该方法处理（注意范围为当前Controller）
     *
     * @return
     */
    @ExceptionHandler(value = {MyRuntimeException.class})
    public String exHandler() {
        System.out.println("发生异常了。。。-----");
        return "home";
    }
}
