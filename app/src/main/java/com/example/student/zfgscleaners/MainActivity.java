package com.example.student.zfgscleaners;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper v_flipper;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.bntjoin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        openLoginActivity();
            }
        });

        button = (Button) findViewById(R.id.btnLogin);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openSignInActivity();
            }
        });


        int images[]={R.drawable.bg1,R.drawable.bg8,R.drawable.bg4};

        v_flipper =findViewById(R.id.v_flipper);

        for(int i=0;i< images.length;i++)
        {

            flipperimages(images[i]);

            /////

            for(int image: images)
            {
                flipperimages(image);
            }
        }
    }

    public void flipperimages(int image)
    {
        ImageView imageView= new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(3000);
        v_flipper.setAutoStart(true);

        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }

    public void openLoginActivity()
    {

        Intent intent= new Intent(this, loginActivity.class);
        startActivity(intent);
    }

    public void openSignInActivity()
    {

        Intent intent= new Intent(this, signIn.class);
        startActivity(intent);
    }


}
