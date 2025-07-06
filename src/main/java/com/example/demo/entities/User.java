package com.example.demo.entities;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    @Basic
    private Integer age;

    @OneToMany(cascade = CascadeType.ALL)
    private final List<Account> accounts;

    public User(String username, Integer age) {
        this();
        this.username = username;
        this.age = age;
    }

    public List<Account> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }


    public User(){
        this.accounts = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void addAccount(Account account){
        this.accounts.add(account);
    }
}
