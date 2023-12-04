package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class StudentOperations extends AppCompatActivity implements View.OnClickListener{

    private Button btnViewAnnouncementEvent, btnViewRSVPEvent, btnGenerateComplaint, btnCommentRateEvent, btnCheckQualification, btnStudentLogOut;

    private String studentID;
    private Model model;
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_operations);

        studentID = getIntent().getStringExtra("userID");
        model = Model.getInstance();


        getStudentInfo();


        btnViewAnnouncementEvent = (Button) findViewById(R.id.btnViewAnnouncementEvent);
        btnViewAnnouncementEvent.setOnClickListener(this);

        btnCheckQualification = (Button) findViewById(R.id.btnCheckQualification);
        btnCheckQualification.setOnClickListener(this);

        btnGenerateComplaint = (Button) findViewById(R.id.btnGenerateComplaint);
        btnGenerateComplaint.setOnClickListener(this);

        btnViewRSVPEvent = (Button) findViewById(R.id.btnRSVPforEvent);
        btnViewRSVPEvent.setOnClickListener(this);

        btnCommentRateEvent = (Button) findViewById(R.id.btnCommentRateEvent);
        btnCommentRateEvent.setOnClickListener(this);

        btnStudentLogOut = (Button) findViewById(R.id.btnStudentLogOut);
        btnStudentLogOut.setOnClickListener(this);

    }

    private void getStudentInfo() {
        model.getStudent(studentID, (Student student) -> {
            this.student = student;
        });
    }

    @Override
    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.btnStudentLogOut) {

            startActivity(new Intent(StudentOperations.this, MainActivity.class));

        } else if (id == R.id.btnCheckQualification) {
            Intent intent = new Intent(StudentOperations.this, StudentCheckQualification.class);
            intent.putExtra("studentID", studentID);
            startActivity(intent);

        } else if (id == R.id.btnViewAnnouncementEvent) {

            Intent intent = new Intent(StudentOperations.this, StudentViewAnnouncementEvent.class);
            intent.putExtra("studentID", studentID);
            startActivity(intent);

        } else if (id == R.id.btnGenerateComplaint) {

            Intent intent = new Intent(StudentOperations.this, StudentGenerateComplaint.class);
            intent.putExtra("studentID", studentID);
            startActivity(intent);

        } else if (id == R.id.btnRSVPforEvent) {

            Intent intent = new Intent(StudentOperations.this, StudentViewRSVPEvents.class);
            intent.putExtra("studentID", studentID);
            startActivity(intent);

        } else if (id == R.id.btnCommentRateEvent) {
            if(!student.registeredEvents.isEmpty()){
                Intent intent = new Intent(StudentOperations.this, StudentChooseCommentEvents.class);
                intent.putExtra("studentID", studentID);
                startActivity(intent);
            }
            else{
                Toast.makeText(StudentOperations.this,
                        "You have not registered for any events\nPlease go to RSVP for an event", Toast.LENGTH_LONG).show();
            }

        }

    }

}