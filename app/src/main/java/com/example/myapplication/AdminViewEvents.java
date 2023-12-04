package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
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
import java.util.Map;

public class AdminViewEvents extends AppCompatActivity {
    private ListView adminEventList;
    private Button btnAdminSelectEventBack;
    private String adminID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_view_events);

        adminID = getIntent().getStringExtra("adminID");

        adminEventList = (ListView) findViewById(R.id.adminEventList);
        btnAdminSelectEventBack = (Button) findViewById(R.id.btnAdminSelectEventBack);

        Model model = Model.getInstance();
        model.getEvents((HashMap<String, Event> eventsMap) -> {
            String[] eventsTitle;
            if(eventsMap.keySet().size() == 0){
                String s = "There isn't any events posted.";
                eventsTitle = new String[1];
                eventsTitle[0] = s;
            }
            else{
                eventsTitle = new String[eventsMap.keySet().size()];
                eventsMap.keySet().toArray(eventsTitle);
            }

//            String[] eventsTitle = new String[eventsMap.keySet().size()];
//            eventsMap.keySet().toArray(eventsTitle);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, eventsTitle);

            adminEventList.setAdapter(adapter);

            adminEventList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    String selectedItem = (String) parent.getItemAtPosition(position);

                    if(!(selectedItem.equals("There isn't any events posted."))) {
                        Intent intent = new Intent(AdminViewEvents.this, AdminViewEventDetail.class);
                        intent.putExtra("adminID", adminID);
                        intent.putExtra("selectedEvent",selectedItem);
                        startActivity(intent);
                    }
                }
            });

        });


        btnAdminSelectEventBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminViewEvents.this, AdminOperations.class);
                intent.putExtra("userID", adminID);
                startActivity(intent);
            }
        });
    }
}
