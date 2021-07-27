package com.example.galgotiacollege.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.galgotiacollege.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    RecyclerView campusRecycler, unifestRecycler  , otherRecycler;
    GalleryAdapter adapter;

    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gallery, container, false);
        campusRecycler = view.findViewById(R.id.campusRecycler);
        unifestRecycler = view.findViewById(R.id.unifestRecycler);
        otherRecycler = view.findViewById(R.id.otherRecycler);

        reference = FirebaseDatabase.getInstance().getReference().child("gallery");

        getCampusImage();

        getUnifestImage();

        getOtherImage();

        return view;
    }

    private void getOtherImage() {
        reference.child("Other Events").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                otherRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                otherRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void getCampusImage() {
        reference.child("College Campus").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                campusRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                campusRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void getUnifestImage() {
        reference.child("Unifests").addValueEventListener(new ValueEventListener() {

            List<String> imageList = new ArrayList<>();

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot: dataSnapshot.getChildren()){
                    String data = (String) snapshot.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(), imageList);
                unifestRecycler.setLayoutManager(new GridLayoutManager(getContext(), 3));
                unifestRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}