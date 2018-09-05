package com.alipictures.movie.demo;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.alipictures.movie.demo.state.ExceptionState;
import com.alipictures.movie.demo.state.LoadingState;
import com.alipictures.statemanager.manager.StateEventListener;
import com.alipictures.statemanager.state.CoreState;


public class MainActivity extends StateManagerActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        findViewById(R.id.show_loading).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showState(LoadingState.STATE);
            }
        });

        findViewById(R.id.show_exception).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showState(ExceptionState.STATE);
            }
        });


        findViewById(R.id.statemanager_demo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, StateManagerDemoActivity.class);
                startActivity(intent);

            }
        });

        findViewById(R.id.recyclerview_demo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.statelayout_demo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, StateLayoutActivity.class);
                startActivity(intent);
            }
        });

        findViewById(R.id.customstate_demo).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CustomStateActivity.class);
                startActivity(intent);
            }
        });


        setStateEventListener(new StateEventListener() {
            @Override
            public void onEventListener(String event, View view) {
                if (TextUtils.equals(event, LoadingState.EVENT_CLICK)) {
                    showState(ExceptionState.STATE);
                } else {
                    showState(CoreState.STATE);
                }
            }
        });
    }
}
