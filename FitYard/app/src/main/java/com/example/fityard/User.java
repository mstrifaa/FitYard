package com.example.fityard;


import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    @PrimaryKey(autoGenerate = false)
    public int id;

    @ColumnInfo
    public String firstName;

    @ColumnInfo
    public String lastName;

    @ColumnInfo
    public int age;

    @ColumnInfo
    public double height;

    @ColumnInfo
    public double weight; //weight is to be stored in metres

    @Ignore
    public Bitmap picture;
}


