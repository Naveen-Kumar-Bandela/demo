package com.spring.resilience4j.controller;

import com.spring.resilience4j.model.Billionaire;
import com.spring.resilience4j.service.BillionaireService;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/restapi")
@RequiredArgsConstructor
public class BillionaireController {

    private final BillionaireService billionaireService;
    @GetMapping("/billionaires")
    @Retry(name = "billionairesRetryApi", fallbackMethod = "fallbackMethodAfterRetry")
    public List<Billionaire> getAllBillionaires() {
        System.out.println("BillionaireController.getAllBillionaires");
        return billionaireService.getAllBillionaires();
    }
    public List<Billionaire> fallbackMethodAfterRetry(Throwable ex) {
        System.out.println("BillionaireController.fallbackMethodAfterRetry");
        List<Billionaire> billionaires = new ArrayList<>();
        return billionaires;
    }
}
