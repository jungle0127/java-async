package com.ps.spring.async.event.util;

public class Printer {
    public static void print(String content){
        System.out.printf("[%s]--%s%n", Thread.currentThread().getName(), content);
    }
}
