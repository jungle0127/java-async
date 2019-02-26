package com.ps.spring.async.event;

import com.ps.spring.async.event.util.Printer;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class StorageEntity {
    /**
     * @Async : 调用当方法时会开启一个线程异步执行
     */
    @Async
    /**
     * @EventListener  当前方法会监听对应的事件
      */
    @EventListener(DeductStorageEvent.class)
    public void deduct(DeductStorageEvent deductStorageEvent) throws InterruptedException {
        OrderPublisher orderPublisher = (OrderPublisher) deductStorageEvent.getSource();
        TimeUnit.SECONDS.sleep(1L);
        Printer.print(orderPublisher.getData());
    }
}
