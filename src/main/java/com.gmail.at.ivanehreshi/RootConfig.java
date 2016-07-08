package com.gmail.at.ivanehreshi;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SyncTaskExecutor;

@Configuration
public class RootConfig implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("RootConfig initialized");
    }
}
