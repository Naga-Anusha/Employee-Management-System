package org.launchcode.employeemanagementsystem.models;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class UserDetails extends AbstractEntity{

    @NotBlank(message = "First Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String firstName;

    @NotBlank(message = "Last Name is required.")
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters")
    private String lastName;

    @Email(message="Invalid Email. Try again!")
    private String contactEmail;

    @Size(max = 500, message = "Address too long!")
    private String address;

    @Size(max=10,message= "Phone number must be less than 10")
    private String phoneNumber;

    @OneToOne(mappedBy = "userDetails")
    private User user;

    public UserDetails() { }

    public UserDetails(String firstName, String lastName, String contactEmail, String address, String phoneNumber, Project project) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactEmail = contactEmail;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
