package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminGenerateAnnouncement extends AppCompatActivity {

    private Button btnAdminGenerateAnnoBack, btnAdminGenerateAnno;
    private EditText etAnnouncementTitle, etAnnouncementContent;
    private String adminID, adminName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_generate_announcement);
        //initialize the page and link to the corresponding xml layout file

        adminID = getIntent().getStringExtra("adminID");
        //To let the system knows who is operating needs to pass ID between each page, until log out

        Model model = Model.getInstance();
        model.getAdmin(adminID, (Admin admin) -> {
            this.adminName = admin.getName();
        });

        etAnnouncementTitle = (EditText) findViewById(R.id.AnnouncementTitle);
        etAnnouncementContent = (EditText) findViewById(R.id.AnnouncementContent);

        btnAdminGenerateAnno = (Button) findViewById(R.id.btnAdminGenerateAnno);
        btnAdminGenerateAnnoBack = (Button) findViewById(R.id.btnAdminGenerateAnnoBack);

        btnAdminGenerateAnno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = etAnnouncementTitle.getText().toString();
                String announcementTitle = title +" From Admin  " + adminName;
                String content = etAnnouncementContent.getText().toString();

                if (title.isEmpty() && content.isEmpty()) {
                    Toast.makeText(AdminGenerateAnnouncement.this,
                            "Input cannot be empty", Toast.LENGTH_SHORT).show();
                }
                else if(title.isEmpty()){
                    Toast.makeText(AdminGenerateAnnouncement.this,
                            "Please enter the title of the announcement", Toast.LENGTH_SHORT).show();
                }
                else if(content.isEmpty()){
                    Toast.makeText(AdminGenerateAnnouncement.this,
                            "Please enter the content of the announcement", Toast.LENGTH_SHORT).show();
                }
                else{
                    //code to create announcement and upload to firebase
                    PublicMessage newMessage = new PublicMessage(announcementTitle,content);
                    model.saveAnnouncement(newMessage, (Boolean succeed) ->{
                        Toast.makeText(AdminGenerateAnnouncement.this,
                                succeed ?
                                        "Announcement " + announcementTitle + " created" :
                                        "Failed to save announcement",
                                Toast.LENGTH_SHORT).show();
                    });

                    //jumps back to AdminOperations
                    Intent intent = new Intent(AdminGenerateAnnouncement.this, AdminOperations.class);
                    intent.putExtra("userID", adminID);
                    startActivity(intent);
                }

            }
        });

        btnAdminGenerateAnnoBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AdminGenerateAnnouncement.this, AdminOperations.class);
                intent.putExtra("userID", adminID);
                startActivity(intent);
            }
        });

    }
}
