package com.example.game;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v4.content.ContextCompat;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.ImageView;

import android.widget.TextView;





public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView text;

    private ImageView pic0;

    private ImageView pic1;

    private ImageView pic2;

    int[] imageIds = new int[]{R.drawable.fish, R.drawable.cat,

            R.drawable.cat};



    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        pic0 = (ImageView) findViewById(R.id.pic0);

        pic1 = (ImageView) findViewById(R.id.pic1);

        pic2 = (ImageView) findViewById(R.id.pic2);

        Button butplay = (Button) findViewById(R.id.butplay);

        text = (TextView) findViewById(R.id.text);

        pic0.setOnClickListener(this);

        pic1.setOnClickListener(this);

        pic2.setOnClickListener(this);

        butplay.setOnClickListener(this);

        replay();//开局先将猫顺序打乱

    }



    @Override

    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.pic0:

                //设置已打乱顺序的猫图片

                pic0.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, imageIds[0]));

                pic1.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, imageIds[1]));

                pic2.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, imageIds[2]));

                if (imageIds[0] == R.drawable.fish) {

                    //判断是否猜中吃了鱼的猫

                    text.setText("Congratulations！");

                } else

                    text.setText("Sorry for guessing wrong, would you like to try again？");

                break;



            case R.id.pic1:

                pic0.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, imageIds[0]));

                pic1.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, imageIds[1]));

                pic2.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, imageIds[2]));

                if (imageIds[1] == R.drawable.fish) {

                    text.setText("Congratulations！");

                } else

                    text.setText("Sorry for guessing wrong, would you like to try again？");

                break;



            case R.id.pic2:

                pic0.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, imageIds[0]));

                pic1.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, imageIds[1]));

                pic2.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, imageIds[2]));

                if (imageIds[2] == R.drawable.fish) {

                    text.setText("Congratulations！");

                } else

                    text.setText("Sorry for guessing wrong, would you like to try again？");

                break;



            case R.id.butplay:

                replay();



            default:

                break;

        }

    }



    public void replay() {

        //点击再玩一次，恢复原有标题和猫图片

        text.setText("Guess which cat has eaten the fish？");

        pic0.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.cat));

        pic1.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.cat));

        pic2.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.cat));



        for (int i = 0; i < 3; i++) {

            int temp = imageIds[i];

            int index = (int) (Math.random() * 2);

            imageIds[i] = imageIds[index];

            imageIds[index] = temp;

        }

    }

}

