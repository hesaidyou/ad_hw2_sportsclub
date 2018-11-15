package com.example.liuyang.sportsclub_fragment;


import android.content.Intent;
import android.graphics.Color;
import android.provider.ContactsContract;


import android.app.FragmentManager;
import android.app.FragmentTransaction;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private main_fragment mainFragment;
    private coach_fragment coachFragment;
    private world_fragment worldFragment;
    private myself_fragment myselfFragment;
    private List<View> bottomTabs;
    private View mainLayout;
    private View coachLayout;
    private View worldLayout;
    private View myselfLayout;
    private ImageView mainImage;
    private ImageView coachImage;
    private ImageView worldImage;
    private ImageView myselfImage;
    private TextView mainText;
    private TextView coachText;
    private TextView worldText;
    private TextView myselfText;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.homepage);
        initViews();
        fragmentManager = getFragmentManager();
        setSelectTab(0);
    }

    private void initViews() {
        mainLayout = findViewById(R.id.mainlayout);
        coachLayout = findViewById(R.id.coachlayout);
        worldLayout = findViewById(R.id.worldlayout);
        myselfLayout = findViewById(R.id.myselflayout);

        mainImage = (ImageView) findViewById(R.id.main_image);
        coachImage = (ImageView) findViewById(R.id.coach_image);
        worldImage = (ImageView) findViewById(R.id.world_image);
        myselfImage = (ImageView) findViewById(R.id.myself_image);

        mainText = (TextView) findViewById(R.id.main_text);
        coachText = (TextView) findViewById(R.id.coach_text);
        worldText = (TextView) findViewById(R.id.world_text);
        myselfText = (TextView) findViewById(R.id.myself_text);

        mainLayout.setOnClickListener(this);
        coachLayout.setOnClickListener(this);
        worldLayout.setOnClickListener(this);
        myselfLayout.setOnClickListener(this);

        bottomTabs = new ArrayList<>(4);
        bottomTabs.add(mainLayout);
        bottomTabs.add(coachLayout);
        bottomTabs.add(worldLayout);
        bottomTabs.add(myselfLayout);


    }




    private void setSelectTab(int index) {
        clearSelection();
        // 开启一个Fragment事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        // 先隐藏掉所有的Fragment，以防止有多个Fragment显示在界面上的情况
        hideFragments(transaction);
        switch (index) {
            case 0:
                mainImage.setImageResource(R.drawable.main_main);
                mainText.setTextColor(Color.parseColor("#00c98d"));
                if (mainFragment == null) {
                    mainFragment = new main_fragment();
                    transaction.add(R.id.content, mainFragment);
                } else {
                    transaction.show(mainFragment);
                }
                break;
            case 1:
                coachImage.setImageResource(R.drawable.main_coach);
                coachText.setTextColor(Color.parseColor("#00c98d"));
                if (coachFragment == null) {
                    coachFragment = new coach_fragment();
                    transaction.add(R.id.content, coachFragment);
                } else {
                    transaction.show(coachFragment);
                }


                break;
            case 2:
                worldImage.setImageResource(R.drawable.main_world);
                worldText.setTextColor(Color.parseColor("#00c98d"));
                if (worldFragment == null) {
                    worldFragment = new world_fragment();
                    transaction.add(R.id.content, worldFragment);
                } else {
                    transaction.show(worldFragment);
                }
                break;
            case 3:
                myselfImage.setImageResource(R.drawable.main_me);
                myselfText.setTextColor(Color.parseColor("#00c98d"));
                if (myselfFragment == null) {
                    myselfFragment = new myself_fragment();
                    transaction.add(R.id.content, myselfFragment);
                } else {
                    transaction.show(myselfFragment);
                }
                break;
            default:
                break;
        }
        transaction.commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.mainlayout:
                setSelectTab(0);
                break;
            case R.id.coachlayout:
                setSelectTab(1);
                break;
            case R.id.worldlayout:
                setSelectTab(2);
                break;
            case R.id.myselflayout:
                setSelectTab(3);
                break;
            default:
                break;
        }
    }

    private void clearSelection() {
        mainImage.setImageResource(R.drawable.main_main);
        myselfText.setTextColor(Color.parseColor("#82858b"));
        coachImage.setImageResource(R.drawable.main_coach);
        coachText.setTextColor(Color.parseColor("#82858b"));
        worldImage.setImageResource(R.drawable.main_world);
        worldText.setTextColor(Color.parseColor("#82858b"));
        myselfImage.setImageResource(R.drawable.main_me);
        myselfText.setTextColor(Color.parseColor("#82858b"));
    }

    private void hideFragments(FragmentTransaction transaction) {
        if (mainFragment != null) {
            transaction.hide(mainFragment);
        }
        if (coachFragment != null) {
            transaction.hide(coachFragment);
        }
        if (worldFragment != null) {
            transaction.hide(worldFragment);
        }
        if (myselfFragment != null) {
            transaction.hide(myselfFragment);
        }
    }

}
