package com.example.useradddetails.viewmodel;


import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.AndroidViewModel;

import com.example.useradddetails.database.UserEntity;
import com.example.useradddetails.database.UserRoomDatabase;
import com.google.android.material.snackbar.Snackbar;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;


public class UserViwModel extends AndroidViewModel {

    private UserRoomDatabase userDatabase;
    private Flowable<UserEntity> userlist;
    Context ctx;

    public UserViwModel(Application application) {
        super(application);
        userDatabase=UserRoomDatabase.getDatabase(application);
        ctx=application.getApplicationContext();
    }
    public Flowable<List<UserEntity>> getallUser(){
        return userDatabase.userDao().getUser();
    }

    public void insert(UserEntity entity) {

        userDatabase.userDao().insertUser(entity).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                   .subscribe(new CompletableObserver() {
                       @Override
                       public void onSubscribe(@NotNull Disposable d) {

                       }

                       @Override
                       public void onComplete() {

                           Toast.makeText(ctx,"Data inserted", Toast.LENGTH_SHORT).show();
                       }

                       @Override
                       public void onError(@NotNull Throwable e) {

                           Toast.makeText(ctx,e.getMessage(),Toast.LENGTH_SHORT).show();
                       }
                   });
    }
}
