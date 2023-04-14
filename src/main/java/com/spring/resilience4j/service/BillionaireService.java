package com.spring.resilience4j.service;

import com.spring.resilience4j.model.Billionaire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.resilience4j.repository.BillionaireRepository;

import java.util.List;

@Service
public class BillionaireService {

    @Autowired
    private BillionaireRepository billionaireRepository;

    public List<Billionaire> getAllBillionaires() {
        return billionaireRepository.findAll();
    }

    // Other methods
}
