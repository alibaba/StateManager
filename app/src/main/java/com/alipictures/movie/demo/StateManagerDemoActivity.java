package com.alipictures.movie.demo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import com.alipictures.movie.demo.state.ExceptionState;
import com.alipictures.movie.demo.state.LoadingState;
import com.alipictures.movie.statemanager.manager.StateEventListener;
import com.alipictures.movie.statemanager.state.CoreState;

public class StateManagerDemoActivity extends StateManagerActivity implements StateEventListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statemanager_demo);


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

    @Override
    public void onEventListener(String event, View view) {
        //        if(TextUtils.equals(event,LoadingState.STATE)){
        //           stateLayout.showState(ExceptionState.STATE);
        //        }else {
        showState(CoreState.STATE);
        //        }
    }
}
