package com.pict.subscriptionsystem.service;

import com.pict.subscriptionsystem.entity.Billing;
import com.pict.subscriptionsystem.entity.Subscription;
import com.pict.subscriptionsystem.repository.BillingRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BillingService {

    private final BillingRepository billingRepository;

    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public Billing generateBill(Subscription subscription) {
        Billing bill = new Billing();

        bill.setSubscription(subscription);
        bill.setAmount(subscription.getPlan().getPrice());
        bill.setBillingDate(LocalDate.now());
        bill.setStatus("PAID");

        return billingRepository.save(bill);
    }
}