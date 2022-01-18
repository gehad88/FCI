package com.company;
import java.util.Date;

public abstract class Employee extends Person {
    private double salary;
    private Date signDate;
    Employee(){
        signDate=new Date();
    }

    Employee(String firstName, String lastName, String Address,String NationalID,int age,double salary,Date signDate) {
        super(firstName, lastName, Address,NationalID,age);
        this.salary = salary;
        signDate=new Date();               //composition
    }

    public void setSalary(double salary) {
        if(salary>0)
        this.salary = salary;
        else
            this.salary=0;
    }

    public double getSalary(){
        return salary;
    }

    public Date getSignDate() {
        return signDate;
    }

    public String toString(){
        return(super.toString()+/*"\nSALARY : "+this.getSalary()+*/"\nDATE OF SIGN : "+signDate.toString());
    }
    public void ShowDetails(){
        System.out.println(toString());
    }



}