package com.alipictures.movie.demo;

import android.app.Application;

import com.alipictures.movie.statemanager.loader.StateRepository;
import com.alipictures.movie.demo.state.ExceptionState;
import com.alipictures.movie.demo.state.LoadingState;

public class StateManagerApplication extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        StateRepository.registerState(LoadingState.STATE,LoadingState.class);
        StateRepository.registerState(ExceptionState.STATE,ExceptionState.class);

    }
}
