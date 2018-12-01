package com.tapperware.monumenkita;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void start(View view) {
        this.view = view;
        Intent pindah = new Intent(MainActivity.this, RecycleActivity.class);
        startActivity(pindah);
    }
}
