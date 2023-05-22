package com.numberone.bottomnav.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationBarView;
import com.numberone.bottomnav.databinding.FragmentCalendarBinding;

public class CalendarFragment extends Fragment {

    FragmentCalendarBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCalendarBinding.inflate(inflater, container, false);
        ViewGroup view = binding.getRoot();

        return view;
    }


}