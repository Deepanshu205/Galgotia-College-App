package com.example.galgotiacollege.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.galgotiacollege.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;

public class HomeFragment extends Fragment {

    private SliderLayout sliderLayout;
    private ImageView map;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout = view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(1);

        setSliderViews();

        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMap();
            }
        });

        return view;
    }

    private void openMap() {
        Uri uri = Uri.parse("geo:0, 0?q=Galgotias College of Engineering & Technology, Greater Noida");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderViews() {
        for (int i = 0; i< 4; i++){
            DefaultSliderView sliderView = new DefaultSliderView(getContext());
            switch (i){
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/galgotia-college-app.appspot.com/o/photos%2Fgal1.jpg?alt=media&token=8c5ad8d9-3569-4f0c-90c5-27ad60c18cb0");
                    break;
                case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/galgotia-college-app.appspot.com/o/photos%2Fgal2.jpg?alt=media&token=a8c9eeb0-76c4-4b37-aa21-9a0b001886bb");
                    break;
                case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/galgotia-college-app.appspot.com/o/photos%2Fgal3.jpg?alt=media&token=5d3e19d9-65ed-459f-b871-4054651505f3");
                    break;
                case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/galgotia-college-app.appspot.com/o/photos%2Fgal4.jpg?alt=media&token=224ea746-fc5c-40df-867b-023aa5e14c3d");
                    break;
            }
            sliderView.setImageScaleType(ImageView.ScaleType.CENTER_CROP);

            sliderLayout.addSliderView(sliderView);
        }
    }
}