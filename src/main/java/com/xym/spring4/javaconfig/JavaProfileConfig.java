package com.xym.spring4.javaconfig;

import org.springframework.context.annotation.*;

/**
 * @author xym
 */
@Configuration
public class JavaProfileConfig {

    @Bean(name = "output")
    @Profile(value = "dev")
    public Output outputA() {
        return new AOutPut();
    }

    @Bean
    @Profile(value = "prod")
    public Output outputB() {
        return new BOutPut();
    }


    /*通过MigicExistCondition来决定是否需要创建该bean*/
    @Bean
    @Primary/*当出现歧义时，首选当前bean*/
    @Conditional(MigicExistCondition.class)
    public Output outputC() {
        return new MigicOutPut();
    }
}
