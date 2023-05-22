package com.numberONE.maryfarm.ui.home.Calendar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.numberONE.maryfarm.R;

// 일자 선택 시 해당 일자에 키우고 있는 작물 정보 리스트 반환~
public class CalendarPickPlantAdapter extends RecyclerView.Adapter<CalendarPickPlantAdapter.ViewHolder> {
    private String[] plantname, dday;
    ViewHolder viewHolder;

    // 리사이클러 뷰로 들어갈 내용들 받는 부분
    public CalendarPickPlantAdapter(String[] plantname, String[] dday){
        this.plantname = plantname;
        this.dday = dday;
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView plantsNameTextView;

        public ViewHolder(View view){
            super(view);
            this.plantsNameTextView = view.findViewById(R.id.textView);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_calendar_pick_plant, parent, false);
        viewHolder = new ViewHolder(holderView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder mainHolder, int i) {
        mainHolder.plantsNameTextView.setText(this.plantname[i]+"\n"+this.dday[i]);
    }

    @Override
    public int getItemCount() {
        return plantname.length;
    }

}

