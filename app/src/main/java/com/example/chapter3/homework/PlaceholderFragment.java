package com.example.chapter3.homework;


import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationSet;
import android.view.animation.LinearInterpolator;

import com.airbnb.lottie.LottieAnimationView;

public class PlaceholderFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        view =inflater.inflate(R.layout.fragment_placeholder, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
                LottieAnimationView loading=view.findViewById(R.id.loading);
                ObjectAnimator fadeout=ObjectAnimator.ofFloat(loading,"alpha",1,0);
                fadeout.setDuration(1000);
                fadeout.setInterpolator(new LinearInterpolator());
                fadeout.start();

                RecyclerView friendList=view.findViewById(R.id.friendList);
                friendList.setLayoutManager(new LinearLayoutManager(view.getContext()));
                friendList.setAdapter(new MyAdapter());
                ObjectAnimator fadein=ObjectAnimator.ofFloat(friendList,"alpha",0,1);
                fadein.setDuration(1000);
                fadein.setInterpolator(new LinearInterpolator());
                fadein.start();
            }
        }, 5000);
    }
}
