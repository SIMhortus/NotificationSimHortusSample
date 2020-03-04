package com.example.notificationsimhortussample;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static android.content.ContentValues.TAG;



public class Dashboard extends Fragment implements View.OnClickListener {

    Button button;
    SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss aa");
    @Nullable
    @Override
    public View onCreateView (LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState){

        final View rootView = inflater.inflate(R.layout.fragment_dashboard, container, false);
        button = rootView.findViewById(R.id.addNotif);



        button.setOnClickListener(this);





        return rootView;

    }

    @Override
    public void onClick(View v) {

        if (v == button) {

            DatabaseReference mDatabase;
            mDatabase = FirebaseDatabase.getInstance().getReference();
            String uid = "user1";
            String desc = "Roselle wants to connect in your simhortus";


            Date date = new Date();

            String dateTime = formatter.format(date);
                NotificationAttributes notificationAttributes = new NotificationAttributes(desc,dateTime, 1);

                mDatabase.child("notification").child(uid)
                        .child(dateTime).
                        setValue(notificationAttributes).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(getContext(), "Succesfully added in description",Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                        }

                    }
                });

        }
    }
}
