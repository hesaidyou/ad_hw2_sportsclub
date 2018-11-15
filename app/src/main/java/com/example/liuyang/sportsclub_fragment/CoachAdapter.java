package com.example.liuyang.sportsclub_fragment;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CoachAdapter extends RecyclerView.Adapter<CoachAdapter.ViewHolder> {
    private List<Coach> mCoachList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView coachImage;
        TextView coachName;

        public ViewHolder(@NonNull View view) {
            super(view);
            coachImage = (ImageView)view.findViewById(R.id.coach_image);
            coachName = (TextView)view.findViewById(R.id.coach_name);
        }
    }

    public CoachAdapter(List<Coach> coachList){
        mCoachList = coachList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.coach_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Coach coach = mCoachList.get(position);
        holder.coachImage.setImageResource(coach.getImageId());
        holder.coachName.setText(coach.getName());
    }

    @Override
    public int getItemCount() {
        return mCoachList.size();
    }


}
