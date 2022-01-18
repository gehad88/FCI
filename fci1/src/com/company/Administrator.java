package com.company;

import java.util.Date;

class Administrator extends Employee {
    private String department;


    public Administrator() {
    }

    public Administrator(String firstName, String lastName, String Address, String NationalID, int age, double salary, Date signDate) {
        super(firstName, lastName, Address,NationalID, age,salary,signDate);
        this.department = department;

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String Department) {
        this.department = Department;
    }

    public String getDepartment(String Department) {
        return this.department;
    }

    @Override
    public double getSalary()
    {
        return(super.getSalary()+0.2*super.getSalary());
    }
    @Override
    public String toString() {

        return(super.toString()+"\nDEPARTMENT : " + this.department + "\nSALARY : " + this.getSalary());
    }
    @Override
    public void ShowDetails() {
        System.out.println("***Administrator***");
        System.out.println(toString());
    }
}