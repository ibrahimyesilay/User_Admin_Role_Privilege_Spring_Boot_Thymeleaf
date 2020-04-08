package com.yesilay.stocktrace.model;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity(name = "users")
@Table(uniqueConstraints = @UniqueConstraint(columnNames = "user_email"))
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="user_id", nullable = false)
    private int userId;

//    @Column(name="user_name", nullable = false, length = 40)
//    private String userName;

    @Column(name="user_pass", nullable = false)
    private String userPass;
    @Transient
    @Column(name="user_pass_repeat", nullable = false)
    private String userPassR;

    @Column(name="user_email", nullable = false, length = 100)
    private String userEmail;
    @Transient
    @Column(name="user_email_repeat", nullable = false, length = 100)
    private String userEmailR;

    @Column(name="user_first_name", nullable = false, length = 40)
    private String firstName;
    @Column(name="user_last_name", nullable = false, length = 40)
    private String lastName;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="user_bDay")
    private Date bDay;

    @Column(name="user_gender", length = 10)
    private String gender;

    @Column(name="user_address")
    private String address;

    @Column(name="user_profile_photo")
    private String profilePhoto;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="user_created", nullable = false, updatable = false)
    private Date userCreated;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="user_last_Login", nullable = false)
    private Date userLastLogin;


    @Column(name="user_active")
    private Boolean userActive;

    @Column(name="user_terms", nullable = false)
    private Boolean userTerms;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "jointable_usersrole",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "role_id"))
    private Collection< Roles > roleList;



    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "jointable_watchlist",
            joinColumns = @JoinColumn(name =  "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<StockWatchList> watchList;


    public Users(
            int userId,
            String userName,
            String userPass,
            String userPassR,
            String firstName,
            String lastName,
            Date bDay,
            String userEmail,
            String userEmailR,
            String gender,
            String address,
            String profilePhoto,
            Date userCreated,
            Date userLastLogin,
            Boolean userTerms,
            Boolean userActive,
            Collection<Roles> roleList,
            Collection<StockWatchList> watchList) {
        this.userEmail =userEmail;
        this.userEmailR = userEmailR;
        this.userId = userId;
     //   this.userName=userName;
        this.userPass=userPass;
        this.userPassR=userPassR;
        this.firstName=firstName;
        this.lastName=lastName;
        this.bDay=bDay;
        this.gender=gender;
        this.address=address;
        this.profilePhoto=profilePhoto;
        this.userCreated=userCreated;
        this.userLastLogin=userLastLogin;
        this.userActive=userActive;
        this.roleList=roleList;
        this.watchList=watchList;
        this.userTerms=userTerms;
    }

    public Users(
            int userId,
            String userName,
            String userPass,
            String userPassR,
            String firstName,
            String lastName,
            Boolean userTerms,
            Date bDay,
            String userEmail,
            String userEmailR,
            String gender,
            String address,
            String profilePhoto,
            Date userCreated,
            Date userLastLogin,
            Boolean userActive,
            Collection<Roles> roleList) {
        this.userEmail =userEmail;
        this.userEmailR = userEmailR;
        this.userId = userId;
       // this.userName=userName;
        this.userPass=userPass;
        this.userPassR=userPassR;
        this.firstName=firstName;
        this.lastName=lastName;
        this.bDay=bDay;
        this.gender=gender;
        this.address=address;
        this.profilePhoto=profilePhoto;
        this.userCreated=userCreated;
        this.userLastLogin=userLastLogin;
        this.userActive=userActive;
        this.roleList=roleList;
        this.userTerms=userTerms;
    }

    public Users(
            int userId,
            String userName,
            String userPass,
            String userPassR,
            String firstName,
            String lastName,
            Boolean userTerms,
            Date bDay,
            String userEmail,
            String userEmailR,
            String gender,
            String address,
            String profilePhoto,
            Date userCreated,
            Date userLastLogin,
            Boolean userActive)
            {
        this.userEmail =userEmail;
        this.userEmailR = userEmailR;
        this.userId = userId;
       // this.userName=userName;
        this.userPass=userPass;
        this.userPassR=userPassR;
        this.firstName=firstName;
        this.lastName=lastName;
        this.bDay=bDay;
        this.gender=gender;
        this.address=address;
        this.profilePhoto=profilePhoto;
        this.userCreated=userCreated;
        this.userLastLogin=userLastLogin;
        this.userActive=userActive;
        this.userTerms=userTerms;
    }



    public Users() {
    }

    @Override
    public String toString() {
        return "Users{" +
                "userId=" + userId +
              //  ", userName='" + userName + '\'' +
                ", userPass='" + userPass + '\'' +
                ", userPassR='" + userPassR + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", userEmailR='" + userEmailR + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", bDay=" + bDay +
                ", gender='" + gender + '\'' +
                ", address='" + address + '\'' +
                ", profilePhoto='" + profilePhoto + '\'' +
                ", userCreated=" + userCreated +
                ", userLastLogin=" + userLastLogin +
                ", userActive=" + userActive +
                ", userTerms=" + userTerms +
                ", roleList=" + roleList +
                ", watchList=" + watchList +
                '}';
    }

    public Boolean getUserTerms() {
        return userTerms;
    }

    public void setUserTerms(Boolean userTerms) {
        this.userTerms = userTerms;
    }


    public void setWatchList(Collection<StockWatchList> watchList) {
        this.watchList = watchList;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

//    public String getUserName() {
//        return userName;
//    }

//    public void setUserName(String userName) {
//        this.userName = userName;
//    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(String profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public Date getUserCreated() {
        return userCreated;
    }

    public void setUserCreated(Date userCreated) {
        this.userCreated = userCreated;
    }

    public Date getUserLastLogin() {
        return userLastLogin;
    }

    public void setUserLastLogin(Date userLastLogin) {
        this.userLastLogin = userLastLogin;
    }

    public Boolean getUserActive() {
        return userActive;
    }

    public void setUserActive(Boolean userActive) {
        this.userActive = userActive;
    }


    public Collection<StockWatchList> getWatchList() {
        return watchList;
    }

    public void setWatchList(List<StockWatchList> watchList) {
        this.watchList = watchList;
    }


    public Collection<Roles> getRoleList() {
        return roleList;
    }

    public void setRoleList(Collection<Roles> roleList) {
        this.roleList = roleList;
    }
}
