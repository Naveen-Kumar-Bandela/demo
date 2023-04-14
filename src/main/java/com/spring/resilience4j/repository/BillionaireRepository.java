package com.spring.resilience4j.repository;


import com.spring.resilience4j.model.Billionaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillionaireRepository extends JpaRepository<Billionaire, Long> {
}
