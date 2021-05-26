package org.launchcode.employeemanagementsystem.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Assignments extends AbstractEntity{

    private int noOfAssignments;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;

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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
