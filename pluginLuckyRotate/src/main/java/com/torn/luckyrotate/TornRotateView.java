package com.torn.luckyrotate;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.benmu.framework.extend.hook.ui.view.HookWXImageView;
import com.torn.luckyrotate.lib.RotateView;

public class TornRotateView extends RotateView {
    protected HookWXImageView mhookWXImageView;

    public TornRotateView(Context context) {
        super(context);
    }

    public TornRotateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TornRotateView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void drawIcon(int xx, int yy, int mRadius, float startAngle, int i, Canvas mCanvas) {
        int imgWidth = mRadius / 4;

        float angle = (float) Math.toRadians(verPanRadius + startAngle);

        //确定图片在圆弧中 中心点的位置
        float x = (float) (xx + (mRadius / 2 + mRadius / 12) * Math.cos(angle));
        float y = (float) (yy + (mRadius / 2 + mRadius / 12) * Math.sin(angle));

        // 确定绘制图片的位置，前后偏移，得到图片的位置
        RectF rect = new RectF(x - imgWidth * 2 / 3, y - imgWidth * 2 / 3, x + imgWidth
                * 2 / 3, y + imgWidth * 2 / 3);
        mCanvas.drawRect(rect,textPaint);
        Bitmap bitmap = bitmaps.get(i);


        Matrix matrix = new Matrix();
        matrix.postTranslate(-bitmap.getWidth()/2, -bitmap.getHeight()/2);//把旋转中心点移动到B点
        matrix.postRotate(startAngle);
        matrix.postTranslate(rect.centerX(),rect.centerY());//屏幕的中心点
        mCanvas.drawBitmap(bitmap, matrix, null);
        matrix.reset();
       // HookWXImageView hookWXImageView = new HookWXImageView(context);
        //hookWXImageView.setCurrentUrl("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1534737307&di=34dfb403231ddc9361cf5e6e5efb91d3&imgtype=jpg&er=1&src=http%3A%2F%2Fimdl.imagemore.cn%2Fimagemore_dir%2Fcomp%2Finc2015ae%2Fing-19022-10708.jpg");
        //Bitmap bitmap = ((BitmapDrawable) hookWXImageView.getDrawable()).getBitmap();
        //绘制
        //mCanvas.drawBitmap(bitmap, null, rect, null);
    }
}
