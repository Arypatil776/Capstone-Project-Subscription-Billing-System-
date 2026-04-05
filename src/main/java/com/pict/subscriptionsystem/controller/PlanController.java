package com.pict.subscriptionsystem.controller;

import com.pict.subscriptionsystem.entity.Plan;
import com.pict.subscriptionsystem.service.PlanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")
public class PlanController {

    private final PlanService planService;

    public PlanController(PlanService planService) {
        this.planService = planService;
    }

    @PostMapping
    public Plan createPlan(@RequestBody Plan plan) {
        return planService.createPlan(plan);
    }

    @GetMapping
    public List<Plan> getPlans() {
        return planService.getAllPlans();
    }
}