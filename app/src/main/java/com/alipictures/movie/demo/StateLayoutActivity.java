package com.alipictures.movie.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alipictures.movie.demo.state.ExceptionState;
import com.alipictures.movie.demo.state.LoadingState;
import com.alipictures.statemanager.StateLayout;
import com.alipictures.statemanager.manager.StateEventListener;
import com.alipictures.statemanager.state.CoreState;

/**
 * 使用StateLayout来支持局部支持展示各种状态的能力
 */

public class StateLayoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statelayout_demo);

        final StateLayout stateLayout = (StateLayout) findViewById(R.id.statelayout);

        stateLayout.showState(LoadingState.STATE);

        stateLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                stateLayout.showState(ExceptionState.STATE);
            }
        }, 3000);

        stateLayout.setStateEventListener(new StateEventListener() {
            @Override
            public void onEventListener(String state, View view) {
                stateLayout.showState(CoreState.STATE);
            }
        });

        Button refresh = (Button) findViewById(R.id.refresh);
        refresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateLayout.showState(LoadingState.STATE);
            }
        });
    }
}
