package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class StudentCommentEvent extends AppCompatActivity{

    private Button btnStudentCommentEvent,btnStudentCommentEventBack;
    private String studentID, studentName, selectedEventTitle;
    private TextView commentedEventNameShow;
    private EditText studentRateEvent,studentCommentEvent;
    private Model model;
    private Event selectedEvent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_comment_event);

        // From StudentOperations get userID(auth)
        studentID = getIntent().getStringExtra("studentID");
        selectedEventTitle = getIntent().getStringExtra("selectedEvent");

        model = Model.getInstance();

        btnStudentCommentEvent = (Button) findViewById(R.id.btnStudentCommentEvent);
        btnStudentCommentEventBack = (Button) findViewById(R.id.btnStudentCommentEventBack);
        commentedEventNameShow = (TextView) findViewById(R.id.commentedEventNameShow);
        studentRateEvent = (EditText) findViewById(R.id.studentRateEvent);
        studentCommentEvent = (EditText) findViewById(R.id.studentCommentEvent);

        commentedEventNameShow.setText(selectedEventTitle);

        getSelectedEvent();
        getStudentInfo();

        btnStudentCommentEvent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String comment = studentCommentEvent.getText().toString();
                String rateStr = studentRateEvent.getText().toString();

                if(comment.isEmpty() && rateStr.isEmpty()){

                    Toast.makeText(StudentCommentEvent.this,
                            "Please rate the event or leave a comment", Toast.LENGTH_SHORT).show();

                } else if (rateStr.isEmpty()) {

                    Toast.makeText(StudentCommentEvent.this,
                            "Notice:\nonly comment, not rate", Toast.LENGTH_SHORT).show();

                    commentEvent(comment);
                    updateEvent();

                } else if (comment.isEmpty()) {  // only rate but not comment

                    int rate = Integer.parseInt(rateStr);
                    if (rate < 0 || rate > 10)
                        Toast.makeText(StudentCommentEvent.this,
                                "Warning: Rate not between 1 to 10", Toast.LENGTH_SHORT).show();
                    else {
                        Toast.makeText(StudentCommentEvent.this,
                                "Notice:\nonly rate, not comment", Toast.LENGTH_SHORT).show();

                        rateEvent(rate);
                        updateEvent();
                    }

                }
                else{  // rate & comment

                    int rate = Integer.parseInt(rateStr);

                    if (rate < 0 || rate > 10)
                        Toast.makeText(StudentCommentEvent.this,
                                "Warning: Rate not between 1 to 10", Toast.LENGTH_SHORT).show();
                    else {
                        commentEvent(comment);
                        rateEvent(rate);

                        updateEvent();
                    }

                }
            }
        });

        btnStudentCommentEventBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StudentCommentEvent.this, StudentChooseCommentEvents.class);
                intent.putExtra("studentID", studentID);
                startActivity(intent);
            }
        });

    }

    private void getSelectedEvent() {
        model.getSingleEvent(selectedEventTitle, (Event event) -> {
            this.selectedEvent = event;
        });
    }

    private void getStudentInfo() {
        model.getStudent(studentID, (Student student) -> {
            this.studentName = student.name;
        });
    }

    public void rateEvent(int rate){
        selectedEvent.count++;
        selectedEvent.avgRate = (selectedEvent.avgRate * (selectedEvent.count - 1) + rate) / selectedEvent.count;
    }

    public void commentEvent(String comment){
        if (selectedEvent.comments == null)
            selectedEvent.comments = new ArrayList<>();
        selectedEvent.comments.add("Student " + this.studentName + ": " + comment);
    }

    public void updateEvent(){
        model.saveEvent(selectedEvent, (Boolean succeed) -> {
            Toast.makeText(StudentCommentEvent.this,
                    succeed ? "Comment or rate generated" : "Fail to comment or rate the event\nPlease try again.",
                    Toast.LENGTH_LONG).show();
            if (succeed) {
                Intent intent = new Intent(StudentCommentEvent.this, StudentChooseCommentEvents.class);
                intent.putExtra("studentID", studentID);
                startActivity(intent);
            }
        });
    }

}