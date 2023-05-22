package com.numberONE.maryfarm.Pick;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import com.numberONE.maryfarm.databinding.ActivityPickAlgorithmBinding;
import com.numberONE.maryfarm.ui.AlgorithmPage.SectionsPagerAdapter;

public class PickAlgorithm extends AppCompatActivity {

    private ActivityPickAlgorithmBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityPickAlgorithmBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = binding.viewPager;
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = binding.tabs;
        tabs.setupWithViewPager(viewPager);
        FloatingActionButton fab = (FloatingActionButton) binding.fab;

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "[상관 없음]을 선택하셨습니다.", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}