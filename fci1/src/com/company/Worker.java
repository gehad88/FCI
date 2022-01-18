package com.company;

import java.util.Date;

public class Worker extends Employee{
    private String workplace;


    public Worker(){

    }

    @Override
    public double getSalary(){
        return(super.getSalary()-0.1*super.getSalary());
    }

    public String getWorkplace() {
        return workplace;
    }

    public Worker(String firstName, String lastName, String Address, String NationalID, int age, double salary, Date signDate, String workplace){
        super(firstName,lastName,Address,NationalID,age,salary,signDate);

        this.workplace=workplace;
    }

    public void setWorkplace(String Workplace)
    {
        workplace=Workplace;
    }

    public String getWorkplace(String Workplace)
    {
        return workplace;
    }

    @Override
    public String toString(){
        return (super.toString()+"\nWORK PLACE : "+this.workplace+"\nSALARY : "+this.getSalary());
    }
    @Override
    public void ShowDetails() {
        System.out.println("***WORKER***");
        System.out.println(toString());
    }

}