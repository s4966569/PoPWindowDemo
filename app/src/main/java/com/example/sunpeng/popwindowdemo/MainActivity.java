package com.example.sunpeng.popwindowdemo;

import android.annotation.TargetApi;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        View view =findViewById(R.id.view);
        final View view1 = findViewById(R.id.view1);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWindow(view);
            }
        });

        view1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showWindow1(view1);
            }
        });
    }

    private void showWindow(View view){
        View contentView = getLayoutInflater().inflate(R.layout.popwindow,null);
        PopupWindow popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        Log.i("viewHeight",""+view.getHeight());
        Log.i("contentHeight", "" + contentView.getHeight());
        Log.i("popHeight", ""+popupWindow.getHeight());
        popupWindow.showAsDropDown(view,-convertDpToPx(120),-view.getHeight()- convertDpToPx(40));
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void showWindow1(View view){
        View contentView = getLayoutInflater().inflate(R.layout.popwindow,null);
        PopupWindow popupWindow = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new ColorDrawable(0));
//        popupWindow.showAsDropDown(view,0,0,Gravity.BOTTOM);
        popupWindow.showAtLocation(view,Gravity.CENTER,100 ,0);
    }

    private int convertDpToPx(int dp){
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        return Math.round(dp*displayMetrics.density);
    }
}
