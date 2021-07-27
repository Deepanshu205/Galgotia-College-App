package com.example.galgotiacollege.ebook;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.example.galgotiacollege.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends AppCompatActivity {

    private RecyclerView ebookRecycler;
    private DatabaseReference reference;
    private List<EbookData> list;
    private EbookAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ebooks");

        ebookRecycler = findViewById(R.id.ebookRecycler);
        reference = FirebaseDatabase.getInstance().getReference().child("pdf");

        getData();

    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list = new ArrayList<>();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    EbookData data = snapshot.getValue(EbookData.class);
                    list.add(data);
                }
                adapter = new EbookAdapter(EbookActivity.this, list);
                ebookRecycler.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                ebookRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(EbookActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}