package com.example.halac.keyloggers_notify;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
/*
Used in the registration activity for ensuring that the user will enters all the fields( name, age and gender).
after he user fills the fields and clicks on "add" button, the app will redirect to the settings to enable Accessibility for the app
 */

public class MainActivity extends AppCompatActivity {


    EditText fname, lname, gender, age;
    Button add;
    Boolean flag1 = false;
    Boolean flag2 = false;
    Boolean flag3 = false;
    Boolean flag4 = false;

    DatabaseHelper db = new DatabaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fname = (EditText) findViewById(R.id.fname);
        lname = (EditText) findViewById(R.id.lname);
        gender = (EditText) findViewById(R.id.gender);
        age = (EditText) findViewById(R.id.age);
        add = (Button) findViewById(R.id.add);


        Intent intentService = new Intent(this, MyAccessibilityService.class);
        this.startService(intentService);


        add.setEnabled(false);

        check(); // cannot press the button if not filled
        //Redirecting to the settings to enable Accessibility
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addUser();
                Intent mood= new Intent(MainActivity.this,MoodPopUp.class );
                startActivity(mood);
                Intent redirect = new Intent(Settings.ACTION_ACCESSIBILITY_SETTINGS);
                startActivityForResult(redirect, 1);
                //Intent check= new Intent(MainActivity.this, SendDataActivity.class);
                // startActivity(check);

            }
        });
    }


    private void addUser() {
        String fname1 = fname.getText().toString().trim();
        String lname1 = lname.getText().toString().trim();
        String age1 = age.getText().toString().trim();
        String gender1 = gender.getText().toString().trim();

        fname.setText("");
        lname.setText("");
        gender.setText(gender1);
        age.setText(age1);

        db.deleteUser();
        db.insertUser(fname1, lname1, age1, gender1);
    }

    //Checks if all the fields are entered
    public void check() {
        fname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    flag1 = true;
                    if (flag1 == true && flag2 == true && flag3 == true && flag4 == true) {
                        add.setEnabled(true);
                    }
                } else {
                    flag1 = false;
                    add.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        lname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    flag2 = true;
                    if (flag1 == true && flag2 == true && flag3 == true && flag4 == true) {
                        add.setEnabled(true);
                    }
                } else {
                    flag2 = false;
                    add.setEnabled(false);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        gender.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    flag3 = true;
                    if (flag1 == true && flag2 == true && flag3 == true && flag4 == true) {
                        add.setEnabled(true);
                    }
                } else {
                    flag3 = false;
                    add.setEnabled(false);

                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        age.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length() > 0) {
                    flag4 = true;
                    if (flag1 == true && flag2 == true && flag3 == true && flag4 == true) {
                        add.setEnabled(true);
                    }
                } else {
                    flag4 = false;
                    add.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }
}
