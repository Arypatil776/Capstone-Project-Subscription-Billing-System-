package com.pict.subscriptionsystem.repository;

import com.pict.subscriptionsystem.entity.Plan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanRepository extends JpaRepository<Plan, Long> {
}