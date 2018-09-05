package com.alipictures.statemanager.state;

import android.view.View;

/**
 * 核心UI界面
 */
public class CoreState extends BaseState {

    public static final String STATE = "CoreState";

    private String state = STATE;

    public CoreState(View coreView) {
        stateView = coreView;
    }

    /**
     * 支持创建多个CoreState时，需要指定不同的State，达到分离业务逻辑
     *
     * @param coreView
     * @param state
     */
    public CoreState(View coreView, String state) {
        stateView = coreView;
        this.state = state;
    }


    /**
     * 如果使用这个构造，需要重写{@link BaseState#getLayoutId()}方法
     */
    protected CoreState() { }


    @Override
    protected int getLayoutId() {

        try {
            throw new IllegalStateException(this + "没有返回布局文件Id");
        } catch (IllegalStateException e) {
            e.printStackTrace();
            return -1;
        }

    }

    @Override
    protected void onViewCreated(View stateView) {

    }


    @Override
    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
