package com.example.fityard;

import android.content.Context;
import android.provider.ContactsContract;

import androidx.room.Room;
import androidx.room.RoomDatabase;

@androidx.room.Database(entities = {User.class}, version = 1, exportSchema = false)
public abstract class Database extends RoomDatabase {

    public static Database db;
    public static String DATABASE_NAME = "fitYard";

    public synchronized static Database getInstance(Context context){
        if(db==null){
            // initialize db

            db= Room.databaseBuilder(context, Database.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return db;
    }

    public abstract Dao UserDao();
}
