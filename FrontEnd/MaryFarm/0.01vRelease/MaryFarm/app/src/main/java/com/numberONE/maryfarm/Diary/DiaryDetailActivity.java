package com.numberONE.maryfarm.Diary;

import static com.numberONE.maryfarm.R.*;
import static com.numberONE.maryfarm.R.id.nav_view;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.numberONE.maryfarm.Pick.PickActivity;
import com.numberONE.maryfarm.R;
import com.numberONE.maryfarm.databinding.ActivityDiaryDetailBinding;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class DiaryDetailActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener{

    // 좋아요 구현
    private boolean sign=false;
    private TextView likeCount;
    private int likeCnt = 0;

    // 팝업 메뉴창 구현 (일지 추가하기, 수정하기, 재배완료 선택)
    ImageButton popUpBtn;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_diary_detail);

        // 좋아요 구현
        likeCount = (TextView) findViewById(id.like_Count);
        likeCount.setText(likeCnt+"");

        ActivityDiaryDetailBinding binding = ActivityDiaryDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        
        // 클릭시 - 좋아요 & 숫자 증가
        binding.emptyHeartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!sign) {
                    binding.emptyHeartIcon.setVisibility(View.GONE);
                    binding.fullHeartIcon.setVisibility(View.VISIBLE);
                    sign = true;
                    likeCnt++;
                    binding.likeCount.setText(""+likeCnt);
                }
            }
        });
        
        // 클릭시 - 좋아요 취소 & 숫자 감소
        binding.fullHeartIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (sign) {
                    binding.emptyHeartIcon.setVisibility(View.VISIBLE);
                    binding.fullHeartIcon.setVisibility(View.GONE);
                    sign = false;
                    likeCnt--;
                    binding.likeCount.setText(""+likeCnt);
                }
            }
        });

        // 추천 버튼 클릭시, 추천 페이지로 화면 이동
        ImageButton pickBtn = (ImageButton) findViewById(id.pickBtn);
        pickBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DiaryDetailActivity.this, PickActivity.class);
                startActivity(intent);
                finish();
            }
        });
        
        // 댓글목록 리싸이클러뷰 출력
        RecyclerView recyclerView = findViewById(id.commentsView);

        List<CommentItem> items = new ArrayList<CommentItem>();
        items.add(new CommentItem(drawable.a,"김관섭","안녕하세요 김관섭입니다"));
        items.add(new CommentItem(drawable.b,"박수용","안녕하세요 박수용입니다"));
        items.add(new CommentItem(drawable.c,"이석우","안녕하세요 이석우입니다"));
        items.add(new CommentItem(drawable.d,"조민규","안녕하세요 조민규입니다"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CommentAdapter(getApplicationContext(),items));

//        BottomNavigationView navView = findViewById(nav_view);
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
//                id.menu_bottom_home, id.menu_bottom_chat, id.menu_bottom_write, id.menu_bottom_alarm, id.menu_bottom_farm)
//                .build();
//        NavController navController = Navigation.findNavController(this, id.nav_host_fragment_activity_main);
//        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
//        NavigationUI.setupWithNavController(binding.navView, navController);
    }

    // ... 버튼 클릭시 팝업 메뉴 출력 (일지 수정, 일지 추가, 지배완료)
    public void showPopBtn(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(menu.menu_diary_detail);
        popupMenu.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case id.editDiary:
                Intent intent = new Intent(DiaryDetailActivity.this, DiaryModifyActivity.class);
                startActivity(intent);
                finish();
                return true;
            case id.addDiary:
                Intent intent1 = new Intent(DiaryDetailActivity.this, DiaryAddActivity.class);
                startActivity(intent1);
                finish();
                return true;
            case id.plantComplete:
                Toast.makeText(this, "🌱🌻🌼 축 재배완료! 🥕🥦🌶", Toast.LENGTH_LONG).show();
                String koreaNow = LocalDate.now(ZoneId.of("Asia/Seoul")).toString();
                Log.d("dd", "korea date "+koreaNow);

                TextView endDate = findViewById(id.endDate);
                endDate.setText(koreaNow);

                return true;
            default:
                return false;
        }
    }
    
    // 키보드 이외의 곳 터치할 경우, 키보드 사라지게하기
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View view = getCurrentFocus();
        if (view != null && (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) && view instanceof EditText && !view.getClass().getName().startsWith("android.webkit.")) {
            int scrcoords[] = new int[2];
            view.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + view.getLeft() - scrcoords[0];
            float y = ev.getRawY() + view.getTop() - scrcoords[1];
            if (x < view.getLeft() || x > view.getRight() || y < view.getTop() || y > view.getBottom())
                ((InputMethodManager)this.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow((this.getWindow().getDecorView().getApplicationWindowToken()), 0);
        }
        return super.dispatchTouchEvent(ev);
    }
}