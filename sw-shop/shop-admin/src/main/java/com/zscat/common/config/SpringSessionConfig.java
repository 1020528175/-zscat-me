package com.zscat.common.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@ConditionalOnProperty(prefix = "zscat", name = "spring-session-open", havingValue = "true")
public class SpringSessionConfig {

}
