package com.example.itd_stu.project_dicoding;

import android.view.View;

/**
 * Created by ITD-STU on 6/9/19.
 */

public class CustomOnItemClickListener implements View.OnClickListener{
    private int position;
    private OnItemClickCallback onItemClickCallback;
    CustomOnItemClickListener(int position, OnItemClickCallback onItemClickCallback) {
        this.position = position;
        this.onItemClickCallback = onItemClickCallback;
    }
    @Override
    public void onClick(View view) {
        onItemClickCallback.onItemClicked(view, position);
    }
    public interface OnItemClickCallback {
        void onItemClicked(View view, int position);
    }
}
