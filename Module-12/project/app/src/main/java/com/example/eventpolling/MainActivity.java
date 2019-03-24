package com.example.eventpolling;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity{
    private Button button;
    private EditText rollNumber;
    private EditText passcode;
    public String enterpasscode;
    private ProgressDialog loadingbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadingbar = new ProgressDialog(this);
        rollNumber = (EditText) findViewById(R.id.rollEnter);
        passcode = (EditText) findViewById(R.id.passcodeEnter);
        button = (Button) findViewById(R.id.login_button);
        enterpasscode = "msit1234";


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAccount();
            }
        }) ;
    }
    public void openActivity() {
        Intent intent = new Intent(this, EventActivity.class);
        startActivity(intent);
    }
    public void openActivity1() {
        Intent intent = new Intent(this, SubmittedActivity.class);
        startActivity(intent);
    }
    public void createAccount() {
        String rollnum = rollNumber.getText().toString();
        String password = passcode.getText().toString();

        if (TextUtils.isEmpty(rollnum)) {
            rollNumber.setError("Enter roll number");
        }
        else if (TextUtils.isEmpty(password)) {
            passcode.setError("Enter password");

        } else if (!(rollnum.length() == 8 && rollnum.substring(0,5).equals("20186")) ) {
            rollNumber.setError("Enter MSIT ROLL NUMBER with length 8  and 20186---");

        } else if (!(password.equals(enterpasscode))){
            passcode.setError("Enter valid passcode");

        } else {
            validateCredentials(rollnum);
            loadingbar.setMessage("WAIT UNTIL NEXT EVENT LOADS");
        }

    }
    private void validateCredentials(final String checkroll) {
        final DatabaseReference rootref;
        rootref = FirebaseDatabase.getInstance().getReference();
        rootref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(!(dataSnapshot.child("Users").child(checkroll).exists())) {
                    HashMap<String, Object> userdetails = new HashMap<>();
                    userdetails.put("checkroll", checkroll);

                    rootref.child("Users").child(checkroll).updateChildren(userdetails)
                            .addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        loadingbar.setMessage("WAIT UNTIL NEXT EVENT LOADS");
                                        openActivity();
                                    }
                                }
                            });

                } else if (dataSnapshot.child("Users").child(checkroll).exists()) {
                    loadingbar.setMessage("WAIT UNTIL NEXT EVENT LOADS");
                        openActivity1();


                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
