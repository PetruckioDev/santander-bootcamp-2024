package com.petruckiodev.santander_bootcamp_2024.repository;

import com.petruckiodev.santander_bootcamp_2024.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByAccountNumber(String accountNumber);
}
