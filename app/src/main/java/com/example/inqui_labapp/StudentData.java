package com.example.inqui_labapp;

public class StudentData {
    String Name, SchoolName, StudentClass, Email, Password, Authority;

    public StudentData() {

    }
    public StudentData(String name, String schoolName, String studentClass, String email, String password, String authority) {
        Name = name;
        SchoolName = schoolName;
        StudentClass = studentClass;
        Email = email;
        Password = password;
        Authority = authority;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSchoolName() {
        return SchoolName;
    }

    public void setSchoolName(String schoolName) {
        SchoolName = schoolName;
    }

    public String getStudentClass() {
        return StudentClass;
    }

    public void setStudentClass(String studentClass) {
        StudentClass = studentClass;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getAuthority() {
        return Authority;
    }

    public void setAuthority(String authority) {
        Authority = authority;
    }
}
