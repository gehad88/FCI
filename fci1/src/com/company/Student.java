package com.company;

public class Student extends Person {
    private int level;
    private double gpa;


    Student(){

   }

    public Student(String firstName, String lastName, String address, String national_ID, int age, int level,double gpa) {
        super(firstName, lastName, address, national_ID, age);
        this.level = level;
        this.gpa=gpa;
    }


    public void setLevel(int level) {
       if(level>0&&level<=4)
        this.level = level;
       else
           this.level=-1;
    }
    public void setGpa(double gpa)
    {
        if(gpa>=0&&gpa<=4)
            this.gpa=gpa;
        else
            this.gpa=-1;
    }

    public int getLevel(){
        return level;
    }

    public double getGpa() {
        return gpa;
    }
    //tostring
    @Override
    public String toString() {

        return (super.toString()+"\nGpa = " + this.gpa + "\n" + "level = " + this.level);
    }
    @Override
    public void ShowDetails() {
        System.out.println("***STUDENT***");
        System.out.println(toString());
    }


}