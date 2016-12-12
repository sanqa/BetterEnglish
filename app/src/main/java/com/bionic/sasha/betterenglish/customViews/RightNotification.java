package com.bionic.sasha.betterenglish.customViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by SASHA on 12.12.2016.
 */

public class RightNotification extends View {
    private Paint p;
    private Paint p2;
    private android.graphics.Path path;



    public RightNotification(Context context) {
        super(context);

        init();
    }

    public RightNotification(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RightNotification(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        p = new Paint();
        p.setColor(Color.GREEN);
        p.setStrokeWidth(14);
        p.setStyle(Paint.Style.FILL_AND_STROKE);
        p.setAntiAlias(true);

        p2 = new Paint();
        p2.setColor(Color.WHITE);
        p2.setStrokeWidth(14);
        p2.setStyle(Paint.Style.FILL_AND_STROKE);

    }




    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.drawCircle(getWidth()/2, getHeight()/2, 100, p);
        canvas.drawLine(5*getWidth()/16-5,getHeight()/2, getWidth()/2-5, 3*getHeight()/4, p2);
        canvas.drawLine(getWidth()/2-8, 3*getHeight()/4, 3*getWidth()/4-5, getHeight()/3, p2);


    }

}
