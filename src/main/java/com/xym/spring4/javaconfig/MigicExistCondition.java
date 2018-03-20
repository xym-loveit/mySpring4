package com.xym.spring4.javaconfig;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 当前系统环境变量中是否存在migic环境变量
 *
 * @author xym
 */
public class MigicExistCondition implements Condition {
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        return context.getEnvironment().containsProperty("magicc");
    }
}
