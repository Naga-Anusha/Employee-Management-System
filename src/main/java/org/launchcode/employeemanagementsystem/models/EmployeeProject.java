package org.launchcode.employeemanagementsystem.models;

import java.util.Date;
import java.util.Objects;

public class EmployeeProject {

    private int projectId;

    private String projectName;

    private String projectManager;

    private Date startDate;

    private Date endDate;

    public EmployeeProject() { }

    public EmployeeProject(String projectName, String projectManager, Date startDate,Date endDate){
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
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
