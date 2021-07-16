package com.alipictures.movie.demo;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alipictures.statemanager.loader.StateRepository;
import com.alipictures.statemanager.manager.StateChanger;
import com.alipictures.statemanager.manager.StateEventListener;
import com.alipictures.statemanager.manager.StateManager;
import com.alipictures.statemanager.state.CoreState;
import com.alipictures.statemanager.state.StateProperty;


public abstract class StateManagerFragment extends Fragment implements StateChanger {

    private StateManager stateManager;

    protected View layoutView;

    public abstract int getLayoutId();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        stateManager = StateManager.newInstance(getActivity(), new StateRepository(getActivity()));

    }

    /**
     * 这个方法不允许重写，如果有初始化工作，可以在{@link StateManagerFragment#initViewContent(View, Bundle)}方法中实现
     */
    @Override
    public final View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        layoutView = stateManager.setContentView(getLayoutId());
        initViewContent(stateManager.getStateView(CoreState.STATE), savedInstanceState);
        return layoutView;
    }

    /**
     * 初始化界面
     *
     * @param layoutView
     * @param savedInstanceState
     */
    public abstract void initViewContent(View layoutView, Bundle savedInstanceState);


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
    public void onDestroyView() {
        super.onDestroyView();
        stateManager.onDestoryView();
    }
}
