package com.ayush.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class Operations {
	private DataBase dbHelper;  

    private String[] STUDENT_TABLE_COLUMNS = { DataBase.STUDENT_ROLLNO, DataBase.STUDENT_NAME, DataBase.STUDENT_PHONENO, DataBase.STUDENT_CLASS };  

    private SQLiteDatabase database;
    private Context context1;

	 public Operations(Context context) 
	    {  

	        dbHelper = new DataBase(context);  
	        context1 = context;
	    }  

	   

	    public void open() throws SQLException {  

	        database = dbHelper.getWritableDatabase();  

	    }  

	   

	    public void close() {  

	        dbHelper.close();  

	    }
	    public Long addStudent(String name , String rollno ,String phoneno , String class1) {  

	 		ContentValues values = new ContentValues();  

	 		values.put(DataBase.STUDENT_NAME, name); 

	          values.put(DataBase.STUDENT_ROLLNO, rollno);
	          
	          values.put(DataBase.STUDENT_PHONENO, phoneno);
	          
	          values.put(DataBase.STUDENT_CLASS,class1); 

	     

	     long studId = database.insert(DataBase.STUDENTS, null, values);
	     	close();
	     	Toast.makeText(context1,"Database Created",Toast.LENGTH_LONG).show();
	    
	         
	         return studId;  

	     }
	   
}
