package com.example.admincollegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.admincollegeapp.faculty.UpdateFaculty;
import com.example.admincollegeapp.notice.DeleteNoticeActivity;
import com.example.admincollegeapp.notice.UploadNotice;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CardView uploadNotice, addGalleryImage, addEbook, faculty, deleteNoitce;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadNotice = findViewById(R.id.addNotice);
        addGalleryImage = findViewById(R.id.addGalleryImage);
        addEbook = findViewById(R.id.addEbook);
        faculty = findViewById(R.id.faculty);
        deleteNoitce = findViewById(R.id.deleteNotice);

        uploadNotice.setOnClickListener(this);
        addGalleryImage.setOnClickListener(this);
        addEbook.setOnClickListener(this);
        faculty.setOnClickListener(this);
        deleteNoitce.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent;

        switch (view.getId()){

            case R.id.addNotice:
                intent = new Intent(MainActivity.this, UploadNotice.class);
                startActivity(intent);
                break;

            case R.id.addGalleryImage:
                intent = new Intent(MainActivity.this,UploadImage.class);
                startActivity(intent);
                break;

            case R.id.addEbook:
                intent = new Intent(MainActivity.this,UploadPdfActivity.class);
                startActivity(intent);
                break;

            case R.id.faculty:
                intent = new Intent(MainActivity.this,UpdateFaculty.class);
                startActivity(intent);
                break;

            case R.id.deleteNotice:
                intent = new Intent(MainActivity.this, DeleteNoticeActivity.class);
                startActivity(intent);
                break;

        }

    }
}