package com.numberONE.maryfarm.ui.myfarm;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.numberONE.maryfarm.Diary.DiaryAddActivity;
import com.numberONE.maryfarm.Diary.DiaryDetailActivity;
import com.numberONE.maryfarm.Pick.PickAlgorithm;
import com.numberONE.maryfarm.R;
import com.numberONE.maryfarm.databinding.FragmentMyfarmProfileBinding;

import java.util.ArrayList;


public class MyfarmFragment extends Fragment {

    public MyfarmFragment() {
        // Required empty public constructor
    }

// -------------------- 상단 페이지 ----------------------------
// 레트로 핏 로직 작성 필요 (유저 정보 불러오기)





// -------------------- 리사이클러 뷰 페이지 ----------------------------
// --------------- 이 부분 살리면 에러납니다.... -------------------------

//    // 바인딩
//    private FragmentMyfarmProfileBinding binding;
//
//    // 임시 아이디 배정
//    public String userId = "22222";
//
//
//    // 리사이클러 뷰 선언 코드
//
//    RecyclerView profile_rv;
//    RecyclerView.LayoutManager profileLayoutmanager;
//    RecyclerView.Adapter profileAdapter;
//
//    ArrayList<FarmFeedData> arrayList;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        binding = FragmentMyfarmProfileBinding.inflate(inflater, container, false);
//        ViewGroup view = binding.getRoot();
//
//
//        // 어댑터 연결: 뷰와 매니저 선언
//        profile_rv = binding.profileRv;
//        profileLayoutmanager = new LinearLayoutManager(getActivity());
//        // 선언한 두 부분을 연결
//        profile_rv.setLayoutManager(profileLayoutmanager);
//        // 넣어줄 데이터를 담아서 가져가는 어댑터 ( 괄호안에 넣어서 어댑터로 슝 )
//        profileAdapter = new FarmFeedAdapter(arrayList);
//        // rv에 어댑터 연결
//        profile_rv.setAdapter(profileAdapter);
//    }



// -------------------- 하단 페이지 ----------------------------

    // 제가 작성한 글이 없을 시, 하단 페이지에서 보여줄 각 버튼 집합
    private View view;

    // 버튼 클릭시 디테일 화면으로 이동
    private Button detailBtn;

    // 취향 추천 알고리즘 페이지로 리다이렉트 시키는 버튼인데, 임시로 첫글 작성 버튼으로 만듦
    private ImageButton recommendBtn;

    // 취향 추천 알고리즘 페이지로 리다이렉트 시키는 버튼
    private ImageButton recommendMonthBtn;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_myfarm_profile,container,false);

        detailBtn = (Button) view.findViewById(R.id.detailBtn);
        recommendBtn = (ImageButton) view.findViewById(R.id.recommendBtn);
        recommendMonthBtn = (ImageButton) view.findViewById(R.id.recommendMonthBtn);

        detailBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DiaryDetailActivity.class); //fragment라서 activity intent와는 다른 방식
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        recommendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DiaryAddActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });

        recommendMonthBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PickAlgorithm.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
            }
        });
        return view;
    }

}