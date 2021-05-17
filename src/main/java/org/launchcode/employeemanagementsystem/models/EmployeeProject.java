package org.launchcode.employeemanagementsystem.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class EmployeeProject extends AbstractEntity{
    @ManyToOne
    private Project project;

    @OneToOne
    private User user;

    public EmployeeProject() { }

    public EmployeeProject(Project project,User user) {
        this.project = project;
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
