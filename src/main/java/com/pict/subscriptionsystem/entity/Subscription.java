package com.pict.subscriptionsystem.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="subscriptions")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Plan plan;

    private LocalDate startDate;
    private LocalDate endDate;

    private String status; // ACTIVE / CANCELLED
}