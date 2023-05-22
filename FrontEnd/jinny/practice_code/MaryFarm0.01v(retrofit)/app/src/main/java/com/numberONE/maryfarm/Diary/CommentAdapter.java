package com.numberONE.maryfarm.Diary;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.numberONE.maryfarm.R;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentViewHolder> {

    Context context;
    List<CommentItem> items;

    public CommentAdapter(Context context, List<CommentItem> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CommentViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_comment,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        holder.nameView.setText((items.get(position).getProfileName()));
        holder.contentView.setText((items.get(position).getCommentContent()));
        holder.imageView.setImageResource(items.get(position).getProfileImg());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
