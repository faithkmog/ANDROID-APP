package com.example.student.zfgscleaners;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class loginActivity extends AppCompatActivity {
  DataBaseHelper  db;
     EditText username,password,cpassword;
     Button btnSignUp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db =new DataBaseHelper(this);

        username=(EditText) findViewById(R.id.txtEmail);
        password=(EditText) findViewById(R.id.txtPassword);
        cpassword=(EditText)findViewById(R.id.txtCpassword);
        btnSignUp=(Button)findViewById(R.id.btnSave);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = username.getText().toString();
                String pass = password.getText().toString();
                String cPass = cpassword.getText().toString();
                if (name.equals("") || pass.equals("") || cPass.equals("")){
                    Toast.makeText(getApplicationContext(), "FIELDS are EMPTY", Toast.LENGTH_LONG).show();


            }
                else { if (pass.equals(cPass)) {
                    Boolean checkUsername = db.checkUsername(name);
                    if (checkUsername == true) {
                        Boolean insert = db.insert(name, pass);
                        if (insert == true) {
                            Toast.makeText(getApplicationContext(), "User Succesfully added", Toast.LENGTH_LONG).show();
                        }
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "User Exists", Toast.LENGTH_LONG).show();
                    }
                }
                    Toast.makeText(getApplicationContext(), "Passwors do not Match", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
