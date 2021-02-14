package com.example.fityard;


import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface Dao {
        @Insert(entity = User.class)
        long insert(User users);

        @Delete                //*** @Delete method will return an int- the NUMBER OF ROWS affected ***
        int delete(User user);

        @Update
        int update(User user);  //*** @Update method will return an int- the NUMBER OF ROWS affected ***

        @Query("SELECT * FROM user")
        List<User> getAll();

}
