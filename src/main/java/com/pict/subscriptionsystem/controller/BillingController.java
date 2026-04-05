package com.pict.subscriptionsystem.controller;

import com.pict.subscriptionsystem.entity.Billing;
import com.pict.subscriptionsystem.repository.BillingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {

    private final BillingRepository billingRepository;

    public BillingController(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    @GetMapping("/{subscriptionId}")
    public List<Billing> getBills(@PathVariable Long subscriptionId) {
        return billingRepository.findBySubscriptionId(subscriptionId);
    }
}