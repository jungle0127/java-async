package com.ps.spring.async.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.stereotype.Component;

@Component
public class DeductStorageEvent extends ApplicationEvent {
    public DeductStorageEvent(Object source) {
        super(source);
    }
}
