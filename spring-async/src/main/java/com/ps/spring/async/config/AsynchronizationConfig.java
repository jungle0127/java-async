package com.ps.spring.async.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Configuration
@EnableAsync
public class AsynchronizationConfig {
    /**
     * 定义异步线种执行器
     * @return
     */
    @Bean
    public Executor taskExecutor(){
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        return executorService;
    }
}
