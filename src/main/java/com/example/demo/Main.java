package com.example.demo;

import com.example.demo.entities.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.services.AccountServiceImpl;
import com.example.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class Main implements CommandLineRunner{

    private final UserService userService;
    private final AccountServiceImpl accountService;

    @Autowired
    public Main(UserService userService, AccountServiceImpl accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }



    @Override
    public void run(String... args) throws Exception {
        System.out.println("Started from Spring!!!");

        Optional<User> user = userService.find("mladen");
        accountService.transferMoney(BigDecimal.ONE, user.get(), 1L);


//        accountService.withdrawMoney(new BigDecimal(12), 2L);
//        userService.registerUser(new User("mladen", 22));

    }


}
