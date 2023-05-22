package com.numberONE.maryfarm.ui.myfarm;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.numberONE.maryfarm.R;

import java.util.ArrayList;

public class FarmsProfileActivity extends AppCompatActivity {

    private ArrayList<FarmFeedData> arrayList;
    private FarmFeedAdapter feedAdapter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_myfarm_profile);


        recyclerView = (RecyclerView)findViewById(R.id.profile_rv);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        arrayList = new ArrayList<>();

        feedAdapter = new FarmFeedAdapter(arrayList);
        recyclerView.setAdapter(feedAdapter);


        //
    }
}