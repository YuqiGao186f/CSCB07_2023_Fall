package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AdminViewEventDetail extends AppCompatActivity {
    private ListView studentCommentForEvent;
    private Button btnAdminViewDetailedEventBack;
    private TextView detailedEventTitle, detailedEventContent, detailedEventOccupancy,
            detailedEventCount, detailedEventAvgRate;
    private String selectedEvent,adminID;
    private List<String> displayedComments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_view_event_detail);

        adminID = getIntent().getStringExtra("adminID");
        selectedEvent = getIntent().getStringExtra("selectedEvent");

        detailedEventTitle = (TextView) findViewById(R.id.detailedEventTitle);
        detailedEventContent = (TextView) findViewById(R.id.detailedEventContent);
        detailedEventOccupancy = (TextView) findViewById(R.id.detailedEventOccupancy);
        detailedEventCount = (TextView) findViewById(R.id.detailedEventCount);
        detailedEventAvgRate = (TextView) findViewById(R.id.detailedEventAvgRate);
        studentCommentForEvent = (ListView) findViewById(R.id.studentCommentForEvent);
        displayedComments = new ArrayList<String>();

        //firebase
        Model model = Model.getInstance();
        model.getSingleEvent(selectedEvent, event -> {
            // Successfully retrieved the event, now fetch specific event
            detailedEventTitle.setText(event.name);
            detailedEventContent.setText(event.content);
            detailedEventOccupancy.setText(event.participants + "/" + event.occupancy);
            detailedEventCount.setText(String.valueOf(event.count));
            detailedEventAvgRate.setText(String.format("%.1f", event.avgRate));

            if (event.comments != null) {
                displayedComments = event.comments;
            } else {
                displayedComments.add("There is no comments now.");
            }

            ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, displayedComments);
            studentCommentForEvent.setAdapter(adapter);
        });

        btnAdminViewDetailedEventBack = findViewById(R.id.btnAdminViewDetailedEventBack);
        btnAdminViewDetailedEventBack .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start StudentSignupRSVPEvent activity when the button is clicked
                Intent intent = new Intent(AdminViewEventDetail.this, AdminViewEvents.class);
                intent.putExtra("adminID", adminID);
                startActivity(intent);
            }
        });

    }
}
