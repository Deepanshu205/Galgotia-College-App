package com.example.admincollegeapp.faculty;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.admincollegeapp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class UpdateFaculty extends AppCompatActivity {

    FloatingActionButton fab;
    private RecyclerView csDepartment, itDepartment, electricalDepartment, mechanicalDepartment;
    private LinearLayout csNoData, itNoData, electricalNoData,mechanicalNoData;
    private List<TeacherData> list1, list2, list3 , list4;
    private TeacherAdapter adapter;

    private DatabaseReference reference, dbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_faculty);

        csDepartment = findViewById(R.id.csDepartment);
        itDepartment = findViewById(R.id.itDepartment);
        electricalDepartment = findViewById(R.id.electricalDepartment);
        mechanicalDepartment = findViewById(R.id.mechanicalDepartment);

        csNoData = findViewById(R.id.csNoData);
        itNoData = findViewById(R.id.itNoData);
        electricalNoData = findViewById(R.id.electricalNoData);
        mechanicalNoData = findViewById(R.id.mechanicalNoData);


        reference = FirebaseDatabase.getInstance().getReference().child("teacher");

        csDepartment();
        itDepartment();
        electricalDepartment();
        mechanicalDepartment();

        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(UpdateFaculty.this, AddTeacher.class));
            }
        });
    }

    private void csDepartment() {
        dbRef = reference.child("Computer Science");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list1 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    csNoData.setVisibility(View.VISIBLE);
                    csDepartment.setVisibility(View.GONE);
                }else {
                    csNoData.setVisibility(View.GONE);
                    csDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list1.add(data);
                    }
                    csDepartment.setHasFixedSize(true);
                    csDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list1, UpdateFaculty.this, "Computer Science");
                    csDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }


    private void itDepartment() {
        dbRef = reference.child("Information Technology");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list2 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    itNoData.setVisibility(View.VISIBLE);
                    itDepartment.setVisibility(View.GONE);
                }else {
                    itNoData.setVisibility(View.GONE);
                    itDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list2.add(data);
                    }
                    itDepartment.setHasFixedSize(true);
                    itDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list2, UpdateFaculty.this,"Information Technology");
                    itDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void electricalDepartment() {
        dbRef = reference.child("Electrical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list3 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    electricalNoData.setVisibility(View.VISIBLE);
                    electricalDepartment.setVisibility(View.GONE);
                }else {
                    electricalNoData.setVisibility(View.GONE);
                    electricalDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list3.add(data);
                    }
                    electricalDepartment.setHasFixedSize(true);
                    electricalDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list3, UpdateFaculty.this, "Electrical");
                    electricalDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void mechanicalDepartment() {
        dbRef = reference.child("Mechanical");
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list4 = new ArrayList<>();
                if (!dataSnapshot.exists()){
                    mechanicalNoData.setVisibility(View.VISIBLE);
                    mechanicalDepartment.setVisibility(View.GONE);
                }else {
                    mechanicalNoData.setVisibility(View.GONE);
                    mechanicalDepartment.setVisibility(View.VISIBLE);
                    for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                        TeacherData data = snapshot.getValue(TeacherData.class);
                        list4.add(data);
                    }
                    mechanicalDepartment.setHasFixedSize(true);
                    mechanicalDepartment.setLayoutManager(new LinearLayoutManager(UpdateFaculty.this));
                    adapter = new TeacherAdapter(list4, UpdateFaculty.this, "Mechanical");
                    mechanicalDepartment.setAdapter(adapter);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(UpdateFaculty.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}