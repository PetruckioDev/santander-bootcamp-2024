package com.petruckiodev.santander_bootcamp_2024.service;

import com.petruckiodev.santander_bootcamp_2024.model.User;

public interface UserService {
    User findById(Long id);
    User createUser(User user);
}
