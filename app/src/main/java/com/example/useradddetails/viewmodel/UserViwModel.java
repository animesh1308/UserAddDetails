package com.example.useradddetails.viewmodel;


import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.useradddetails.database.UserEntity;
import com.example.useradddetails.database.UserRoomDatabase;

import java.util.List;

import io.reactivex.Flowable;

public class UserViwModel extends AndroidViewModel {
  private UserRoomDatabase userDatabase;

    public UserViwModel(Application application) {
        super(application);
        userDatabase=UserRoomDatabase.getDatabase(application);
    }
    Flowable<List<UserEntity>> getallUser(){
        return userDatabase.userDao().getall();
    }

    void insert(UserEntity userEntity){
        userDatabase.userDao().insert(userEntity);
    }
}
