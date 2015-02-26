package com.ayush.finalproject;

public class Student {
	 private String rollno;  
	 private String class1;
	 private String phoneno;
     private String name;  

     public String getRollno() {  

         return rollno;  

     }  

    

     public void setRollno(String rollno) {  

         this.rollno = rollno;  

     }
     public String getClass1() {  

         return this.class1;  

     }  

    

     public void setClass1(String class1) {  

         this.class1 = class1;  

     }

     public String getPhoneno() {  

         return this.phoneno;  

     }  

    

     public void setPhoneno(String phoneno) {  

         this.phoneno = phoneno;  

     }  

    

     public String getName() {  

         return this.name;  

     }  

    

     public void setName(String name) {  

         this.name = name;  

     }  

    

     @Override 

     public String toString() {  

         return name;  

     }  

}
