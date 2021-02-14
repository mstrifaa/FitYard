package com.example.fityard;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText id ;
    EditText firstName ;
    EditText lastName ;
    TextView profile;

    Button viewProfile;
    Button insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

         id = (EditText) findViewById(R.id.id);
         firstName = (EditText) findViewById(R.id.firstname);
         lastName =  (EditText) findViewById(R.id.lastname);
         profile = (TextView) findViewById(R.id.profile);

         viewProfile = (Button) findViewById(R.id.viewProfile);
         insert = (Button) findViewById(R.id.insert);



        viewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseModel db= new DatabaseModel(MainActivity.this);

                List<UserModel> userInfo = db.getUserInfo();

                ArrayAdapter userArrayAdapter = new ArrayAdapter<UserModel>(MainActivity.this, android.R.layout.simple_list_item_1, userInfo);

                profile.setText(userInfo.toString());
                System.out.println(userInfo.toString());
                Toast.makeText(MainActivity.this, userInfo.toString(), Toast.LENGTH_SHORT).show();
            }
        });


        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserModel user= new UserModel(Integer.parseInt(id.getText().toString()), firstName.getText().toString(), lastName.getText().toString());

                Toast.makeText(MainActivity.this, user.toString(), Toast.LENGTH_SHORT).show();

                DatabaseModel db= new DatabaseModel(MainActivity.this);

                //long rowID = db.addRecord(user);
                //Toast.makeText(MainActivity.this, "user number "+ rowID, Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume(){
        super.onResume();
        //stopService(initialActivity);


    }

    @Override
    protected void onPause()
    {

        super.onPause();
    }

    @Override
    protected void onStop(){
        super.onStop();

    }

    @Override
    protected void onDestroy(){

        super.onDestroy();
    }
}