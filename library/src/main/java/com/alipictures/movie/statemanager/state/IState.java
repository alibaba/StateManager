package com.alipictures.movie.statemanager.state;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.alipictures.movie.statemanager.manager.StateEventListener;

/**
 * State生命周期管理
 */
public interface IState<T extends StateProperty> {

    public static final String EMPTY = "empty_state";
    public static final String EXCEPTION = "exception_state";
    public static final String LAODING = "loading_state";
    public static final String NETERROR = "net_error_state";

    public static final String ERROR = "error_state";
    /**
     * StateView创建后，可以做一些操作
     */
    void onStateCreate(Context context, ViewGroup parent);


    /**
     * StateView显示后，可以做一些操作
     */
    void onStateResume();

    /**
     * StateView隐藏后，可以做一些操作
     */
    void onStatePause();


    /**
     * 获取当前状态
     *
     * @return
     */
    String getState();

    /**
     * 设置当前状态下的一些按钮操作回调
     *
     * @param listener
     */
    void setStateEventListener(StateEventListener listener);


    /**
     * 获取状态机的View
     *
     * @return
     */
    View getView();


    /**
     * 定制View里面控件的内容
     */
    void setViewProperty(T stateProperty);
}
