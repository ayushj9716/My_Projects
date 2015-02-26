package com.ayush.finalproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBase extends SQLiteOpenHelper{
	 public static final String STUDENTS = "Students";  

     public static final String STUDENT_ROLLNO="rollno";  

     public static final String STUDENT_NAME = "name";  
     public static final String STUDENT_PHONENO = "phoneno";
     public static final String STUDENT_CLASS = "class1";
    

     private static final String DATABASE_NAME = "Students.db";  

     private static final int DATABASE_VERSION = 1;  
     
     private static final String DATABASE_CREATE = "create table " + STUDENTS  

             + "(" + STUDENT_NAME + " text not null, " 

             + STUDENT_ROLLNO + " text primary key, "+STUDENT_PHONENO+" text, "+ STUDENT_CLASS +" text not null "+");";
     public DataBase(Context context) {  

         super(context, DATABASE_NAME, null, DATABASE_VERSION);  

     }
     @Override 

     public void onCreate(SQLiteDatabase db) {  

          db.execSQL(DATABASE_CREATE);  

    

     }  

    

     @Override 

     public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  

         // you should do some logging in here  

         // ..  

    

         db.execSQL("DROP TABLE IF EXISTS " + STUDENTS);  

         onCreate(db);  

     }
}
