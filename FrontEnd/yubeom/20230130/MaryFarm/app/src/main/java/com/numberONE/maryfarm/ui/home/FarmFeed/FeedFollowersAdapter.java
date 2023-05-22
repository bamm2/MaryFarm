package com.numberONE.maryfarm.ui.home.FarmFeed;


import android.net.Uri;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.numberONE.maryfarm.R;

import de.hdodenhof.circleimageview.CircleImageView;


// 상단 팔로워 피드 리사이클러뷰 adapter
public class FeedFollowersAdapter extends RecyclerView.Adapter<FeedFollowersAdapter.ViewHolder> {

//    private String[] profile,image;
    private int[] profile,image;

    ViewHolder viewHolder;

//    public FeedFollowersAdapter(String[] profilepath,String[] imagepath){
//        this.profilepath=profilepath;
//        this.imagepath=imagepath;
//    }

    public FeedFollowersAdapter(int[] profile,int[] image){
        this.profile=profile;
        this.image=image;
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{

        public ImageView image;
        public CircleImageView profile;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.image= itemView.findViewById(R.id.follower_image);
            this.profile=itemView.findViewById(R.id.follower_profile);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_feed_followers,parent,false);

        viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        try {
//            Uri profilepathUri = Uri.parse("file:///" + Environment.getExternalStorageDirectory() + imagepath[position]);
//            Uri imagepathUri = Uri.parse("file:///" + Environment.getExternalStorageDirectory() + profilepath[position]);
//            viewHolder.profilepath.setImageURI(profilepathUri);
//            viewHolder.imagepath.setImageURI(imagepathUri);

            viewHolder.profile.setImageResource(this.profile[position]);
            viewHolder.image.setImageResource(this.image[position]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return image.length;
    }



}

