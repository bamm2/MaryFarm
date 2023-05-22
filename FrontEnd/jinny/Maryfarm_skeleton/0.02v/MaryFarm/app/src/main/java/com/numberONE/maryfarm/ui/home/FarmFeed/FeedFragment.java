package com.numberONE.maryfarm.ui.home.FarmFeed;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.numberONE.maryfarm.R;
import com.numberONE.maryfarm.databinding.FragmentFeedBinding;


public class FeedFragment extends Fragment {

    private FragmentFeedBinding binding;
    RecyclerView recyclerView_followers,recyclerView_others;
    RecyclerView.LayoutManager layoutManager_followers,layoutManager_others;
    RecyclerView.Adapter adapter_follower,adapter_others;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFeedBinding.inflate(inflater,container,false);

        recyclerView_followers=binding.followerFeed;
        layoutManager_followers=new LinearLayoutManager(getActivity(),RecyclerView.HORIZONTAL,false);
        recyclerView_followers.setLayoutManager(layoutManager_followers);

//        String[] imagepath={"12345","213123"};
//        String[] profilepath={"adsasd","asdwwdd"};

        int[] imagepath={R.drawable.gallery_icon,R.drawable.gallery_icon,R.drawable.gallery_icon};
        int[] profilepath={R.drawable.loading_icon,R.drawable.loading_icon,R.drawable.loading_icon};

        adapter_follower=new FeedFollowersAdapter(profilepath,imagepath);

        recyclerView_followers.setAdapter(adapter_follower);


        recyclerView_others=binding.otherFeed;
        layoutManager_others =new LinearLayoutManager(getActivity());
        recyclerView_others.setLayoutManager(layoutManager_others);

        String[] nickname={"마리","팜","농사지어요"};
        String[] title={"배포까지","영차영차","ㄱ끄아.."};
        int[] image_1={R.drawable.gallery_icon,R.drawable.gallery_icon,R.drawable.gallery_icon};
        int[] image_2={R.drawable.gallery_icon,R.drawable.gallery_icon,R.drawable.gallery_icon};
        int[] image_3={R.drawable.gallery_icon,R.drawable.gallery_icon,R.drawable.gallery_icon};
        int[] profile={R.drawable.loading_icon,R.drawable.loading_icon,R.drawable.loading_icon};

        adapter_others=new FeedOthersAdapter(nickname,title,image_1,image_2,image_3,profile);

        recyclerView_others.setAdapter(adapter_others);

        ViewGroup view = binding.getRoot();
        return view;
    }
}