package com.company;

import java.util.Date;

public class Instructor extends Employee {
    private String course_Name;

    public String getCourse_Name() {
        return course_Name;
    }

    public void setCourse_Name(String course_Name) {
        this.course_Name = course_Name;
    }

    public Instructor() {
    }

    public Instructor(String firstName, String lastName, String Address, String NationalID, int age, double salary, Date signDate) {
        super(firstName, lastName, Address, NationalID,age,salary,signDate);
        this.course_Name = course_Name;

    }

    public void setCourseName(String Course_Name) {

        this.course_Name = Course_Name;
    }

    public String getCourseName(String Course_Name) {
        return Course_Name;
    }
    @Override
    public double getSalary(){
        return(super.getSalary()+0.1*super.getSalary());
    }


    public String toString() {

        return (super.toString()+"\nCOURSE : " + this.course_Name + "\nSALARY : " + this.getSalary());
    }

    public void ShowDetails() {
        System.out.println("***Instructor***");
        System.out.println(toString());
    }
}