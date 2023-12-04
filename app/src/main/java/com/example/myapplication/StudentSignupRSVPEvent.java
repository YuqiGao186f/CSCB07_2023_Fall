package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class StudentSignupRSVPEvent extends AppCompatActivity {
    private String studentID, selectedEventTitle;
    private Button  btnStudentRSVPEvent,btnStudentRSVPEventBack;
    private TextView rsvpEventNameShow,rsvpEventContentShow,rsvpEventOccupancyShow;
    private Model model;
    private Event selectedEvent;
    private Student student;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_signup_rsvp_event);

        studentID = getIntent().getStringExtra("studentID");
        selectedEventTitle = getIntent().getStringExtra("selectedEvent");

        rsvpEventNameShow = (TextView) findViewById(R.id.rsvpEventNameShow);
        rsvpEventContentShow = (TextView) findViewById(R.id.rsvpEventContentShow);
        rsvpEventOccupancyShow = (TextView) findViewById(R.id.rsvpEventOccupancyShow);

        btnStudentRSVPEvent = (Button) findViewById(R.id.btnStudentRSVPEvent);
        btnStudentRSVPEventBack = (Button) findViewById(R.id.btnStudentRSVPEventBack);

        model = Model.getInstance();

        setEventTextView();
        Log.d("signUpEvent: GetSelectedEvent???", (this.selectedEvent != null) ? ("Event name: " + this.selectedEvent.name) : ("没拿到selectedEvent!!!!!!!!!!"));

        getStudentInfo();
        Log.d("signUpEvent: GetStudent???", (this.student != null) ? ("Student name: " + this.student.name) : ("没拿到student!!!!!!!!!!"));


        btnStudentRSVPEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedEvent.participants == selectedEvent.occupancy) {
                    Toast.makeText(StudentSignupRSVPEvent.this, "Sorry, event is out of capacity", Toast.LENGTH_SHORT).show();
                    // TODO: if out of capacity, then not shown in ViewRSVPEvents
                } else {
                    selectedEvent.participants++;
                    Log.d("btnStudentRSVPEvent", (selectedEventTitle != null) ? "selected event is " + selectedEventTitle : "selected event title is null!!!!!!!!!!!!!");
                    if (student.registeredEvents == null||student.registeredEvents.isEmpty())
                        student.registeredEvents = new ArrayList<String>();
                    student.registeredEvents.add(selectedEventTitle);

                    model.rsvpEvent(selectedEvent, studentID, student,
                            (Boolean eventSucceed) -> {},
                            (Boolean studentSucceed) -> {Toast.makeText(StudentSignupRSVPEvent.this,
                                    studentSucceed ? "Event successfully registered" : "Failed to register for the event", Toast.LENGTH_SHORT).show();});
                }
                Intent intent = new Intent(StudentSignupRSVPEvent.this, StudentOperations.class);
                intent.putExtra("userID", studentID);
                startActivity(intent);
            }
        });

        btnStudentRSVPEventBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start StudentSignupRSVPEvent activity when the button is clicked
                Intent intent = new Intent(StudentSignupRSVPEvent.this, StudentViewRSVPEvents.class);
                intent.putExtra("studentID", studentID);
                startActivity(intent);
            }
        });
    }

    private void getStudentInfo() {
        model.getStudent(studentID, (Student student) -> {
            this.student = student;
        });
    }

    private void setEventTextView(){

        model.getSingleEvent(selectedEventTitle, (Event event) -> {

            Log.d("signupEvent: setEventTextView", (event != null) ? "selected event: " + event.name : "there is no selected event");

            rsvpEventNameShow.setText(event.name);
            rsvpEventContentShow.setText(event.content);
            String result = String.valueOf(event.participants) + "/" + String.valueOf(event.occupancy);
            rsvpEventOccupancyShow.setText(result);
            this.selectedEvent = event;
        });
    }
}
