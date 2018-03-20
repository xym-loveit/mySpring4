package com.xym.spring4.javaConfig;

import com.xym.spring4.javaconfig.JavaProfileConfig;
import com.xym.spring4.javaconfig.Output;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaProfileConfigMain {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("prod");
        context.register(JavaProfileConfig.class);
        context.refresh();

        for (String s : context.getBeanDefinitionNames()) {
            System.out.println(s);
        }

        Output bean = (Output) context.getBean(Output.class);
        bean.print();

        context.close();
    }
}
