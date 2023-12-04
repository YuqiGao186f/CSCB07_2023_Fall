package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StudentViewRSVPEvents extends AppCompatActivity {

    private String studentID;
    private Button btnStudentViewEventBack;
    private ListView studentRsvpEventList;
    private ArrayAdapter<String> adapter;
    private Model model;
    private Student student;
    private List<String> displayedEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_view_rsvp_events);

        // From StudentOperations get userID(auth)
        studentID = getIntent().getStringExtra("studentID");

        studentRsvpEventList = findViewById(R.id.studentRsvpEventList);

        model = Model.getInstance();

        getStudentInfo();

        setEventsList();

        studentRsvpEventList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                if(!(selectedItem.equals("There isn't any events posted.")) && !(selectedItem.equals("You have registered all events."))) {
                    Intent intent = new Intent(StudentViewRSVPEvents.this,
                        StudentSignupRSVPEvent.class);
                    intent.putExtra("studentID", studentID);
                    intent.putExtra("selectedEvent",selectedItem);
                    startActivity(intent);
                }
            }
        });

        btnStudentViewEventBack = findViewById(R.id.btnStudentViewAnnouncementEventBack);
        btnStudentViewEventBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start StudentSignupRSVPEvent activity when the button is clicked
                Intent intent = new Intent(StudentViewRSVPEvents.this, StudentOperations.class);
                intent.putExtra("userID", studentID);
                startActivity(intent);
            }
        });
    }

    private void getStudentInfo() {
        model.getStudent(studentID, (Student student) -> {
            this.student = student;
        });
    }

    private void setEventsList(){

        model.getEvents((HashMap<String, Event> eventsMap) -> {

            List<String> eventsTitle;
            this.displayedEvents = new ArrayList<>();

            if (eventsMap.isEmpty())
                this.displayedEvents.add("There isn't any events posted.");
            else if (this.student.registeredEvents == null||this.student.registeredEvents.isEmpty()) {
                eventsTitle  = new ArrayList<>(eventsMap.keySet());
                this.displayedEvents = eventsTitle;
            } else {
                eventsTitle = new ArrayList<>(eventsMap.keySet());
                for (String element: eventsTitle) {
                    if (!this.student.registeredEvents.contains(element))
                        this.displayedEvents.add(element);
                }
                if (this.displayedEvents.isEmpty())
                    displayedEvents.add("You have registered all events.");
            }

            adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, displayedEvents);

            studentRsvpEventList.setAdapter(adapter);

        });
    }

}
