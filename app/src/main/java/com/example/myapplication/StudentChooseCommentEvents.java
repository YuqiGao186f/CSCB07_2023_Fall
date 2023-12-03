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

import java.util.HashMap;
import java.util.List;


public class StudentChooseCommentEvents extends AppCompatActivity {
    private String studentID;
    private Button studentChooseCommentEventsBack;
    private ListView studentChooseCommentEventsList;
    private Model model;
    private List<String> registeredEvents;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_choose_comment_events);

        studentID = getIntent().getStringExtra("studentID");

        studentChooseCommentEventsList = (ListView) findViewById(R.id.studentChooseCommentEventsList);
        studentChooseCommentEventsBack = (Button) findViewById(R.id.studentChooseCommentEventsBack);

        model = Model.getInstance();

        setRSVPdEventsList();

        studentChooseCommentEventsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                Intent intent = new Intent(StudentChooseCommentEvents.this,
                        StudentCommentEvent.class);
                intent.putExtra("studentID", studentID);
                intent.putExtra("selectedEvent",selectedItem);
                startActivity(intent);
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

            if (student.registeredEvents == null) {

                Toast.makeText(StudentChooseCommentEvents.this,
                        "You have not registered for any events\nPlease go to RSVP for an event",
                        Toast.LENGTH_LONG).show();

                Intent intent = new Intent(StudentChooseCommentEvents.this, StudentOperations.class);
                intent.putExtra("userID", studentID);
                startActivity(intent);

            }
            else {
                this.registeredEvents = student.registeredEvents;
                ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, registeredEvents);
                studentChooseCommentEventsList.setAdapter(adapter);
            }
        });
    }

}
