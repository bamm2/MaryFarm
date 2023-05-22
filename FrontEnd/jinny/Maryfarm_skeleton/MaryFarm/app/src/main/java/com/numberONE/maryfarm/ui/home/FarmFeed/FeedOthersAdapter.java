package com.numberONE.maryfarm.ui.home.FarmFeed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.numberONE.maryfarm.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class FeedOthersAdapter extends RecyclerView.Adapter<FeedOthersAdapter.ViewHolder> {
    private String[] nickname,title;
    private int[] image1,image2,image3,profile;
    ViewHolder viewHolder;


    // 생성자
    public FeedOthersAdapter(String[] nickname, String[] title,int[] image1,int[] image2,int[] image3,int[] profile){
        this.nickname = nickname;
        this.title = title;
        this.image1=image1;
        this.image2=image2;
        this.image3=image3;
        this.profile=profile;
    }


    public static class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView nickname, title;
        public ImageView image1,image2,image3;
        public CircleImageView profile;

        public ViewHolder(View view){
            super(view);
            this.nickname = view.findViewById(R.id.other_nickname);
            this.title = view.findViewById(R.id.other_title);
            this.image1=view.findViewById(R.id.other_image_1);
            this.image2=view.findViewById(R.id.other_image_2);
            this.image3=view.findViewById(R.id.other_image_3);
            this.profile=view.findViewById(R.id.other_profile);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_feed_others, parent, false);
        viewHolder = new ViewHolder(holderView);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder mainHolder, int i) {
        mainHolder.nickname.setText(this.nickname[i]);
        mainHolder.title.setText(this.title[i]);
        mainHolder.image1.setImageResource(this.image1[i]);
        mainHolder.image2.setImageResource(this.image2[i]);
        mainHolder.image3.setImageResource(this.image3[i]);
        mainHolder.profile.setImageResource(this.profile[i]);
    }

    @Override
    public int getItemCount() {
        return nickname.length;
    }
}

