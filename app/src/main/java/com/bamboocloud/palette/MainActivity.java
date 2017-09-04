package com.bamboocloud.palette;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.graphics.Palette;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.iv).setBackgroundResource(R.drawable.ic_zc_banner2);
        Resources res = getResources();
        Bitmap bitmap = BitmapFactory.decodeResource(res, R.drawable.ic_zc_banner2);

        Palette.Builder builder = Palette.from(bitmap);
        Palette.PaletteAsyncListener listener = new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                // 使用Palette对象，获取解析出的颜色
                Palette.Swatch s1 = palette.getVibrantSwatch();       //获取到充满活力的这种色调
                Palette.Swatch s2 = palette.getDarkVibrantSwatch();    //获取充满活力的黑
                Palette.Swatch s3 = palette.getLightVibrantSwatch();   //获取充满活力的亮
                Palette.Swatch s4 = palette.getMutedSwatch();           //获取柔和的色调
                Palette.Swatch s5 = palette.getDarkMutedSwatch();      //获取柔和的黑
                Palette.Swatch s6 = palette.getLightMutedSwatch();    //获取柔和的亮
                TextView tv1 = (TextView) findViewById(R.id.view1);
                TextView tv2 = (TextView) findViewById(R.id.view2);
                TextView tv3 = (TextView) findViewById(R.id.view3);
                TextView tv4 = (TextView) findViewById(R.id.view4);
                TextView tv5 = (TextView) findViewById(R.id.view5);
                TextView tv6 = (TextView) findViewById(R.id.view6);
                if (null != s1) {
                    tv1.setBackgroundColor(s1.getRgb());
                    tv1.setText("充满活力的色调");
                } else {
                    tv5.setText("没有获取到颜色对象");
                }

                if (null != s2) {
                    tv2.setBackgroundColor(s2.getRgb());
                    tv2.setText("充满活力的黑");
                } else {
                    tv5.setText("没有获取到颜色对象");
                }

                if (null != s3) {
                    tv3.setBackgroundColor(s3.getRgb());
                    tv3.setText("充满活力的亮");
                } else {
                    tv5.setText("没有获取到颜色对象");
                }

                if (null != s4) {
                    tv4.setBackgroundColor(s4.getRgb());
                    tv4.setText("柔和的色调");
                } else {
                    tv5.setText("没有获取到颜色对象");
                }

                if (null != s5) {
                    tv5.setBackgroundColor(s5.getRgb());
                    tv5.setText("柔和的黑");
                } else {
                    tv5.setText("没有获取到颜色对象");
                }

                if (null != s6) {
                    tv6.setBackgroundColor(s6.getRgb());
                    tv6.setText("柔和的亮");
                } else {
                    tv5.setText("没有获取到颜色对象");
                }


            }
        };
        builder.generate(listener);


    }
}
