package com.pict.subscriptionsystem.controller;

import com.pict.subscriptionsystem.entity.Subscription;
import com.pict.subscriptionsystem.service.SubscriptionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {

    private final SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @PostMapping("/subscribe")
    public Subscription subscribe(@RequestParam Long userId,
                                  @RequestParam Long planId) {
        return subscriptionService.subscribe(userId, planId);
    }

    @PostMapping("/cancel")
    public Subscription cancel(@RequestParam Long subscriptionId) {
        return subscriptionService.cancel(subscriptionId);
    }

    @GetMapping("/{userId}")
    public List<Subscription> getUserSubscriptions(@PathVariable Long userId) {
        return subscriptionService.getUserSubscriptions(userId);
    }
}