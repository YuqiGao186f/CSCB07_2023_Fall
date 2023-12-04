package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class StudentChooseCommentEvents extends AppCompatActivity {
    private String studentID;
    private Button studentChooseCommentEventsBack;
    private ListView studentChooseCommentEventsList;
    private Model model;
    private List<String> registeredEvents, evaluatedEvents, displayedEvents;

    private Event event;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_choose_comment_events);

        studentID = getIntent().getStringExtra("studentID");

        studentChooseCommentEventsList = (ListView) findViewById(R.id.studentChooseCommentEventsList);
        studentChooseCommentEventsBack = (Button) findViewById(R.id.studentChooseCommentEventsBack);

        model = Model.getInstance();

        setRSVPdEventsList();

        //TODO: if student in the Event.studentsID, then toast and not intent

        studentChooseCommentEventsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                if(!(selectedItem.equals("You have evaluated all RSVPed events."))) {
                    Intent intent = new Intent(StudentChooseCommentEvents.this,
                            StudentCommentEvent.class);
                    intent.putExtra("studentID", studentID);
                    intent.putExtra("selectedEvent",selectedItem);
                    startActivity(intent);
                }
            }
        });

        studentChooseCommentEventsBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentChooseCommentEvents.this, StudentOperations.class);
                intent.putExtra("userID", studentID);
                startActivity(intent);
            }
        });

    }

    private void setRSVPdEventsList() {

        model.getStudent(studentID, (Student student) -> {


            //TODO: registeredEvents exclude commentedEvents
            //no need to consider cases where: 1.No events. 2.Haven't RSVP for any events.
            //only consider: 1.already evaluate part of RSVp events; 2.already evaluate all of RSVp events

            this.registeredEvents = student.registeredEvents;
            this.evaluatedEvents = student.evaluatedEvents;



            //if displayedEvents = registeredEvent - evaluatedEvents
            if (evaluatedEvents.containsAll(registeredEvents)) {// evaluated every registered Events
                this.displayedEvents = new ArrayList<>();
                displayedEvents.add("You have evaluated all RSVPed events.");
            }
            else {// only evaluate part of registered Events
                this.displayedEvents = new ArrayList<>(registeredEvents);
                displayedEvents.removeAll(evaluatedEvents);
            }

            //            if (student.registeredEvents == null || student.registeredEvents.isEmpty()) {
//
//                Toast.makeText(StudentChooseCommentEvents.this,
//                        "You have not registered for any events\nPlease go to RSVP for an event",
//                        Toast.LENGTH_LONG).show();
//                //would jump back, no need to set ListView
//                Intent intent = new Intent(StudentChooseCommentEvents.this, StudentOperations.class);
//                intent.putExtra("userID", studentID);
//                startActivity(intent);
//
//            }
//            else {
//                this.registeredEvents = student.registeredEvents;
//                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, registeredEvents);
//                studentChooseCommentEventsList.setAdapter(adapter);
//            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayedEvents);
            studentChooseCommentEventsList.setAdapter(adapter);

        });
    }

}
