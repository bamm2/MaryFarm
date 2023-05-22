package com.numberone.bottomnav.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.numberone.bottomnav.databinding.FragmentPheedBinding;

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