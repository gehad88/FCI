
package com.company;

import java.util.Date;

class Technican extends Employee {
    private  String specialize;
    Technican(){

    }

    public Technican(String firstName, String lastName, String Address,String NationalID,int age,double salary,Date signDate) {
        super(firstName, lastName, Address, NationalID, age, salary, signDate);
        this.specialize=specialize;
    }

    public String getSpecialize() {
        return specialize;
    }

    public void setSpecialize(String specialize) {
        this.specialize = specialize;
    }

    public double getSalary(){
        return(super.getSalary()+0.15*super.getSalary());
    }
    public String toString() {

        return (super.toString()+"\nSalary : "+this.getSalary()+"\nSpecialize : "+this.specialize);
    }


    public void ShowDetails() {
        System.out.println("***Technician***");
        System.out.println(toString());
    }
}