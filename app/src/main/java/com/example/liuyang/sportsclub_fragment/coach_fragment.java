package com.example.liuyang.sportsclub_fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class coach_fragment extends Fragment {

    private List<Coach> coachList = new ArrayList<>();
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View coachLayout = inflater.inflate(R.layout.coach_layout,
                container, false);

        initCoaches();
        recyclerView = (RecyclerView)coachLayout.findViewById(R.id.coach_recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        CoachAdapter adapter = new CoachAdapter(coachList);
        recyclerView.setAdapter(adapter);

        return coachLayout;
    }

    private void initCoaches() {
        for(int i=0;i<2;i++){
            Coach coach1 = new Coach("Tom",R.drawable.touxiang);
            coachList.add(coach1);
            Coach coach2 = new Coach("Sam",R.drawable.touxiang1);
            coachList.add(coach2);
            Coach coach3 = new Coach("Jim",R.drawable.touxiang2);
            coachList.add(coach3);
        }
    }
}
