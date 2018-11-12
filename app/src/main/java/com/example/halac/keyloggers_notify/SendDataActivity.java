package com.example.halac.keyloggers_notify;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class SendDataActivity extends AppCompatActivity {


    Button checkList = (Button) findViewById(R.id.SendDataChecklist);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_data);
        checkList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent confirm = new Intent(SendDataActivity.this, CheckListActivity.class);
                startActivity(confirm);

            }
        });
    }
}