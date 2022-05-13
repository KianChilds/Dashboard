package com.example.reports;

import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class StatusReport {
    public boolean ready = true;
    public int status = 0;
}
