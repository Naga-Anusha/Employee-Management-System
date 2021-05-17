package org.launchcode.employeemanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
@Entity
public class Project extends AbstractEntity{

    @NotBlank(message = "Project Name is required.")
    @Size(min = 3, max = 50, message = "Project name must be between 3 and 50 characters")
    private String projectName;

    @NotBlank(message = "Project Manager is required.")
    @Size(min = 3, max = 50, message = "Manager name must be between 3 and 50 characters")
    private String projectManager;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private String startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "MM/dd/yyyy")
    private String endDate;

    public Project() { }

    public Project(String projectName, String projectManager, String startDate, String endDate){
        this.projectName = projectName;
        this.projectManager = projectManager;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectManager() {
        return projectManager;
    }

    public void setProjectManager(String projectManager) {
        this.projectManager = projectManager;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return projectName;
    }

}
