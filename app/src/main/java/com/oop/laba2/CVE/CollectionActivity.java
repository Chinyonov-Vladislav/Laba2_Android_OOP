package com.oop.laba2.CVE;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jaeger.library.StatusBarUtil;

public class CollectionActivity extends AppCompatActivity {
    BottomNavigationView btm_navigation;
    SearchView sv;
    ScrollView scrollView;
    LinearLayout linearLayoutInScrollView;
    View layout_item;
    String[] strings_for_item_collection;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        //StatusBarUtil.setTransparent(this);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
        btm_navigation = findViewById(R.id.navigation);
        btm_navigation.setSelectedItemId(R.id.navigation_collections);
        enableBottomBar(false);
        sv = findViewById(R.id.searchView1);
        sv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sv.setIconified(false);
            }
        });
        strings_for_item_collection = new String[3];
        strings_for_item_collection[0] = getResources().getString(R.string.text_item_collection_1);
        strings_for_item_collection[1] = getResources().getString(R.string.text_item_collection_2);
        strings_for_item_collection[2] = getResources().getString(R.string.text_item_collection_3);
        scrollView = findViewById(R.id.scrollView3);
        linearLayoutInScrollView = scrollView.findViewById(R.id.linearLayoutInScrollView);
        for (int i=0; i<strings_for_item_collection.length;i++)
        {
            LayoutInflater inflater =(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout_item = inflater.inflate(R.layout.item_collection_layout,linearLayoutInScrollView, false);
            TextView text_item_collection = (TextView) layout_item.findViewById(R.id.textView4);
            text_item_collection.setText(strings_for_item_collection[i]);
            linearLayoutInScrollView.addView(layout_item);
        }
    }
    @Override
    public void onBackPressed() {
       finish();
    }
    private void enableBottomBar(boolean enable){
        for (int i = 0; i < btm_navigation.getMenu().size(); i++) {
            btm_navigation.getMenu().getItem(i).setEnabled(enable);
        }
    }
}