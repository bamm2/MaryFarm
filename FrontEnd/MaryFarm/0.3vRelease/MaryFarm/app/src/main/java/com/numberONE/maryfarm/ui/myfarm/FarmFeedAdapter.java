package com.numberONE.maryfarm.ui.myfarm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.numberONE.maryfarm.R;
import com.numberONE.maryfarm.databinding.FragmentMyfarmProfileBinding;
import com.numberONE.maryfarm.databinding.ItemFarmFeedBinding;

import java.util.ArrayList;
import java.util.List;

public class FarmFeedAdapter extends RecyclerView.Adapter<FarmFeedAdapter.ViewHolder> {

    private ArrayList<FarmFeedData> arrayList;

    // 뷰 홀더 선언
    ViewHolder viewHolder;

    // 어댑터 + 안에 넣을 자료 선언
    public FarmFeedAdapter(ArrayList<FarmFeedData> arrayList) {

        this.arrayList = arrayList;
    }

//    // 클릭 이벤트 리스너 선언
//    public static OnDiaryClickListener onDiaryClickListener = null;
//
//    // set 클릭 이벤트 리스너 선언.... 자바 어렵당
//    public static void setOnDiaryClickListener(OnDiaryClickListener listener) {
//        onDiaryClickListener = listener;
//    }

    // 뷰홀더
    public static class ViewHolder extends  RecyclerView.ViewHolder{
        private FragmentMyfarmProfileBinding binding;
        public ImageView farm_feed_main_photo, farm_feed_sub1_photo, farm_feed_sub2_photo;
        public TextView farm_feed_title, farm_feed_time, farm_plant_date;

        public ViewHolder(View view){
            super(view);
            farm_feed_main_photo = view.findViewById(R.id.farm_feed_main_photo);
            farm_feed_sub1_photo = view.findViewById(R.id.farm_feed_sub1_photo);
            farm_feed_sub2_photo = view.findViewById(R.id.farm_feed_sub2_photo);
            farm_feed_title = view.findViewById(R.id.farm_feed_title);
            farm_feed_time = view.findViewById(R.id.farm_feed_time);
            farm_plant_date = view.findViewById(R.id.farm_plant_date);

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                유저 데이터 받아오려면 이렇게 하면 됩니다 라는 예시
//                String targetUser = holder.farm_user_name.getText().toString();
//                String feedTitle = holder.farm_feed_title.getText().toString();
                    Toast.makeText(v.getContext(),"클릭 이벤트 발생",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_calendar_plant, parent, false);

        viewHolder = new ViewHolder(holderView);


        return viewHolder;
    }


    // ViewHolder viewType
    @NonNull
    @Override
    public void onBindViewHolder(@NonNull ViewHolder mainHolder, int position) {
        mainHolder.farm_feed_main_photo.setImageResource(arrayList.get(position).getFarm_feed_main_photo());
        mainHolder.farm_feed_sub1_photo.setImageResource(arrayList.get(position).getFarm_feed_sub1_photo());
        mainHolder.farm_feed_sub2_photo.setImageResource(arrayList.get(position).getFarm_feed_sub2_photo());
        mainHolder.farm_feed_title.setText(arrayList.get(position).getFarm_feed_title());
        mainHolder.farm_feed_time.setText(arrayList.get(position).getFarm_feed_time());
        mainHolder.farm_plant_date.setText(arrayList.get(position).getFarm_plant_date());
    }
    @NonNull
    @Override
    public int getItemCount() {
        return arrayList.size();
    }

}



//    @NonNull
//    @Override
//    public FarmFeedAdapter.CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_farm_feed,parent,false);
//        CustomViewHolder holder = new CustomViewHolder(view);
//
//        return holder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull FarmFeedAdapter.CustomViewHolder holder, int position) {
//
//
//        holder.itemView.setTag(position);
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                유저 데이터 받아오려면 이렇게 하면 됩니다 라는 예시
////                String targetUser = holder.farm_user_name.getText().toString();
////                String feedTitle = holder.farm_feed_title.getText().toString();
//                Toast.makeText(v.getContext(),feedTitle,Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                remove(holder.getAdapterPosition());
//                return true;
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//
//        return (null != arrayList ? arrayList.size() : 0);
//    }
//
//    public void remove(int position) {
//        try {
//            arrayList.remove(position);
//            notifyItemRemoved(position);
//        } catch (IndexOutOfBoundsException ex) {
//            ex.printStackTrace();
//        }
//    }
//
//    public class CustomViewHolder extends RecyclerView.ViewHolder {
//
//        protected ImageView farm_feed_main_photo;
//        protected ImageView farm_feed_sub1_photo;
//        protected ImageView farm_feed_sub2_photo;
//        protected TextView farm_feed_title;
//        protected TextView farm_feed_time;
//        protected TextView farm_plant_date;
//
//        public CustomViewHolder(View itemView) {
//            super(itemView);
//            this.farm_feed_main_photo = (ImageView) itemView.findViewById(R.id.farm_feed_main_photo);
//            this.farm_feed_sub1_photo = (ImageView) itemView.findViewById(R.id.farm_feed_sub1_photo);
//            this.farm_feed_sub2_photo = (ImageView) itemView.findViewById(R.id.farm_feed_sub2_photo);
//            this.farm_feed_title = (TextView) itemView.findViewById(R.id.farm_feed_title);
//            this.farm_feed_time = (TextView) itemView.findViewById(R.id.farm_feed_time);
//            this.farm_plant_date = (TextView) itemView.findViewById(R.id.farm_plant_date);
//
//
//
//
//        }
//    }
//
//
//    private class FarmFeedAdapter extends RecyclerView.Adapter<MyFarmViewHolder>{
//        private List<String> list;
//        public FarmFeedAdapter(List<String> list){
//            this.list = list;
//        }
//
//        @NonNull
//        @Override
//        public MyFarmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//            ItemFarmFeedBinding binding = ItemFarmFeedBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
//            return new MyFarmViewHolder(binding);
//        }
//
//        @Override
//        public void onBindViewHolder(@NonNull MyFarmViewHolder holder, int position) {
//            String text = list.get(position);
////            holder.binding.itemTextView.setText(text);
//        }
//
//        @Override
//        public int getItemCount() {
//            return list.size();
//        }
//}
