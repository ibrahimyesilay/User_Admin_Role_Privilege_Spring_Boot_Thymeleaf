package com.yesilay.stocktrace.web.dto;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;

import com.yesilay.stocktrace.constraint.FieldMatch;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@FieldMatch.List({
        @FieldMatch(first = "userPass", second = "userPassR", message = "The password fields must match"),
        @FieldMatch(first = "userEmail", second = "userEmailR", message = "The email fields must match")
})
public class UserRegistrationDto {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String userPass;

    @NotEmpty
    private String userPassR;

//    @NotEmpty
//    private String userName;

    @Email
    @NotEmpty
    private String userEmail;



    @Email
    @NotEmpty
    private String userEmailR;

    @AssertTrue
    private Boolean userTerms;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date bDay;

    public UserRegistrationDto() {
    }

    public UserRegistrationDto(@NotEmpty String firstName, @NotEmpty String lastName, @NotEmpty String userPass, @NotEmpty String userPassR, @Email @NotEmpty String userEmail, @Email @NotEmpty String userEmailR, @AssertTrue Boolean userTerms, @Past Date bDay, @NotEmpty String gender) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userPass = userPass;
        this.userPassR = userPassR;
        this.userEmail = userEmail;
        this.userEmailR = userEmailR;
        this.userTerms = userTerms;
        this.bDay = bDay;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "UserRegistrationDto{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userPassR='" + userPassR + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userEmailR='" + userEmailR + '\'' +
                ", userTerms=" + userTerms +
                ", bDay=" + bDay +
                ", gender='" + gender + '\'' +
                '}';
    }

    @NotEmpty
    private String gender;

    public Date getbDay() {
        return bDay;
    }

    public void setbDay(Date bDay) {
        this.bDay = bDay;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserPassR() {
        return userPassR;
    }

    public void setUserPassR(String userPassR) {
        this.userPassR = userPassR;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserEmailR() {
        return userEmailR;
    }

    public void setUserEmailR(String userEmailR) {
        this.userEmailR = userEmailR;
    }

    public Boolean getUserTerms() {
        return userTerms;
    }

    public void setUserTerms(Boolean userTerms) {
        this.userTerms = userTerms;
    }

//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }

}