package com.pict.subscriptionsystem.service;

import com.pict.subscriptionsystem.entity.*;
import com.pict.subscriptionsystem.repository.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final PlanRepository planRepository;
    private final BillingService billingService;

    public SubscriptionService(SubscriptionRepository subscriptionRepository, UserRepository userRepository, PlanRepository planRepository, BillingService billingService) {
        this.subscriptionRepository = subscriptionRepository;
        this.userRepository = userRepository;
        this.planRepository = planRepository;
        this.billingService = billingService;
    }

    public Subscription subscribe(Long userId, Long planId) {

        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("User Not Found !!"));
        Plan plan = planRepository.findById(planId).orElseThrow(()->new RuntimeException("Plan ID not Found !!"));

        Subscription sub = new Subscription();
        sub.setUser(user);
        sub.setPlan(plan);
        sub.setStartDate(LocalDate.now());

        if (plan.getDuration().equalsIgnoreCase("MONTHLY")) {
            sub.setEndDate(LocalDate.now().plusMonths(1));
        } else {
            sub.setEndDate(LocalDate.now().plusYears(1));
        }

        sub.setStatus("ACTIVE");

        Subscription saved = subscriptionRepository.save(sub);

        // Generate bill
        billingService.generateBill(saved);

        return saved;
    }

    public Subscription cancel(Long subscriptionId) {
        Subscription sub = subscriptionRepository.findById(subscriptionId).orElseThrow();
        sub.setStatus("CANCELLED");
        return subscriptionRepository.save(sub);
    }

    public List<Subscription> getUserSubscriptions(Long userId) {
        return subscriptionRepository.findByUserId(userId);
    }
}