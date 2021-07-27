package com.example.useradddetails.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LifecycleRegistry;
import androidx.recyclerview.widget.RecyclerView;

import com.example.useradddetails.R;
import com.example.useradddetails.database.UserEntity;
import com.example.useradddetails.utility.ImageConverter;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserRecyclerAdapter extends RecyclerView.Adapter<UserRecyclerAdapter.AddUserViewHolder> {

    private Context context;
    private List<UserEntity> userlist;

    public UserRecyclerAdapter(Context context, List<UserEntity> userlist) {
        this.context = context;
        this.userlist = userlist;
    }

    @NonNull
    @Override
    public AddUserViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
         View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.user_cardview,parent,false);
        return new AddUserViewHolder(view);
    }

    @Override
    public void onBindViewHolder( UserRecyclerAdapter.AddUserViewHolder holder, int position) {

        UserEntity list=userlist.get(position);
        holder.username.setText(list.getUser_name());
        holder.usermobile.setText(list.getMobile_no());
        if(list.getImage()!=null) {
            holder.userImage.setImageBitmap(ImageConverter.byteArrayToImage(list.getImage()));
        }
    }

    @Override
    public int getItemCount() {
        return userlist.size();
    }

    public void filterlist(List<UserEntity> userlist) {
        this.userlist=userlist;
        notifyDataSetChanged();
    }

    public class AddUserViewHolder extends RecyclerView.ViewHolder{
        TextView username,usermobile;
        CircleImageView userImage;

        public AddUserViewHolder(View itemView) {
            super(itemView);

            username=itemView.findViewById(R.id.rcv_usrnm);
            usermobile=itemView.findViewById(R.id.rcv_mobno);
            userImage=itemView.findViewById(R.id.rcview_user_image);

        }
    }
}
