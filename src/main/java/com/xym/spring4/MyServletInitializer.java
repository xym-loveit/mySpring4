package com.xym.spring4;

import com.xym.spring4.servlet.MyServlet;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * 创建WebApplicationInitializer的实现，创建新的初始化器，并注入一个Servlet
 *
 * @author xym
 */
public class MyServletInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        /*注册Servlet*/
        ServletRegistration.Dynamic myServlet = servletContext.addServlet("myServlet", MyServlet.class);
        /*Servlet映射路径*/
        myServlet.addMapping("/myServlet/**");


        /*注册Filter*/
//        FilterRegistration.Dynamic myFilter = servletContext.addFilter("myFilter", MyFilter.class);
        /*添加Filter映射路径*/
//        myFilter.addMappingForUrlPatterns(null, false, "/myFilter/**");
    }
}
