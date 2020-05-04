package com.example.p66na.uploader;

import android.content.Context;
import android.os.strictmode.WebViewMethodCalledOnWrongThreadViolation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar, progressBarHorizontal;
    Button start,end,upload;
    int progress=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressBar=findViewById(R.id.progressBar1);
        progressBarHorizontal=findViewById(R.id.progressBar2);
        start=findViewById(R.id.button);
        end=findViewById(R.id.button2);
        upload=findViewById(R.id.button3);

        progressBar.setVisibility(View.GONE);
    }

    public void start(View view){
        progressBar.setVisibility(View.VISIBLE);
    }

    public void end(View view){
        progressBar.setVisibility(View.GONE);
    }

    public void upload(View view){
        fakeProgress(progress);
    }

    public void fakeProgress(final int progress){

        progressBarHorizontal.setProgress(progress);
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                fakeProgress(progress + 10);
            }
        });
        thread.start();
    }
}

