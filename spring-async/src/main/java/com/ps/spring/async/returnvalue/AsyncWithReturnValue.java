package com.ps.spring.async.returnvalue;

import com.ps.spring.async.event.util.Printer;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncWithReturnValue {
    @Async
    public String getData(){
        Printer.print("getData without future.");
        return "data";
    }
    @Async
    public Future<String> getFutureData(){
        Printer.print("getdata with future");
        return new AsyncResult<String>("future data");
    }
}
