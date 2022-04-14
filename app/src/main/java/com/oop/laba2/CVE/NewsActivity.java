package com.oop.laba2.CVE;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SearchView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.jaeger.library.StatusBarUtil;


public class NewsActivity extends AppCompatActivity {

    BottomNavigationView btm_navigation;
    SearchView sv;
    int[] id_images;
    String[] text_card;
    String under_main_text_in_card;
    ScrollView scrollView;
    LinearLayout linearLayoutInScrollView;
    View layout_item;
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        //StatusBarUtil.setTransparent(this);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
        btm_navigation = findViewById(R.id.navigation);
        btm_navigation.setSelectedItemId(R.id.navigation_news);
        enableBottomBar(false);
        sv = findViewById(R.id.searchView2);
        sv.setOnClickListener(v -> sv.setIconified(false));
        id_images = new int[6];
        id_images[0] = R.drawable.image1;
        id_images[1] = R.drawable.image2;
        id_images[2] = R.drawable.image3;
        id_images[3] = R.drawable.image4;
        id_images[4] = R.drawable.image5;
        id_images[5] = R.drawable.image6;
        text_card = new String[6];
        for (int i=0 ;i<text_card.length;i++)
        {
            text_card[i] = "Текст "+String.valueOf(i+1);
        }
        under_main_text_in_card = "ЖК Лондон";
        scrollView = findViewById(R.id.scrollView2);
        linearLayoutInScrollView = scrollView.findViewById(R.id.layout_in_scroll_view_news);

        for (int i=0 ; i<text_card.length;i+=2)
        {
            LayoutInflater inflater =(LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            layout_item = inflater.inflate(R.layout.item_news_layout,linearLayoutInScrollView, false);
            ImageView image1 = layout_item.findViewById(R.id.imageView1);
            image1.setImageResource(id_images[i]);
            TextView text1 = layout_item.findViewById(R.id.textview1);
            text1.setText(text_card[i]);
            TextView text1_under = layout_item.findViewById(R.id.textview11);
            text1_under.setText(under_main_text_in_card);
            ImageView image2 = layout_item.findViewById(R.id.imageView2);
            image2.setImageResource(id_images[i+1]);
            TextView text2 = layout_item.findViewById(R.id.textview2);
            text2.setText(text_card[i+1]);
            TextView text2_under = layout_item.findViewById(R.id.textview22);
            text2_under.setText(under_main_text_in_card);
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