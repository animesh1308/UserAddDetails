package com.example.useradddetails.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface UserDao {

    @Insert
    void insert(UserEntity userEntity);

    @Query("select * from user_detail")
    Flowable<List<UserEntity>> getall();

}
