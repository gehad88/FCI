package com.company;

import java.util.InputMismatchException;

public abstract class Person implements Details {
    private String firstName;
    private String lastName;
    private String Address;
    private String National_ID;
    private int age;

    Person(){

    }

    Person(String firstName,String lastName,String Address,String National_ID,int age )
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this .Address =Address;
        this.National_ID=National_ID;
        this.age = age;

    }



    public void setFirstName (String firstName ) {

        this.firstName = firstName;
    }


    public String getFirstName() {

        return this.firstName;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return this.lastName;

    }

    public void setAddress(String Address) {
        this.Address = Address;

    }

    public String getAddress() {
        return this.Address;
    }


    public void setNational_ID(String national_ID) {
        National_ID = national_ID;
    }

    public String getNational_ID() {
        return National_ID;
    }

    public void setAge(int age) {
        if(age>0)
        this.age = age;
        else
            this.age=-1;

    }
    @Override
    public boolean equals(Object e)
    {
        return ((Person)e).getNational_ID().equals(getNational_ID());
    }
    public int getAge()
    {
        return this.age;
    }
    @Override
    public  String toString(){
        return("NAME : "+this.firstName +" "+this.lastName+"\nADDRESS : "+ this.Address+"\nNATIONAL ID : "+this.National_ID+"\nAGE : "+this.age);
    }
    @Override
    public void ShowDetails() {
        System.out.println(toString());
    }
}


