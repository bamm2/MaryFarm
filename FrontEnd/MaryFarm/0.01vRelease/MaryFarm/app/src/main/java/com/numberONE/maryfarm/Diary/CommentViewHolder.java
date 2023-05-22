package com.numberONE.maryfarm.Diary;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.numberONE.maryfarm.R;

public class CommentViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    TextView nameView, contentView;

    public CommentViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageview);
        nameView = itemView.findViewById(R.id.nickname);
        contentView = itemView.findViewById(R.id.content);
    }
}
