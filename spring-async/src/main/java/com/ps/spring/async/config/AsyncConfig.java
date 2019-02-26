package com.ps.spring.async.config;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;

public class AsyncConfig implements AsyncConfigurer {
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(50);
        executor.setMaxPoolSize(500);
        executor.setQueueCapacity(500);
        executor.setThreadNamePrefix("GeneralExecutor-");
        executor.initialize();
        return executor;
    }

    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
        return new AsyncUncaughtExceptionHandler()
        {
            public void handleUncaughtException(Throwable ex, Method method, Object... params)
            {
                System.out.println(String.format("asynchronously processing error:method={method}, parameters={params}",
                        method.toString(),
                        params.toString()));
            }
        };
    }
}
