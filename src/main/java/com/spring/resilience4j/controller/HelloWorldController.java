package com.spring.resilience4j.controller;

import com.spring.resilience4j.model.Employee;
import com.spring.resilience4j.service.EmployeeService;
import com.spring.resilience4j.service.HelloWorldService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HelloWorldController {
    private final HelloWorldService helloWorldService;

    private final EmployeeService employeeService;
    @GetMapping("/retry")
    @Retry(name = "retryApi", fallbackMethod = "fallbackAfterRetry")
    public String retryApi() {
        return helloWorldService.getHelloWorld();
    }

    @GetMapping("/sms")
    @Retry(name = "retryApi", fallbackMethod = "fallbackAfterRetry")
    public String sendSMS() {
        return helloWorldService.sendSMS();
    }

    @GetMapping("/otp")
    @Retry(name = "retryApi", fallbackMethod = "fallbackAfterRetry")
    public String generateOTP() {
        return helloWorldService.getHelloWorld();
    }

    @GetMapping("/employees")
    @Retry(name = "retryApi", fallbackMethod = "fallbackAfterRetry")public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }
    public String fallbackAfterRetry(Exception ex) {
        return "all retries have exhausted";
    }
}
