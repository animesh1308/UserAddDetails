package com.example.useradddetails.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.useradddetails.R;
import com.example.useradddetails.viewmodel.UserViwModel;

public class DisplayUserFragment extends Fragment {

    View view;
    UserViwModel userViwModel;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.fragment_user_display,container,false);
        return view;
    }
}
