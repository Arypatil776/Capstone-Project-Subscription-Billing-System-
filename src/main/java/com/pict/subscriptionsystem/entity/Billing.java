package com.pict.subscriptionsystem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="billings")
public class Billing {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Subscription subscription;

    private double amount;
    private LocalDate billingDate;

    private String status; // PAID / PENDING
}