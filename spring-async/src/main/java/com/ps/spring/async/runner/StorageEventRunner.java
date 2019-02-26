package com.ps.spring.async.runner;

import com.ps.spring.async.event.OrderPublisher;
import com.ps.spring.async.event.util.Printer;
import com.ps.spring.async.returnvalue.AsyncWithReturnValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StorageEventRunner implements CommandLineRunner {
    @Autowired
    private OrderPublisher orderPublisher;
    @Autowired
    private AsyncWithReturnValue asyncWithReturnValue;
    public void run(String... args) throws Exception {
        Printer.print("Runner call order purchase");
        this.orderPublisher.purchase();
        String dataWithoutFuture = this.asyncWithReturnValue.getData();
        System.out.println("data without future:" + dataWithoutFuture);
        String dataWithFuture = this.asyncWithReturnValue.getFutureData().get();
        System.out.println("data with future:" + dataWithFuture);
    }
}
