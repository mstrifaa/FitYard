package com.example.fityard;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseModel extends SQLiteOpenHelper {

    public DatabaseModel(@Nullable Context context) {
        super(context, "UserDB", null, 1); // UserDB- name of the database file
    }

    // this will be called when the db is created for the first time. This is where the creation of tables and the initial population of the tables should happen.
    @Override
    public void onCreate(SQLiteDatabase db) {

        //SQL statement to create a user table
        String createTableStatement = "CREATE TABLE USER(ID INT PRIMARY KEY, FIRST_NAME TEXT, LAST_NAME TEXT)";

        db.execSQL(createTableStatement);


    }

    //this will be called whenever the db's design changes
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public long addRecord(UserModel user){
        SQLiteDatabase dbDML= this.getWritableDatabase();
        ContentValues contentValues= new ContentValues();

        long isSuccess = 0;

        contentValues.put("ID", user.getId());
        contentValues.put("FIRST_NAME", user.getFirstName());
        contentValues.put("LAST_NAME", user.getLastName());

        try{
            isSuccess =  dbDML.insert("USER", null, contentValues);
        }catch(Exception e){
            isSuccess=0;
        }


       dbDML.close();
       return isSuccess;
    }

    public List<UserModel> getUserInfo(){

        List<UserModel> userInfo = new ArrayList<UserModel>();

        String selectQuery= "SELECT * FROM USER";

        SQLiteDatabase dbQuery = this.getReadableDatabase();

        Cursor cursor = dbQuery.rawQuery(selectQuery, null); // returns a result set(cursor); execSQL() returns void
                                                                          // the String[] selectionArgs take values for prepared statements

        if(cursor.moveToFirst()){ // moves the cursor to the first row in the result set; returns True if there is some result/data

            //loop through the resultset as long as there is a row

            do{
                int id = cursor.getInt(0);
                String firstName= cursor.getString(1);
                String lastName = cursor.getString(2);

                UserModel user = new UserModel(id, firstName, lastName);
                userInfo.add(user);

            }while(cursor.moveToNext());
        }
        else{
            //currently, null
        }

        cursor.close();
        dbQuery.close();
        return userInfo;
    }


}
