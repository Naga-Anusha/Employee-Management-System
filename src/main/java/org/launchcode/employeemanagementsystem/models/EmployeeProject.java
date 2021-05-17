package org.launchcode.employeemanagementsystem.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class EmployeeProject extends AbstractEntity{
    @ManyToOne
    private Project project;

    public EmployeeProject() { }

    public EmployeeProject(Project project) {
        this.project = project;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
