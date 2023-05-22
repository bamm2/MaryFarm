package com.example.mylittlefarm;

public class Comment {
    int commentProfile;
    String commentUserName;
    String commentContent;
    int commentDate;
    String commentReply;

    public Comment(int commentProfile, String commentUserName, String commentContent, int commentDate, String commentReply){
        this.commentProfile = commentProfile;
        this.commentUserName = commentUserName;
        this.commentContent = commentContent;
        this.commentDate = commentDate;
        this.commentReply = commentReply;
    }
}
