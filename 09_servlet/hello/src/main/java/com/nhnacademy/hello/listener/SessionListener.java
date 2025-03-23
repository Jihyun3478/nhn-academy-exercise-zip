package com.nhnacademy.hello.listener;

import java.util.concurrent.atomic.AtomicInteger;

import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class SessionListener implements HttpSessionListener {
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        HttpSessionListener.super.sessionCreated(se);
        int sessionCounter = atomicInteger.incrementAndGet();
        log.error("session-counter:{}", sessionCounter);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        HttpSessionListener.super.sessionCreated(se);
        int sessionCounter = atomicInteger.decrementAndGet();
        log.error("session-counter:{}", sessionCounter);
    }
}
