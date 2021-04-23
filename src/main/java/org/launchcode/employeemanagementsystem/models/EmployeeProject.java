package org.launchcode.employeemanagementsystem.models;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.Objects;
@Entity
public class EmployeeProject {

    @Id
    @GeneratedValue
    private int projectId;

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

    public EmployeeProject() { }

    public EmployeeProject(String projectName, String projectManager, String startDate,String endDate){
        this.projectName = projectName;
        this.projectManager = projectManager;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public int getProjectId() {
        return projectId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeProject that = (EmployeeProject) o;
        return projectId == that.projectId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(projectId);
    }
}
