package com.numberONE.maryfarm.Home.FarmFeed;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.numberONE.maryfarm.R;

import java.util.ArrayList;

public class PheedAboveAdapter extends RecyclerView.Adapter<PheedAboveAdapter.Viewholder>{

    //만들어 둔 데이터 클래스 리스트로 만들기
    private ArrayList<PheedAboveData> pheedDataList;

    // adapter 전달해주기 위해 생성
    public PheedAboveAdapter(ArrayList<PheedAboveData> pheedData){
        this.pheedDataList=pheedData;
    }

    @NonNull
    @Override // 어떤 레이아웃과 연결해야되는지 설정하고 View 생성
    public Viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pheedabove,parent,false);
        Viewholder holder =new Viewholder(view);
        return holder;
    }

    @Override // 받아온 데이터를 item_pheedabove에 set 해주기
    public void onBindViewHolder(@NonNull Viewholder holder, int position) {
        holder.contentImg.setImageResource(pheedDataList.get(position).getContentImg());
        holder.userImg.setImageResource(pheedDataList.get(position).getUserImg());
    }

    @Override // 아이템 카운트
    public int getItemCount() {
//        return ( null != pheedDataList ? pheedDataList.size() : 0);
        return pheedDataList.size();
    }

    // item 데이터 초기화해주는 클래스
    public class Viewholder extends RecyclerView.ViewHolder{
        ImageView contentImg;
        ImageView userImg;
        public Viewholder(@NonNull View itemView){
            super(itemView);

            contentImg= (ImageView) itemView.findViewById(R.id.contentImg);
            userImg= (ImageView) itemView.findViewById(R.id.userImg);
        }
    }

}