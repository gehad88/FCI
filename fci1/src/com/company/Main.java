
package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    static ArrayList<Person> prson=new ArrayList<>();      //polymorphism
    //static so all functions can deal with it easily without need to send parameter

    static Boolean checkID(String NationatID) {
        int count = 0;
        for (int i = 0; i < NationatID.length(); i++) {
            if (NationatID.charAt(i) >= 48 && NationatID.charAt(i) <= 57)
                count++;
        }
        if (count == 14)
            return true;
        else
            return false;
    }

    static Boolean checkName(String name) {
        if (checkID(name))
            return false;

        for (int i = 0; i < name.length(); i++) {
            if ((name.charAt(i) >= 'a' && name.charAt(i) <= 'z') || (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z')) ;
            else
                return false;
        }
        return true;
    }

    static int menu2() {          //use menu2 to determine person you want to deal with like student , graduated ,  instructor , technician , worker
        int choice2;
        try {
            Scanner sc = new Scanner(System.in);
            ArrayList<String> options = new ArrayList<String>();
            System.out.println();
            Collections.addAll(options, "Student", "Instructor", "Technician", "Administrator", "Worker");  //arraylist to make it easy to add or remove
            for (int i = 0; i < options.size(); i++)
                System.out.println((i + 1) + "  : " + options.get(i));

            do {
                System.out.println("Enter your choice : ");
                choice2 = sc.nextInt();
                if (choice2 > 7 || choice2 <= 0)
                    System.out.println("you Entered invalid value !");

            } while (choice2 > 7 || choice2 <= 0);
            return choice2;
        }
        catch (Exception ex) {
            System.out.println("YOU ENTERED SOME DETAILS WRONG !");
            menu1();
            return -1;
        }
    }

    static void menu1() {        //use menu1 to choose what to do like search or add or delete or edit or show or Exit
        int choice1;
        Scanner sc = new Scanner(System.in);
        ArrayList<String> options = new ArrayList<String>();
        System.out.println();
        Collections.addAll(options, "Search", "Add New", "Delete", "Edit", "Show All holders","Show Halls Details", "Exit");
        try {
            for (int i = 0; i < options.size(); i++)
                System.out.println(+(i + 1) + " : To " + options.get(i));
            do {
                System.out.println("Enter your choice : ");
                choice1 = sc.nextInt();
                if (choice1 > 7 || choice1 <= 0)
                    System.out.println("you Entered invalid value !");

            } while (choice1 > 7 || choice1 <= 0);

            if (choice1 == 1)    //search()
            {
                System.out.println("--------Search---------- ");
                if (search() == -1)
                    System.out.println("Not Exist !!!! ");               ////mmmmmmmm
                menu1();
            } else if (choice1 == 2)  //add()
                OptionsADD();
            else if (choice1 == 3)  //delete
                delete();
            else if (choice1 == 4)  //Edit
                edit();
            else if (choice1 == 5)    //show
                ShowAll();
            else if(choice1==6)
            {
                Halls halls=new Halls();
                halls.ShowDetails();
                menu1();
            }
            else if (choice1 == 6)    //Exit
                System.out.println("GoodBye..");
        }
        catch (Exception e)
        {
            System.out.println("YOU ENTERED SOME DETAILS WRONG !");
            menu1();
        }
    }

    static void OptionsADD() {
        int choice = menu2();    //call menu2 to know what kind of person to add
        if (choice == 1)
            student();
        else if (choice == 2)
            instructor();
        else if (choice == 3)
            technician();
        else if (choice == 4)
            administrator();
        else if (choice == 5)
            worker();
    }

    static Person person(Person p) {     //all child use this function to set value of first ,second name,address,Id,age then return to their fun to complete their details
        String firstName;
        String lastName;
        String Address;
        String NationalID;
        int age;

        try {
            System.out.println("--------ADD---------- ");
            Scanner sc = new Scanner(System.in);
            do {
                System.out.println("Enter First Name : ");
                firstName = sc.next();
                if (!checkName(firstName))
                    System.out.println("invalid ,Enter first name : ");
            } while (!checkName(firstName));

            do {
                System.out.println("Enter Last Name : ");
                lastName = sc.next();
                if (!checkName(lastName))
                    System.out.println("Invalid ,Enter last name : ");
            } while (!checkName(lastName));

            System.out.println("Enter your address : ");
            Address = sc.next();

            do {
                System.out.println("Enter Age : ");
                age = sc.nextInt();
                p.setAge(age);
                if (p.getAge() < 0)
                    System.out.println("Invalid , Enter Age : ");
            } while (p.getAge() < 0);


            do {
                NationalID = isExist();             //to make sure that id is not exist before add it
                if (NationalID.equals("0"))         //"0"  means this id is already exist
                {
                    System.out.println("Invalid");
                    NationalID = isExist();
                }
            } while (NationalID.equals("0"));

            p.setFirstName(firstName);
            p.setLastName(lastName);
            p.setAddress(Address);
            p.setNational_ID(NationalID);

        }
        catch (Exception x){
            System.out.println("YOU ENTERED SOME DETAILS WRONG !");
            menu1();
        }
        return p;
    }

    static void student() {
        Scanner sc = new Scanner(System.in);
        double gpa;
        int level;
        Student st = new Student();
        try {
            person(st);

            do {
                System.out.println("Enter GPA : ");
                gpa = sc.nextDouble();
                st.setGpa(gpa);
                if (st.getGpa() < 0)
                    System.out.println("Invalid ,Enter GPA : ");
            } while (st.getGpa() < 0);

            do {
                System.out.println("level : ");
                level = sc.nextInt();
                st.setLevel(level);
                if (st.getLevel() < 0)
                    System.out.println("Invalid ,Enter level : ");
            } while (st.getLevel() < 0);

            prson.add(st);
            System.out.println("\n***Add is Done***");
                menu1();
        }
        catch (Exception exx){
            System.out.println("YOU ENTERED SOME DETAILS WRONG !");
            menu1();
        }
    }

    static void technician() {
        double salary;
        String specialize;

        try {
            Technican t = new Technican();
            person(t);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter specialize : ");
            specialize=sc.next();
           do {
               System.out.println("Enter Salary : ");
               salary = sc.nextDouble();
               t.setSalary(salary);
               if(t.getSalary()==0)
                   System.out.println("Invalid");
           }while (t.getSalary()==0);

            t.setSpecialize(specialize);
            prson.add(t);
            System.out.println("\n***Add is Done***");
            menu1();
        }
        catch (Exception ex){
            System.out.println("YOU ENTERED SOME DETAILS WRONG !");
            menu1();
        }

    }

    static void instructor() {
        String course_Name;
        double salary;
        Instructor ins = new Instructor();
        try {
            person(ins);
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter course Name : ");
            course_Name = sc.next();
            do {
                System.out.println("Enter Salary : ");
                salary = sc.nextDouble();
                ins.setSalary(salary);
                if(ins.getSalary()==0)
                    System.out.println("Invalid");
            }while (ins.getSalary()==0);

            ins.setCourseName(course_Name);
            prson.add(ins);
            System.out.println("\n***Add is Done***");
            menu1();
        }
        catch(Exception j){
            System.out.println("YOU ENTERED SOME DETAILS WRONG !");
            menu1();
        }

    }

    static void administrator() {
        String department;
        double salary;
        Administrator adm = new Administrator();
        try {
            person(adm);
            Scanner sc = new Scanner(System.in);
            do {
                System.out.println("Enter Salary : ");
                salary = sc.nextDouble();
                adm.setSalary(salary);
                if(adm.getSalary()==0)
                    System.out.println("Invalid");
            }while (adm.getSalary()==0);
            System.out.println("Enter department : ");
            department = sc.next();

            adm.setDepartment(department);
            adm.setSalary(salary);

            prson.add(adm);
            System.out.println("\n***Add is Done***");
            menu1();
        }
        catch (Exception l){
            System.out.println("YOU ENTERED SOME DETAILS WRONG !");
            menu1();
        }

    }

    static void worker() {
        String workplace;
        double salary;
        Worker wo = new Worker();
        try {
            person(wo);
            Scanner sc = new Scanner(System.in);
            do {
                System.out.println("Enter Salary : ");
                salary = sc.nextDouble();
                wo.setSalary(salary);
                if(wo.getSalary()==0)
                    System.out.println("Invalid");
            }while (wo.getSalary()==0);
            System.out.println("Enter Work Place : ");
            workplace = sc.next();

            wo.setSalary(salary);
            wo.setWorkplace(workplace);

            prson.add(wo);
            System.out.println("\n***Add is Done***");
            menu1();
        }
        catch (Exception ke){
            System.out.println("YOU ENTERED SOME DETAILS WRONG !!!!");
            menu1();
        }

    }

    static int search() {
        String NationaltID;           //dont need exception cause there is checkID function to make sure of ID is number and 14 digits
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter National ID : ");
            NationaltID = sc.next();
            if (!checkID(NationaltID))
                System.out.println("Invalid ,Enter Nationality ID");
        } while (!checkID(NationaltID));
        int i;
        for (i = 0; i < prson.size(); i++) {
            if (prson.get(i).getNational_ID().equals(NationaltID)) {
                prson.get(i).ShowDetails();
                return i;
            }
        }
        return -1;
    }

    static String isExist() {           //to make sure the new nationality is not exist already in the System and consit of 14 digits
        String NationaltID;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Enter Nationality ID : ");
            NationaltID = sc.next();
            if (!checkID(NationaltID))
                System.out.println("Invalid ,Enter Nationality ID");
        } while (!checkID(NationaltID));


        for (Person person : prson) {
            if (person.getNational_ID().equals(NationaltID))
                return "0";
        }
        return NationaltID;
    }

    static void edit() {
        System.out.println("--------Edit---------- ");
        //int choice = menu2();
        int index = search();
        try {


            Scanner sc = new Scanner(System.in);
            if (index >= 0)    //1 means that id is already exist
            {
                String firstName;
                String lastName;
                String Address;
                int age;

                System.out.println("Enter first name : ");
                firstName = sc.next();
                System.out.println("Enter Last name : "); //tttttttttttttttttttttest watch out there are many exception
                lastName = sc.next();
                System.out.println("Enter Address : ");
                Address = sc.next();
                System.out.println("Age : ");
                age = sc.nextInt();

                prson.get(index).setFirstName(firstName);
                prson.get(index).setLastName(lastName);
                prson.get(index).setAddress(Address);
                prson.get(index).setAge(age);

                System.out.println("***Edit***");


            } else if (index == -1)
                System.out.println("Invalid value");
                 menu1();
        }
        catch (Exception ex){
            System.out.println("YOU ENTERED SOME DETAILS WRONG !!");
            menu1();
        }
    }

    static void delete() {
        System.out.println("--------delete---------- ");
        int index = search();
        if (index >= 0) {
            prson.remove(index);
            System.out.println("\n***REMOVE IS DONE***");
        }
        menu1();
    }

    static void ShowAll() {
        for (int i = 0; i < prson.size(); i++) {
            prson.get(i).ShowDetails();                  //use interface
        }
        menu1();
    }

    public static void main(String[] args) {
        menu1();

    }
}