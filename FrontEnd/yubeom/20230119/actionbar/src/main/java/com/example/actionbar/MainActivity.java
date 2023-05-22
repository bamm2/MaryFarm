package com.example.actionbar;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        뒤로가기 버튼 만들고 싶은 페이지에서 사용
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true); // 뒤로가기 버튼 활성화

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); // Activity의 App bar로 지정

    }

//    @Override // 뒤로 가기
//    public boolean onSupportNavigateUp() {
//        onBackPressed();
//        return super.onSupportNavigateUp();
//    }


//    메뉴 메서드 시작 !

    @Override // 메뉴 선택
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem menuItem =menu.findItem(R.id.menu_search);
        searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(queryTextListener);
        return super.onCreateOptionsMenu(menu);
    }

    // 검색 버튼 로직 만들기
    SearchView.OnQueryTextListener queryTextListener =new SearchView.OnQueryTextListener() {
        @Override // 최종 검색을 위해 제출버튼 눌렀을 때
        public boolean onQueryTextSubmit(String query) {
            searchView.setQuery("",false);
            searchView.setIconified(true);
            Toast t = Toast.makeText(MainActivity.this,query,Toast.LENGTH_SHORT);
            t.show();
            return false;
        }

        @Override // 유저가 한글자 한글자 입력할 때
        public boolean onQueryTextChange(String newText) {
            return false;
        }
    };

    //앱바에 표시된 액션 또는 오버플로우 메뉴가 선택되면 메서드 호출
    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_setting:
                Toast t = Toast.makeText(MainActivity.this, "setting click", Toast.LENGTH_SHORT);
                t.show();
                return true;
            case R.id.test1:
                startActivity(new Intent(this, ToolBarActivity.class));
                return true;
            case R.id.test2:
                startActivity(new Intent(this, ToolBarActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}