package com.alipictures.movie.demo.state;

import android.view.View;

import com.alipictures.movie.demo.R;
import com.alipictures.statemanager.state.BaseState;

public class LoadingState extends BaseState {
    public static final String STATE = "LoadingState";

    public static final String EVENT_CLICK = "LoadingState_CLICK";

    @Override
    protected int getLayoutId() {
        return R.layout.loading_state;
    }

    @Override
    protected void onViewCreated(View stateView) {
        stateView.findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (stateEventListener != null) {
                    stateEventListener.onEventListener(EVENT_CLICK, view);
                }
            }
        });
    }

    @Override
    public String getState() {
        return STATE;
    }
}
