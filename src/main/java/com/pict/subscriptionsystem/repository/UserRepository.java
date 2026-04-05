package com.pict.subscriptionsystem.repository;

import com.pict.subscriptionsystem.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}