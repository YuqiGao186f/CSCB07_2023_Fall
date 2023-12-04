package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class StudentViewAnnouncementEvent extends AppCompatActivity {

    private String studentID;
    private ListView studentSelectAnnouncementViewList,studentSelectEventViewList;
    private Button btnStudentViewAnnouncementEventBack;
    private Model model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_view_announcement_event);

        // From StudentOperations get userID(auth)
        studentID = getIntent().getStringExtra("studentID");


        studentSelectAnnouncementViewList = (ListView) findViewById(R.id.studentSelectAnnouncementViewList);

        model = Model.getInstance();
        model.getAnnouncements((HashMap<String, PublicMessage> announcementsMap) -> {

            String[] announcementArrayList;
            if(announcementsMap.keySet().size() == 0){
                announcementArrayList = new String[1];
                announcementArrayList[0] = "There isn't any announcement posted";
            }
            else{
                announcementArrayList  = new String[announcementsMap.keySet().size()];
                int index = 0;
                for (Map.Entry<String, PublicMessage> entry : announcementsMap.entrySet()) {
                    String title = entry.getKey();
                    PublicMessage announcement = entry.getValue();
                    announcementArrayList[index++] =  "\n" + title + "\n" + announcement.content;
                }
            }


            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, announcementArrayList);
            studentSelectAnnouncementViewList.setAdapter(adapter);


        });

        studentSelectEventViewList = (ListView) findViewById(R.id.studentSelectEventViewList);
        model.getEvents((HashMap<String, Event> eventsMap) -> {

            String[] eventsArrayList;
            if(eventsMap.keySet().size() == 0){
                eventsArrayList = new String[1];
                eventsArrayList[0] = "There isn't any event posted";
            }
            else{
                eventsArrayList = new String[eventsMap.keySet().size()];
                int index = 0;
                for (Map.Entry<String, Event> entry : eventsMap.entrySet()) {
                    String title = entry.getKey();
                    Event event = entry.getValue();
                    eventsArrayList[index++] = "\n" + title + "\nDescription: " + event.content + "\nOccupancy: " +
                            String.valueOf(event.occupancy) + "\nCurrently registered: " + String.valueOf(event.count);
                }

            }
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_list_item_1, eventsArrayList);
            studentSelectEventViewList.setAdapter(adapter);


        });


        btnStudentViewAnnouncementEventBack = findViewById(R.id.btnStudentViewAnnouncementEventBack);
        btnStudentViewAnnouncementEventBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start StudentSignupRSVPEvent activity when the button is clicked
                Intent intent = new Intent(StudentViewAnnouncementEvent.this,
                        StudentOperations.class);
                intent.putExtra("userID", studentID);
                startActivity(intent);
            }
        });

    }

}