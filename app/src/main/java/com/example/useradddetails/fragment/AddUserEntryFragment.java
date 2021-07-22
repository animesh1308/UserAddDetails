package com.example.useradddetails.fragment;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.useradddetails.R;

import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

public class AddUserEntryFragment extends Fragment {

    View view;
    EditText etUsername,etMobileno,etDob;
    Button btSaveUser;
    Spinner spGender;
    CircleImageView userImage;
    Integer birthMonth,birthDate,birthYear,genderpos=0,CAM_REQUEST=111;
    DatePickerDialog datePickerDialog;
    Bitmap captureImage;

    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

        view=inflater.inflate(R.layout.fragment_user_entry,container,false);
        etUsername=view.findViewById(R.id.et_entry_username);
        etMobileno=view.findViewById(R.id.et_entry_usermob);
        etDob=view.findViewById(R.id.et_entry_userdob);
        spGender=view.findViewById(R.id.sp_user_gender);
        userImage=view.findViewById(R.id.img_user_entry);

        etDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Calendar calendar=Calendar.getInstance();
                birthDate=calendar.get(Calendar.DATE);
                birthMonth=calendar.get(Calendar.MONTH);
                birthYear=calendar.get(Calendar.YEAR);

                datePickerDialog=new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int date) {

                        month=month+1;
                        String fdate= date + "/" + month + "/" + year;
                        etDob.setText(fdate);
                    }
                },birthDate,birthMonth,birthYear);
                datePickerDialog.show();
            }
        });

        ArrayAdapter<CharSequence> arrayAdapter=ArrayAdapter.createFromResource(getActivity(),R.array.gender, android.R.layout.simple_spinner_item);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGender.setAdapter(arrayAdapter);
        spGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                genderpos=i;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        userImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camintent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(camintent,CAM_REQUEST);
            }
        });
        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode,  Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==111){
            captureImage=(Bitmap) data.getExtras().get("data");
            userImage.setImageBitmap(captureImage);
        }
    }
}
