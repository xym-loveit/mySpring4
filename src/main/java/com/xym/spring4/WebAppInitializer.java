package com.xym.spring4;

import com.xym.spring4.config.RootConfig;
import com.xym.spring4.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 包含了Spring上下文（ContextLoaderListener）和Spring MVC Web上下文（DispatcherServlet）
 *
 * @author xym
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    protected Class<?>[] getRootConfigClasses() {
        /*Spring 跟上下文配置*/
        return new Class[]{RootConfig.class};
    }

    protected Class<?>[] getServletConfigClasses() {
        /*Web上下文配置*/
        return new Class[]{WebConfig.class};
    }

    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
