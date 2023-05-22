package com.example.mylittlefarm;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CommentsList extends RecyclerView.ViewHolder {

    ImageView commentProfile;
    TextView commentUserName, commentContent, commentDate, commentReply;

    public CommentsList(@NonNull @org.jetbrains.annotations.NotNull View itemComment) {
        super(itemComment);
        commentProfile = itemComment.findViewById(R.id.commentProfile);
        commentUserName = itemComment.findViewById(R.id.commentUserName);
        commentContent = itemComment.findViewById(R.id.commentContent);
        commentDate = itemComment.findViewById(R.id.commentDate);
        commentReply = itemComment.findViewById(R.id.commentReply);
    }
}