package org.launchcode.employeemanagementsystem.models;


import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Entity
public class User extends AbstractEntity {

    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    @NotNull
    private String role;

    @OneToOne(cascade = CascadeType.ALL)
    private UserDetails userDetails;

    @OneToOne(mappedBy = "user")
    private Assignments assignments;

    private static final BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public User() { }

    public User(String username , String password,String role,UserDetails userDetails) {
        this.username = username;
        this.pwHash = encoder.encode(password);
        this.role = role;
        this.userDetails = userDetails;
    }

    public String getUsername() {
        return username;
    }

    public String getRole() {
        return role;
    }

    public boolean isMatchingPassword(String password) {
        return encoder.matches(password, pwHash);
    }

    public boolean isMatchingRole(String givenRole) {
        return givenRole.equals(role);
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public Assignments getAssignments() {
        return assignments;
    }

    public void setAssignments(Assignments assignments) {
        this.assignments = assignments;
    }
}

