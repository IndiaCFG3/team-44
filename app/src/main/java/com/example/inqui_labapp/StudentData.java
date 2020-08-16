package com.example.inqui_labapp;

public class StudentData {
    String name, email, schoolid, schoolname, username, password, sclass, authority;

    public StudentData(String name, String email, String schoolid, String schoolname, String username, String password, String sclass, String authority) {
        this.name = name;
        this.email = email;
        this.schoolid = schoolid;
        this.schoolname = schoolname;
        this.username = username;
        this.password = password;
        this.sclass = sclass;
        this.authority = authority;
    }
    public StudentData() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSchoolid() {
        return schoolid;
    }

    public void setSchoolid(String schoolid) {
        this.schoolid = schoolid;
    }

    public String getSchoolname() {
        return schoolname;
    }

    public void setSchoolname(String schoolname) {
        this.schoolname = schoolname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSclass() {
        return sclass;
    }

    public void setSclass(String sclass) {
        this.sclass = sclass;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
