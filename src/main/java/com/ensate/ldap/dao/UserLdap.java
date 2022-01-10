package com.ensate.ldap.dao;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.ldap.odm.annotations.Attribute;
import org.springframework.ldap.odm.annotations.Entry;
import org.springframework.ldap.odm.annotations.Id;
import javax.naming.Name;

@Entry(objectClasses = { "inetOrgPerson", "posixAccount", "top" })
public class UserLdap {

    @Id @JsonIgnore
    private Name dn;
    @Attribute(name="cn")
    private String fullname;
    @Attribute(name="gidNumber")
    private String gidNumber;
    @Attribute(name="givenname")
    private String givenname;
    @Attribute(name="sn")
    private String lastname;
    @Attribute(name="mail")
    private String mail;
    @Attribute(name="uid")
    private String uid;
    @Attribute(name="uidnumber")
    private String uidNumber;
    @Attribute(name="userpassword")
    private String password;

    public Name getDn() {
        return dn;
    }

    public String getFullname() {
        return fullname;
    }

    public String getGidNumber() {
        return gidNumber;
    }

    public String getGivenname() {
        return givenname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getMail() {
        return mail;
    }

    public String getUid() {
        return uid;
    }

    public String getUidNumber() {
        return uidNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setDn(Name dn) {
        this.dn = dn;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setGidNumber(String gidNumber) {
        this.gidNumber = gidNumber;
    }

    public void setGivenname(String givenname) {
        this.givenname = givenname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public void setUidNumber(String uidNumber) {
        this.uidNumber = uidNumber;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "dn=" + dn +
                ", fullname='" + fullname + '\'' +
                ", gidNumber='" + gidNumber + '\'' +
                ", givenname='" + givenname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", mail='" + mail + '\'' +
                ", uid='" + uid + '\'' +
                ", uidNumber='" + uidNumber + '\'' +
                ", password='" + password + '\'' +
                '}';
    }


    }

