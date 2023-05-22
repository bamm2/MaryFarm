package com.example.mylittlefarm;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.mylittlefarm.databinding.DiaryDetailBinding;

public class DiaryDetail extends AppCompatActivity {

    private boolean sign=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DiaryDetailBinding binding = DiaryDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.emptyHeartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sign) {
                    binding.emptyHeartIcon.setVisibility(View.GONE);
                    binding.fullHeartIcon.setVisibility(View.VISIBLE);
                    sign = true;
                }
            }
        });

        binding.fullHeartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sign) {
                    binding.emptyHeartIcon.setVisibility(View.VISIBLE);
                    binding.fullHeartIcon.setVisibility(View.GONE);
                    sign = false;
                }
            }
        });
    }

}