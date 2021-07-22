package com.example.useradddetails.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class},version = 1)
public abstract class UserRoomDatabase extends RoomDatabase {

     private static  UserRoomDatabase instance;
     public static UserRoomDatabase getDatabase(Context context){
          if(instance==null){
               instance= Room.databaseBuilder(context,UserRoomDatabase.class,"userdb.db").build();
          }
          return instance;
     }
     public abstract UserDao userDao();
}
