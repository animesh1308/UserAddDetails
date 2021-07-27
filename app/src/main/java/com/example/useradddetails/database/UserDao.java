package com.example.useradddetails.database;







import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;

@Dao
public interface UserDao {

    @Query("select * from user_detail")
    Flowable<List<UserEntity>> getUser();

    @Query("select * from user_detail where id= :id")
    Flowable<UserEntity> getUserbyId(String id);

    @Insert()
    Completable insertUser(UserEntity userEntity);

}
