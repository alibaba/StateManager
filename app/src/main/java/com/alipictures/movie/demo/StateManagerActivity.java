package com.alipictures.movie.demo;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

import com.alipictures.statemanager.loader.StateRepository;
import com.alipictures.statemanager.manager.StateChanger;
import com.alipictures.statemanager.manager.StateEventListener;
import com.alipictures.statemanager.manager.StateManager;
import com.alipictures.statemanager.state.StateProperty;


public abstract class StateManagerActivity extends AppCompatActivity implements StateChanger {

    private StateManager stateManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stateManager = StateManager.newInstance(this, new StateRepository(this));
    }


    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(stateManager.setContentView(layoutResID));
    }

    @Override
    public void setContentView(View view, LayoutParams params) {
        super.setContentView(stateManager.setContentView(view), params);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(stateManager.setContentView(view));
    }

    @Override
    public void setStateEventListener(StateEventListener listener) {
        stateManager.setStateEventListener(listener);
    }


    @Override
    public boolean showState(String state) {
        return stateManager.showState(state);
    }

    @Override
    public boolean showState(StateProperty state) {
        return stateManager.showState(state);
    }

    @Override
    public String getState() {
        return stateManager.getState();
    }

    /**
     * 获取全局View
     */
    public View getOverallView() {
        return stateManager.getOverallView();
    }

    public StateManager getStateManager() {
        return stateManager;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        stateManager.onDestoryView();
    }
}
