package com.numberONE.maryfarm.ui.home.Calendar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.numberONE.maryfarm.R;

// 달력 진입 시 키우고 있는 작물 리스트 체크박스 반환~
public class CalendarPlantsAdapter extends RecyclerView.Adapter<CalendarPlantsAdapter.ViewHolder> {
    private String[] plantname, dday;
    ViewHolder viewHolder;

//    // 커스텀 리스너 인터페이스 정의
//    public interface OnPlantCheckListener {
//        void onPlantCheckClick(View v, int position) ;
//
//    }
//    // 리스너 객체 참조를 저장하는 변수
//    private OnPlantCheckListener mListener = null ;
//
//
//    // OnItemClickListener 리스너 객체 참조를 어댑터에 전달하는 메서드
//    public void setOnItemClickListener(OnPlantCheckListener listener) {
//        mListener = listener;
//    }
    // 리사이클러 뷰로 들어갈 내용들 받는 부분
    public CalendarPlantsAdapter(String[] plantname, String[] dday){
        this.plantname = plantname;
        this.dday = dday;
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView checkboxtitle;
        public TextView checkbox;

        public ViewHolder(View view){
            super(view);
            this.checkboxtitle = view.findViewById(R.id.check_box_text);
            this.checkbox = view.findViewById(R.id.check_plant_appearance);

            //리스너 객체 전달 메서드와 변수 추가
            //아이템 클릭 시, 커스텀 이벤트 메서드를 호출
//            view.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    int pos = getAdapterPosition() ;
//                    if (pos != RecyclerView.NO_POSITION) {
//                        // 리스너 객체의 메서드 호출.
//                        if (mListener != null) {
//                            mListener.onItemClick(v, pos) ;
//
//                        notifyItemChanged(pos) ;
//                        }
//                    }
//                }
//            });
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View holderView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_calendar_plant, parent, false);
        viewHolder = new ViewHolder(holderView);

//        holderView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int position = viewHolder.getAdapterPosition();
//                if (position != RecyclerView.NO_POSITION) {
//
//                }
//                mListener.onPlantCheckClick(v, position);
//            }
//        });

        return viewHolder;
    }
// ViewHolder viewType
    @Override
    public void onBindViewHolder(@NonNull ViewHolder mainHolder, int i) {
        mainHolder.checkboxtitle.setText(this.plantname[i]+"\n"+this.dday[i]);
    }

    @Override
    public int getItemCount() {
        return plantname.length;
    }

}

