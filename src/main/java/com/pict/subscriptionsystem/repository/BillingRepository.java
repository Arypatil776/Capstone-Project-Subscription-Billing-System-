package com.pict.subscriptionsystem.repository;

import com.pict.subscriptionsystem.entity.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BillingRepository extends JpaRepository<Billing, Long> {

    List<Billing> findBySubscriptionId(Long subscriptionId);
}