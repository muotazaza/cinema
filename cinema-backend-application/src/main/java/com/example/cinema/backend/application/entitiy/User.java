
package com.example.cinema.backend.application.entitiy;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "user_details")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id ;
    @Column(name = "user_name", nullable = false)
    private  String userName;


    @Column(name = "password", nullable = false)
    private String password;

    @Column(nullable = false,name = "email")
    private String email;

    @Column(name = "location")
    private String location;

    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "user")
    private List<Transactions> transactions;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role",joinColumns =
    @JoinColumn(name = "user_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id",referencedColumnName = "id"))
    private List<Role> roles=new ArrayList<>();

    public User() {

    }


    public User(String userName, String password, String email,
                String location, String role,
                List<Transactions> transactions, List<Role> roles) {
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.location = location;
        this.role = role;
        this.transactions = transactions;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Transactions> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", location='" + location + '\'' +
                ", role='" + role + '\'' +
                ", transactions=" + transactions +
                ", roles=" + roles +
                '}';
    }
}