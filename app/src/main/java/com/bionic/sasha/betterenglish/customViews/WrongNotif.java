package com.bionic.sasha.betterenglish.customViews;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path.Direction;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

import com.bionic.sasha.betterenglish.R;

import retrofit2.http.Path;

/**
 * TODO: document your custom view class.
 */
public class WrongNotif extends View {


    private Paint p;
    private Paint p2;
    private android.graphics.Path path;



    public WrongNotif(Context context) {
        super(context);

        init();
    }

    public WrongNotif(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public WrongNotif(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        p = new Paint();
        p.setColor(Color.RED);
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
        canvas.drawLine(getWidth()/3, getHeight()/3, 2*getWidth()/3, 2*getWidth()/3, p2);
        canvas.drawLine(getWidth()/3, 2*getWidth()/3, 2*getWidth()/3, getWidth()/3, p2);



    }


}
