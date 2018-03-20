package com.xym.spring4;

import com.xym.spring4.config.RootConfig;
import com.xym.spring4.config.WebConfig;
import com.xym.spring4.filter.MyFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.Filter;
import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;

/**
 * 包含了Spring上下文（ContextLoaderListener）和Spring MVC Web上下文（DispatcherServlet）
 * <p>
 * 该类会自动的配置DispatcherServlet和spring应用上下文，spring的应用上下文会位于应用程序的Servlet上下文之中
 *
 * @author xym
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        /*Spring 跟上下文配置*/
        return new Class[]{RootConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        /*Web上下文配置*/
        return new Class[]{WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    /**
     * Filter默认作用于DispatcherServlet的url mapping上（即/）
     *
     * @return
     */
    @Override
    protected Filter[] getServletFilters() {
        return new Filter[]{new MyFilter()};
    }

    /*将DispatcherServlet注册到Servlet容器之后，就会调用customizeRegistration*/
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setLoadOnStartup(1);
        /*文件大小不超过2M，整个请求不超过4M*/
        registration.setMultipartConfig(new MultipartConfigElement("d:/uploadFiles", 2097152, 4194304, 0));
    }
}
