package org.launchcode.employeemanagementsystem.models;

import java.util.Objects;

public class EmployeeProject {

    private int projectId;

    private String projectName;

    private String projectManager;

    private String startDate;

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
