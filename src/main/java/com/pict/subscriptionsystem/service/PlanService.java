package com.pict.subscriptionsystem.service;

import com.pict.subscriptionsystem.entity.Plan;
import com.pict.subscriptionsystem.repository.PlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanService {

    private final PlanRepository planRepository;

    public PlanService(PlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public Plan createPlan(Plan plan) {
        return planRepository.save(plan);
    }

    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }
}