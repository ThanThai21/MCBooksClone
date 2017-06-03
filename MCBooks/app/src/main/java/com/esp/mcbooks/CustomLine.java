package com.esp.mcbooks;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Admin on 30/5/2017.
 */

public class CustomLine extends View {
    public CustomLine(Context context) {
        super(context);
    }

    public CustomLine(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomLine(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public CustomLine(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(getSolidColor());
        canvas.drawLine(0, getY(), getHeight(), getY(), paint);
    }
}
