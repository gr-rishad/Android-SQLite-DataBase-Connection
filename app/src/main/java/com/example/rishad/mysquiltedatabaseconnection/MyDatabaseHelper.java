package com.example.rishad.mysquiltedatabaseconnection;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MyDatabaseHelper extends SQLiteOpenHelper {


    private static final String DATABASE_NAME= "Student"; // database name
    private static final String TABLE_NAME= "student_details"; // table name

    // Column name
    private static final String ID= "_id";
    private static final String NAME= "Name";
    private static final String AGE= "Age";
    private static final String GENDER= "Gender";


    private static final int VERSION_NUMBER= 2;

    private static final String CREATE_TABLE ="CREATE TABLE "+TABLE_NAME+"( "+ID+"  INTEGER PRIMARY KEY AUTOINCREMENT, "+NAME+" VARCHAR(255), "+AGE+" INTEGER,"+GENDER+" VARCHAR(15));";
    private static final String DROP_TABLE="DROP TABLE IF EXISTS "+TABLE_NAME;
    private Context context;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION_NUMBER);
        this.context= context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

       // db.execSQL("CREATE TABLE student( _id INTEGER PRIMARY KEY AUTOINCREMENT, Name VARCHAR(255), Age INTEGER);");
        try{
            db.execSQL(CREATE_TABLE);
            Toast.makeText(context,"OnCreated is Called",Toast.LENGTH_LONG).show();
        }
        catch (Exception e){
            Toast.makeText(context,"Exception :"+e,Toast.LENGTH_LONG).show();
        }


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        try{
            Toast.makeText(context,"OnUpdate is Called",Toast.LENGTH_LONG).show();
            db.execSQL(DROP_TABLE);
            onCreate(db);

        }catch(Exception e){
            Toast.makeText(context,"Exception :"+e,Toast.LENGTH_LONG).show();
        }

    }
}
