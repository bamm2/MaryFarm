package com.numberONE.maryfarm.Home.FarmFeed;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.numberONE.maryfarm.R;

import java.util.ArrayList;

public class PheedBelowAdapter extends RecyclerView.Adapter<PheedBelowAdapter.ViewHolder> {

    private ArrayList<PheedBelowData> pheedBelowDataList;
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pheedbelow, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       PheedBelowData item = pheedBelowDataList.get(position);

       holder.name.setText(item.getName());
       holder.message.setText(item.getMessage());
       holder.profile.setImageResource(R.drawable.loading_icon);
    }

    public void setPheedBelowDataList(ArrayList<PheedBelowData> list){
        this.pheedBelowDataList =list;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return pheedBelowDataList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView profile;
        TextView name;
        TextView message;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            profile= (ImageView) itemView.findViewById(R.id.firstImg);
            name= (TextView) itemView.findViewById(R.id.nickname);
            message = (TextView) itemView.findViewById(R.id.title);
        }
    }
}
