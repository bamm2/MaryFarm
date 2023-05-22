package com.numberONE.maryfarm.Diary;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.numberONE.maryfarm.R;
import com.numberONE.maryfarm.databinding.ActivityDiaryDetailBinding;

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
        setContentView(R.layout.activity_diary_detail);

        // 좋아요 구현
        likeCount = (TextView) findViewById(R.id.like_Count);
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
        
        // 댓글목록 리싸이클러뷰 출력
        RecyclerView recyclerView = findViewById(R.id.commentsView);

        List<CommentItem> items = new ArrayList<CommentItem>();
        items.add(new CommentItem(R.drawable.a,"김관섭","안녕하세요 김관섭입니다"));
        items.add(new CommentItem(R.drawable.b,"박수용","안녕하세요 박수용입니다"));
        items.add(new CommentItem(R.drawable.c,"이석우","안녕하세요 이석우입니다"));
        items.add(new CommentItem(R.drawable.d,"조민규","안녕하세요 조민규입니다"));

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CommentAdapter(getApplicationContext(),items));
    }

    public void showPopBtn(View v) {
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.menu_diary_detail);
        popupMenu.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.editDiary:
                Toast.makeText(this, "일지 수정하기!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.addDiary:
                Toast.makeText(this, "일지 작성하기!", Toast.LENGTH_LONG).show();
                return true;
            case R.id.plantComplete:
                Toast.makeText(this, "재배완료!", Toast.LENGTH_LONG).show();
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