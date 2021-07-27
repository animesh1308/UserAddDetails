package com.example.useradddetails.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useradddetails.R;
import com.example.useradddetails.adapter.UserRecyclerAdapter;
import com.example.useradddetails.database.UserEntity;
import com.example.useradddetails.database.UserRoomDatabase;
import com.example.useradddetails.viewmodel.UserViwModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class DisplayUserFragment extends Fragment {

    View view;
    RecyclerView recyclerView;
    EditText etSearch;
    UserEntity entity;
    UserRecyclerAdapter adapter;
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_user_display,container,false);
        recyclerView=view.findViewById(R.id.fr_user_display);
        etSearch=view.findViewById(R.id.et_search);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setHasFixedSize(true);
        UserRoomDatabase userDatabase=UserRoomDatabase.getDatabase(getActivity());
        userDatabase.userDao().getUser().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<UserEntity>>() {
                    @Override
                    public void accept(List<UserEntity> userEntities) throws Exception {
                        UserRecyclerAdapter userRecyclerAdapter=new UserRecyclerAdapter(getActivity(),userEntities);
                        recyclerView.setAdapter(userRecyclerAdapter);
                    }
                });

        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                filter(editable.toString());

            }
        });
        return view;
    }

    private void filter(String text) {
        List<UserEntity> list=new ArrayList();
        for(UserEntity u:list.toArray(new UserEntity[0])){
            if(u.getUser_name().contains(text )){
                list.add(u);
            }
        }
        adapter.filterlist(list);
    }
}
