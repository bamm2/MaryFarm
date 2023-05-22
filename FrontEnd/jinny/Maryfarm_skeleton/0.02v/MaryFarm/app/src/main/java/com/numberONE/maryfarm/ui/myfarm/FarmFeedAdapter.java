package com.numberONE.maryfarm.ui.myfarm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.numberONE.maryfarm.R;

import java.util.ArrayList;

public class FarmFeedAdapter extends RecyclerView.Adapter<FarmFeedAdapter.CustomViewHolder> {

    private ArrayList<FarmFeedData> arrayList;

    public FarmFeedAdapter(ArrayList<FarmFeedData> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public FarmFeedAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_farm_feed,parent,false);
        CustomViewHolder holder = new CustomViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull FarmFeedAdapter.CustomViewHolder holder, int position) {
        holder.farm_feed_main_photo.setImageResource(arrayList.get(position).getFarm_feed_main_photo());
        holder.farm_feed_sub1_photo.setImageResource(arrayList.get(position).getFarm_feed_sub1_photo());
        holder.farm_feed_sub2_photo.setImageResource(arrayList.get(position).getFarm_feed_sub2_photo());
        holder.farm_feed_title.setText(arrayList.get(position).getFarm_feed_title());
        holder.farm_feed_time.setText(arrayList.get(position).getFarm_feed_time());
        holder.farm_plant_date.setText(arrayList.get(position).getFarm_plant_date());

        holder.itemView.setTag(position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                유저 데이터 받아오려면 이렇게 하면 됩니다 라는 예시
//                String targetUser = holder.farm_user_name.getText().toString();
                String feedTitle = holder.farm_feed_title.getText().toString();
                Toast.makeText(v.getContext(),feedTitle,Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                remove(holder.getAdapterPosition());
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {

        return (null != arrayList ? arrayList.size() : 0);
    }

    public void remove(int position) {
        try {
            arrayList.remove(position);
            notifyItemRemoved(position);
        } catch (IndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder {

        protected ImageView farm_feed_main_photo;
        protected ImageView farm_feed_sub1_photo;
        protected ImageView farm_feed_sub2_photo;
        protected TextView farm_feed_title;
        protected TextView farm_feed_time;
        protected TextView farm_plant_date;

        public CustomViewHolder(View itemView) {
            super(itemView);
            this.farm_feed_main_photo = (ImageView) itemView.findViewById(R.id.farm_feed_main_photo);
            this.farm_feed_sub1_photo = (ImageView) itemView.findViewById(R.id.farm_feed_sub1_photo);
            this.farm_feed_sub2_photo = (ImageView) itemView.findViewById(R.id.farm_feed_sub2_photo);
            this.farm_feed_title = (TextView) itemView.findViewById(R.id.farm_feed_title);
            this.farm_feed_time = (TextView) itemView.findViewById(R.id.farm_feed_time);
            this.farm_plant_date = (TextView) itemView.findViewById(R.id.farm_plant_date);




        }
    }
}
