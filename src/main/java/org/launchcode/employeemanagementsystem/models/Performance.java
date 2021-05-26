package org.launchcode.employeemanagementsystem.models;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class Performance extends AbstractEntity{

    private String performance;

    @ManyToOne
    private User user;

    public Performance() { }

    public Performance(String performance){
        this.performance = performance;
    }

    public String getPerformance() {
        return performance;
    }

    public void setPerformance(String performance) {
        this.performance = performance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
