package com.ps.spring.async.event;

import com.ps.spring.async.event.util.Printer;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

@Component
public class OrderPublisher implements ApplicationEventPublisherAware {
    private ApplicationEventPublisher applicationEventPublisher;
    private String data;
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public String getData() {
        return data;
    }

    public void purchase(){
        this.applicationEventPublisher.publishEvent(new DeductStorageEvent(this));
        Printer.print("Purchase...");
        this.data = "puchase";
    }
}
