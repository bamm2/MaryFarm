package com.numberONE.maryfarm.Home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.numberONE.maryfarm.Home.Calendar.CalendarFragment;
import com.numberONE.maryfarm.Home.FarmFeed.PheedFragment;

public class HomeAdapter extends FragmentStateAdapter {

    public int cnt;

    public HomeAdapter(FragmentActivity fa, int cnt){
        super(fa);
        this.cnt=cnt;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        int idx= getRealPosition(position);

        if(idx==0) return new PheedFragment();
        else return new CalendarFragment();
    }

    @Override
    public int getItemCount() {
        return 2;
    }

    public int getRealPosition(int position){
        return position;
    }
}
