package org.launchcode.employeemanagementsystem.models;

import org.dom4j.tree.AbstractEntity;

import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
public class AdminUser extends AbstractEntity {
    @NotNull
    private String username;

    @NotNull
    private String pwHash;

    public AdminUser() {}

    public AdminUser(String username, String password) {
        this.username = username;
        this.pwHash = password;
    }

    public String getUsername() {
        return username;
    }
}
