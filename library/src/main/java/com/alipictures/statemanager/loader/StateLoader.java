package com.alipictures.statemanager.loader;

import android.view.View;

import com.alipictures.statemanager.state.IState;

/**
 * 状态加载器，加载各种状态
 */
public interface StateLoader {


    /**
     * 注册一个状态器，如果有重复的状态改变器，则不添加
     *
     * @param changger
     */
    boolean addState(IState changger);

    /**
     * 如果对应的状态加载器
     *
     * @param state 状态
     */
    boolean removeState(String state);


    View getStateView(String state);
}
