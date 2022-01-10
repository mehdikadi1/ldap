package com.ensate.ldap.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="userdatabase")
public class User {
    @Id
    @Column(name="uid")
    public String uid;
    @Column(name="fullname")
    public String fullname;
    @Column(name="lastname")
    public String lastname;
    @Column(name="givenname")
    public String givenname;
    @Column(name="mail")
    public String mail;
    @Column(name="gidNumber")
    public String gidNumber;


    @ManyToMany(fetch= FetchType.LAZY)
    @JoinTable(
            joinColumns= {@JoinColumn(name="user_id")},
            inverseJoinColumns= {@JoinColumn(name="role_id")}
    )
    @JsonIgnore
    private List<Role> roles ;

    public String getUid() {
        return uid;
    }

    public String getFullname() {
        return fullname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getGivenname() {
        return givenname;
    }

    public String getMail() {
        return mail;
    }

    public String getGidNumber() {
        return gidNumber;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setGidNumber(String gidNumber) {
        this.gidNumber = gidNumber;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserDao{" +
                "uid='" + uid + '\'' +
                ", fullname='" + fullname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", givenname='" + givenname + '\'' +
                ", mail='" + mail + '\'' +
                ", gidNumber='" + gidNumber + '\'' +
                ", roles=" + roles +
                '}';
    }

    }

