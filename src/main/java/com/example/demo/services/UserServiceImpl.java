package com.example.demo.services;

import com.example.demo.entities.Account;
import com.example.demo.entities.User;
import com.example.demo.repositories.AccountRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public void registerUser(User user) {

        Account account = new Account();
        user.addAccount(account);
        userRepository.save(user);
    }

    @Override
    public Optional<User> find(String username) {
        return userRepository.findByUsername(username);
    }
}
