package com.numberONE.maryfarm.ui.home.Calendar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.numberONE.maryfarm.R;

public class CalendarPlantsAdapter extends RecyclerView.Adapter<CalendarPlantsAdapter.ViewHolder> {
    private String[] plantname, dday;
    ViewHolder viewHolder;

    public CalendarPlantsAdapter(String[] plantname, String[] dday){
        this.plantname = plantname;
        this.dday = dday;
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView checkboxtitle;

        public ViewHolder(View view){
            super(view);
            this.checkboxtitle = view.findViewById(R.id.check_box_text);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_calendar_plant, parent, false);
        viewHolder = new ViewHolder(holderView);

        return viewHolder;
    }
// ViewHolder viewType
    @Override
    public void onBindViewHolder(@NonNull ViewHolder mainHolder, int i) {
        mainHolder.checkboxtitle.setText(this.plantname[i]+"\n"+this.dday[i]);
    }

    @Override
    public int getItemCount() {
        return plantname.length;
    }
}

