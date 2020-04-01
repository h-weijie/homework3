package com.example.chapter3.homework;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private final int ItemNum=24;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item,viewGroup,false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.bind(i);
    }

    @Override
    public int getItemCount() {
        return ItemNum;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private final RainbowTextView my_rtv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            my_rtv=itemView.findViewById(R.id.my_rtv);
        }

        public void bind(int position){
            my_rtv.setText("Item "+(position+1));
        }

    }
}
