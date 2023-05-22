package com.numberONE.maryfarm.Home.FarmFeed;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.numberONE.maryfarm.databinding.FragmentPheedBinding;

import java.util.ArrayList;

public class PheedFragment extends Fragment {

    // 리사이클러뷰 생성
    private RecyclerView recyclerView;
    // 어댑터 생성
    private PheedAboveAdapter pheedAdapter;
    // 데이터를 담기 위한 리스트
    private ArrayList<PheedAboveData> pheedList=new ArrayList<>();
    private FragmentPheedBinding binding;

    public PheedBelowAdapter pheedBelowAdapter;
    public ArrayList<PheedBelowData> pheedBelowData=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.e("로그", "pheedFragment - onCreateView() " );
        binding = FragmentPheedBinding.inflate(inflater,container,false);

        recyclerView.setHasFixedSize(true);

        ViewGroup view = binding.getRoot();
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.e("로그", "pheedFragment - onStart() " );

//        리스트에 데이터를 추가해주는 코드 작성

        for(int i=0;i<5;i++){
            pheedList.add(new PheedAboveData("1",1,1));
        }

//        recyclerview에 데이터 전송
        pheedAdapter =new PheedAboveAdapter(pheedList);
        RecyclerView.LayoutManager mlayoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mlayoutManager);
        recyclerView.setAdapter(pheedAdapter);

    }
}