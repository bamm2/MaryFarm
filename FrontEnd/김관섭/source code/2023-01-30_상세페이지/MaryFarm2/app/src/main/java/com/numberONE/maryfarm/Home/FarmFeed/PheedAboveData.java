package com.numberONE.maryfarm.Home.FarmFeed;

public class PheedAboveData {

    //상단 피드 리사이클러뷰의 item에 들어갈 데이터
    String id; // 아이디 받아 놔두기 ( 사진 클릭시 넘어갈 때 사용 )
    int contentImg; // 작물에 대한 사진 , 타입 결정하기  ( string,int,long ? )
    int userImg; // 유저 사진 , 타입 결정하기

    // 생성자
    public PheedAboveData(String id, int contentImg, int userImg) {
        this.id = id;
        this.contentImg = contentImg;
        this.userImg = userImg;
    }

    public String getId() {
        return id;
    }

    public int getContentImg() {
        return contentImg;
    }

    public int getUserImg() {
        return userImg;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setContentImg(int contentImg) {
        this.contentImg = contentImg;
    }

    public void setUserImg(int userImg) {
        this.userImg = userImg;
    }
}
