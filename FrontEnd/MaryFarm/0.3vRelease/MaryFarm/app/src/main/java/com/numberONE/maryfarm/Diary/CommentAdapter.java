package com.numberONE.maryfarm.Diary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.numberONE.maryfarm.Retrofit.Comments;
import com.numberONE.maryfarm.R;

import java.util.List;

public class CommentAdapter extends RecyclerView.Adapter<CommentAdapter.CommentViewHolder> {
    Context context;
    List<Comments> items ;

    public CommentAdapter(Context context, List<Comments> items) {
        this.context = context;
        this.items = items;
    }

    @NonNull
    @Override
    public CommentAdapter.CommentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CommentViewHolder(LayoutInflater.from(context).inflate(R.layout.recycler_comment,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CommentViewHolder holder, int position) {
        holder.nickname.setText((items.get(position).getNickname()));
        holder.commentDate.setText((items.get(position).getCreatedAt()));
        holder.content.setText((items.get(position).getContent()));
        holder.commentLike.setText(("" + items.get(position).getLikes()));
        Glide.with(context)
                .load(items.get(position).getProfileImg())
                .into(holder.profileImg);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    private static AdapterView.OnItemClickListener onItemClickListener = null;

    public static void setOnItemClickListener(AdapterView.OnItemClickListener listener){
        onItemClickListener = listener;
    }

    // viewholder 작성
    public static class CommentViewHolder extends RecyclerView.ViewHolder{

        TextView nickname, commentDate, content, commentLike;
        ImageView profileImg, emptyHeart, fullHeart;
        Button.OnClickListener clickListener;

        public CommentViewHolder(@NonNull View itemView){
            super(itemView);

            nickname = itemView.findViewById(R.id.commentNickname);
            commentDate = itemView.findViewById(R.id.commentDate);
            content = itemView.findViewById(R.id.commentContent);
            commentLike = itemView.findViewById(R.id.commentLike);
            profileImg = itemView.findViewById(R.id.commentProfileImg);
        }
    }

}
