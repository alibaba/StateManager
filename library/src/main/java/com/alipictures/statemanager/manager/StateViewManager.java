package com.alipictures.statemanager.manager;


import android.view.View;
import android.view.ViewGroup;

/**
 * 视图状态管理
 */
public interface StateViewManager {


    ViewGroup getOverallView();


    /**
     * 设置核心布局
     *
     * @param resId
     * @return
     */
    View setContentView(int resId);

    View setContentView(View view);


    View getContentView();


}
