package com.alipictures.statemanager.manager;


import android.view.View;
import android.view.ViewGroup;

/**
 * 视图状态管理
 */
public interface StateViewManager {

    /**
     * 获取状态管理根布局
     * @return  状态管理根布局
     */
    ViewGroup getOverallView();


    /**
     * 设置核心布局
     *
     * @param resId  核心布局ID
     * @return 核心布局
     */
    View setContentView(int resId);

    /**
     * 设置核心布局
     *
     * @param view 核心布局View
     * @return 核心布局
     */
    View setContentView(View view);


    /**
     * 获取核心布局
     * @return 核心布局
     */
    View getContentView();


}
