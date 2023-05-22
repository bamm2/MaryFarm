package com.numberONE.maryfarm.Home.FarmFeed;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.numberONE.maryfarm.databinding.FragmentPheedBinding;


public class PheedFragment extends Fragment {

    private FragmentPheedBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentPheedBinding.inflate(inflater,container,false);
        ViewGroup view = binding.getRoot();
        return view;
    }
}