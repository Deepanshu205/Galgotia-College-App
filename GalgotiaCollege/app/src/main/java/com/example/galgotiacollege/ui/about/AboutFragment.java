package com.example.galgotiacollege.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.galgotiacollege.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {

    private ViewPager viewPager;
    private BranchAdapter adapter;
    private List<BranchModel>list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_about, container, false);
        list = new ArrayList<>();
        list.add(new BranchModel(R.drawable.ic_comp,"Computer Science","The department of Computer Science provides world-class research and education in modern computer science. The department has a cohesive team of well experienced faculty members having wide experience in recent technologies like Cloud computing, Grid Computing, High Performance Computing, Multimedia etc. It has different computer labs like Data Structure lab, Operating System lab, Multimedia lab, Web Technology lab, Research & Development lab"));
        list.add(new BranchModel(R.drawable.ic_comp,"Information Technology","The department of Information Technology provides world-class research and education in modern computer science. The department has a cohesive team of well experienced faculty members having wide experience in recent technologies like Cloud computing, Grid Computing, High Performance Computing, Multimedia etc. It has different computer labs like Data Structure lab, Operating System lab, Multimedia lab, Web Technology lab, Research & Development lab"));
        list.add(new BranchModel(R.drawable.ic_elec,"Electrical Engineering","The Electrical Engineering (EE) is one of the core branches of Galgotias College of Engineering & Technology, which has an excellent infrastructure to promote congenial academic environment to impart quality education. The department of Electrical Engineering has well equipped laboratories and a team of well qualified and dedicated faculty members and technical staff."));
        list.add(new BranchModel(R.drawable.ic_mech,"Mechanical Engineering","The Department of Mechanical Engineering, established in the year 2001, with a vision to carve a distinct niche for itself in the field of mechanical engineering education in India, offers a 4- year B.Tech. program in Mechanical Engineering. The department has, over the years, built and maintained a high level of intellectual capital. It has to its credit a strong team of 33 highly qualified and richly experienced faculty members, 10 out of whom are PhDs and others are pursuing it from institutions of high repute"));

        adapter = new BranchAdapter(getContext(), list);

        viewPager = view.findViewById(R.id.viewPager);

        viewPager.setAdapter(adapter);

        ImageView imageView = view.findViewById(R.id.college_image);

        Glide.with(getContext())
                .load("https://firebasestorage.googleapis.com/v0/b/galgotia-college-app.appspot.com/o/photos%2Fgal1.jpg?alt=media&token=8c5ad8d9-3569-4f0c-90c5-27ad60c18cb0")
                .into(imageView);

        return view;

    }
}