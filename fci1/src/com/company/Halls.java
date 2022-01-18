package com.company;

public class Halls {                     //class without inheritance
    private static final int lectureHalls=30;
    private static final int labsNumbers=20;
    Halls(){

    }
    public void ShowDetails(){
        System.out.print("NUMBER OF LECTURE HALLS IS : "+lectureHalls+"\nNUMBER PF LABS IS :"+labsNumbers);
    }

}