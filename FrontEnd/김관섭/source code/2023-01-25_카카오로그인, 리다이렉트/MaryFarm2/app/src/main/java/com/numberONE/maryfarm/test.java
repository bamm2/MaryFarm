package com.numberONE.maryfarm;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.numberONE.maryfarm.databinding.ActivityTestBinding;

// 사진넘겨받기 테스트용

public class test extends AppCompatActivity {

    ActivityTestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityTestBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Intent intent = getIntent();
        byte[] bytes = intent.getByteArrayExtra("image");
        Bitmap bmp = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
        binding.Image.setImageBitmap(bmp);
        binding.text.setText(intent.getStringExtra("content"));
    }


}