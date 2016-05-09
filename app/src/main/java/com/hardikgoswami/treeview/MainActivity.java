package com.hardikgoswami.treeview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    DemoView demoview;
    List<Integer> tree;
    Context context;
    float dpHeight,dpWidth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tree = Arrays.asList(2,3,1,4,5,6,7,8);
        demoview = new DemoView(this,tree);
        setContentView(demoview);
        context = getApplicationContext();
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        dpHeight = displayMetrics.heightPixels / displayMetrics.density;
        dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        Log.d("TAG","height : "+dpHeight+"width : "+dpWidth);
    }

    private class DemoView extends View {
       List<Integer> treeData;
        Integer height = null;
        public DemoView(Context context , List<Integer> data) {
            super(context);
            this.treeData = data;
            height = height(data.size());
            Log.d("TAG","height is:"+height);
            generateNodeList();
        }

        private void generateNodeList() {
      
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            // custom drawing code here
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.FILL);

            // make the entire canvas white
            paint.setColor(Color.WHITE);
            canvas.drawPaint(paint);

            // draw blue circle with anti aliasing turned off
            paint.setAntiAlias(false);
            paint.setColor(Color.BLUE);
            canvas.drawCircle(20, 20, 15, paint);
        }
    }

    public class Node{
        int x;
        int y;
        int level;
        int value;

        public Node(int x, int y, int level, int value) {
            this.x = x;
            this.y = y;
            this.level = level;
            this.value = value;
        }

        public Node(int value) {
            this.value = value;
        }

        public Node(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getLevel() {
            return level;
        }

        public void setLevel(int level) {
            this.level = level;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }
    public static int height(int num){
        return (int) ((log(num,2) )+ 1) ;
    }
    static int log(int x, int base)
    {
        return (int) (Math.log(x) / Math.log(base));
    }
}
