package com.example.useradddetails.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.useradddetails.fragment.AddUserEntryFragment;
import com.example.useradddetails.fragment.DisplayUserFragment;

public class FragmentPageAdapter extends FragmentStateAdapter {

    private String[] titles = new String[]{"User List", "Add User"};
    public FragmentPageAdapter(FragmentManager fragmentManager, Lifecycle lifecycle) {

        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 0:
                DisplayUserFragment dsplay= new DisplayUserFragment();
                return dsplay;
            case 1:
                AddUserEntryFragment addusr=new AddUserEntryFragment();
                return addusr;
            default:
                return null;
        }
    }

    @Override
    public int getItemCount() {
        return titles.length;
    }
}
