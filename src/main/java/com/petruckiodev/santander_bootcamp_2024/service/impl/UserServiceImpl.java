package com.petruckiodev.santander_bootcamp_2024.service.impl;

import com.petruckiodev.santander_bootcamp_2024.model.User;
import com.petruckiodev.santander_bootcamp_2024.repository.UserRepository;
import com.petruckiodev.santander_bootcamp_2024.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User createUser(User user) {
        if (user == null) {
            throw new NullPointerException("User is null");
        }

        if (userRepository.existsById(user.getId())) {
            throw new IllegalArgumentException("This user id already exists.");
        }

        if (userRepository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new IllegalArgumentException("This account number already exists.");
        }

        return userRepository.save(user);
    }
}
