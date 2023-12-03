package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AdminOperations extends AppCompatActivity implements View.OnClickListener{

    private Button btnPostAnnouncement, btnPostEvent, btnViewEvents, btnViewComplaints, btnAdminLogOut;
    private String adminID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_operations);

        adminID = getIntent().getStringExtra("userID");

        btnPostAnnouncement = (Button) findViewById(R.id.btnPostAnnouncement);
        btnPostEvent = (Button) findViewById(R.id.btnPostEvent);
        btnViewEvents = (Button) findViewById(R.id.btnViewEvents);
        btnViewComplaints = (Button) findViewById(R.id.btnViewComplaints);
        btnAdminLogOut = (Button) findViewById(R.id.btnAdminLogOut);

        btnPostAnnouncement.setOnClickListener(this);
        btnPostEvent.setOnClickListener(this);
        btnViewEvents.setOnClickListener(this);
        btnViewComplaints.setOnClickListener(this);
        btnAdminLogOut.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        if (id == R.id.btnPostAnnouncement) {

            Intent intent = new Intent(AdminOperations.this, AdminGenerateAnnouncement.class);
            intent.putExtra("adminID",adminID);
            startActivity(intent);

        } else if (id == R.id.btnPostEvent) {

            Intent intent = new Intent(AdminOperations.this, AdminGenerateEvents.class);
            intent.putExtra("adminID",adminID);
            startActivity(intent);

        } else if (id == R.id.btnViewEvents) {

            Intent intent = new Intent(AdminOperations.this, AdminViewEvents.class);
            intent.putExtra("adminID", adminID);
            startActivity(intent);

        } else if (id == R.id.btnViewComplaints) {

            Intent intent = new Intent(AdminOperations.this, AdminViewComplains.class);
            intent.putExtra("adminID", adminID);
            startActivity(intent);

        } else if (id == R.id.btnAdminLogOut) {

            startActivity(new Intent(AdminOperations.this, MainActivity.class));

        }
    }
}