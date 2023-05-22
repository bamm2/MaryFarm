package com.numberONE.maryfarm.Home;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.numberONE.maryfarm.databinding.ActivityHomeBinding;


public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;

    private FragmentStateAdapter adapter;
    private int num_page = 2 ;
    private static String TAG="HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityHomeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // 회원가입 시 아이디 값 확인용
        Intent intent =getIntent();
        String param = intent.getStringExtra("user_id");
        Log.d(TAG, "onCreate: "+param);
        binding.id.setText(param);

        //Adapter
        adapter=new HomeAdapter(this, num_page);
        binding.viewPager.setAdapter(adapter);

        //Indicator
        binding.indicator.setViewPager(binding.viewPager);
        binding.indicator.createIndicators(num_page,0);

        //ViewPager Setting
        binding.viewPager.setOrientation(ViewPager2.ORIENTATION_HORIZONTAL);
        binding.viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
                if(positionOffsetPixels ==0 ){
                    binding.viewPager.setCurrentItem(position);
                }
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                binding.indicator.animatePageSelected(position);
            }
        });

    }
}