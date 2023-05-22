package com.numberONE.maryfarm.ui.board;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.numberONE.maryfarm.R;

public class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.ViewHolder> {

    private String[] title,nickname,date,viewCnt,commentCnt;
    private int[] image;

    ViewHolder viewHolder;

    public BoardAdapter(String[] title, String[] nickname,String[] date,
                        int[] image, String[] viewCnt, String[] commentCnt){
        this.title=title;
        this.nickname=nickname;
        this.date=date;
        this.image=image;
        this.viewCnt=viewCnt;
        this.commentCnt=commentCnt;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView title,nickname,date,viewCnt,commentCnt;
        public ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.title=itemView.findViewById(R.id.board_item_title);
            this.nickname=itemView.findViewById(R.id.board_item_nickname);
            this.date=itemView.findViewById(R.id.board_item_date);
            this.viewCnt=itemView.findViewById(R.id.board_item_viewCnt);
            this.commentCnt=itemView.findViewById(R.id.board_item_commentCnt);
            this.image=itemView.findViewById(R.id.board_item_image);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_board,parent,false);

        viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        try {
            viewHolder.title.setText(this.title[position]);
            viewHolder.nickname.setText(this.nickname[position]);
            viewHolder.date.setText(this.date[position]);
            viewHolder.viewCnt.setText(this.viewCnt[position]);
            viewHolder.commentCnt.setText(this.commentCnt[position]);
            viewHolder.image.setImageResource(this.image[position]);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return title.length;
    }
}
