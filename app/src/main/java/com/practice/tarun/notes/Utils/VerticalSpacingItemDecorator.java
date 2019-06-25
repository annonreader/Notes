package com.practice.tarun.notes.Utils;


import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;

//this is the class that will be used to make custom changes in the recyclerview
public class VerticalSpacingItemDecorator extends RecyclerView.ItemDecoration {

    private final int verticalspacing;

    public VerticalSpacingItemDecorator(int verticalspacing) {
        this.verticalspacing = verticalspacing;
    }

    @Override
    public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
        outRect.bottom = verticalspacing;
    }
}
