package com.numberONE.maryfarm.ui.home.Calendar;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationBarView;
import com.numberONE.maryfarm.databinding.FragmentCalendarBinding;

import java.time.DayOfWeek;
import java.time.format.DateTimeFormatter;
import java.util.Random;

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