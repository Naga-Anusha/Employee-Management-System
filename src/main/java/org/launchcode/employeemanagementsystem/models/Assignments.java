package org.launchcode.employeemanagementsystem.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Assignments extends AbstractEntity{

    private int noOfAssignments;

    private int userId;

    public Assignments() { }

    public Assignments(int noOfAssignments){
        this.noOfAssignments = noOfAssignments;
    }

    public int getNoOfAssignments() {
        return noOfAssignments;
    }

    public void setNoOfAssignments(int noOfAssignments) {
        this.noOfAssignments = noOfAssignments;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
