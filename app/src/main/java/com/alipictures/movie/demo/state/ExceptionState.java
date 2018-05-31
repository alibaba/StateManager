package com.alipictures.movie.demo.state;

import android.view.View;

import com.alipictures.movie.demo.R;
import com.alipictures.movie.statemanager.state.BaseState;

public class ExceptionState extends BaseState {
    public static final String STATE = "ExceptionState";

    @Override
    protected int getLayoutId() {
        return R.layout.exception_state;
    }

    @Override
    protected void onViewCreated(View stateView) {
        stateView.findViewById(R.id.exit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stateEventListener != null) {
                    stateEventListener.onEventListener(STATE, view);
                }
            }
        });
    }

    @Override
    public String getState() {
        return STATE;
    }
}
