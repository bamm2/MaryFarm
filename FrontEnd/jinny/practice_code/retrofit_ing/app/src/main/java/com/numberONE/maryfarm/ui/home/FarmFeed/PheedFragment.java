package com.numberONE.maryfarm.ui.home.FarmFeed;

import static android.content.ContentValues.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.numberONE.maryfarm.AppUtil;
import com.numberONE.maryfarm.ItemModel;
import com.numberONE.maryfarm.MainActivity;
import com.numberONE.maryfarm.PageListModel;
import com.numberONE.maryfarm.RetrofitFactory;
import com.numberONE.maryfarm.RetrofitService;
import com.numberONE.maryfarm.databinding.FragmentPheedBinding;
import com.numberONE.maryfarm.databinding.ItemMainBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PheedFragment extends Fragment {

    private FragmentPheedBinding binding;
    private static final String userId = "1111";
    private List article_result;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup pheedParentLayout,
                             Bundle savedInstanceState) {
        binding = FragmentPheedBinding.inflate(inflater,pheedParentLayout,false);
        ViewGroup view = binding.getRoot();

        RetrofitService networkService = RetrofitFactory.create();
        networkService.getList()
                .enqueue(new Callback<List<ItemModel>>() {
                    @Override
                    public void onResponse(Call<List<ItemModel>> call, Response<List<ItemModel>> response){
                        if(response.isSuccessful()){
                            Log.i(TAG, "onResponse: 서버와 연결");
                            Myadapter adapter = new Myadapter(response.body());
                            binding.mainList.setAdapter(adapter);
                            //binding.alarmText.setText(response.body().);
                        }
                    }
                    @Override
                    public void onFailure(Call<List<ItemModel>> call, Throwable t){
                        Log.e(TAG, "onFailure: 서버 연결 실패");
                        Log.e(TAG, "onFailure:", t);
                    }
                });

        return view;
    }
    class ItemViewHolder extends RecyclerView.ViewHolder {
        ItemMainBinding binding;
        public ItemViewHolder(ItemMainBinding binding){
            super(binding.getRoot());
            this.binding = binding;
            Log.i(TAG, "ItemViewHolder:"+this);
        }
    }
    class Myadapter extends RecyclerView.Adapter<ItemViewHolder> {
        List<ItemModel> articles;
        public Myadapter(List<ItemModel> articles){
            this.articles = articles;
        }
        @Override
        public int getItemCount() {
            Log.d("size", "1");
            return articles.size();
        }
        @NonNull
        @Override
        public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup pheedParentLayout, int viewType) {
            ItemMainBinding binding = ItemMainBinding.inflate(LayoutInflater.from(pheedParentLayout.getContext()), pheedParentLayout, false);
            return new ItemViewHolder(binding);
        }

        @Override
        public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
            ItemModel item = articles.get(position);
            String author = item.plant == null || item.plant.isEmpty() ? "Anonymous" : item.plant;
            String titleString = author+" - "+item.content;

            holder.binding.itemTitle.setText(titleString);
            //holder.binding.itemTime.setText(AppUtil.getDate(item.createdAt));
            holder.binding.itemDesc.setText(item.content);

            Glide.with(getParentFragment()).load(item.imagepath).override(250, 200).into(holder.binding.itemImage);
            Log.e(TAG, "onBindViewHolder:"+ this);
        }
    }
}