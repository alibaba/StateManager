package com.alipictures.statemanager.loader;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;

import com.alipictures.statemanager.state.IState;

import java.util.HashMap;

/**
 * 状态仓库
 */
public class StateRepository implements StateLoader {

    public static void registerState(String state, Class clazz) {
        stateClazzMap.put(state, clazz);
    }

    public static void unregisterState(String state) {
        stateClazzMap.remove(state);
    }

    /**
     * 用于映射State和具体State对象
     */
    private final HashMap<String, IState> stateMap = new HashMap<>(5);
    private static final HashMap<String, Class> stateClazzMap = new HashMap<>(5);


    protected Context mContext;

    public StateRepository(Context context) {
        mContext = context;
    }

    @Override
    public boolean addState(IState changer) {
        if (changer != null && !TextUtils.isEmpty(changer.getState())) {
            stateMap.put(changer.getState(), changer);
            return true;
        }

        return false;
    }

    @Override
    public boolean removeState(String state) {
        if (!TextUtils.isEmpty(state)) {
            stateMap.remove(state);
            return true;
        }
        return false;
    }


    public IState get(String state) {

        IState istate = stateMap.get(state);
        if (istate != null) {
            return istate;
        }

        Class clazz = stateClazzMap.get(state);
        if (clazz != null) {
            try {
                istate = (IState) clazz.newInstance();
                addState(istate);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return istate;
    }

    @Override
    public View getStateView(String state) {
        IState stateChanger = get(state);
        if (stateChanger != null) {
            return stateChanger.getView();
        }
        return null;
    }


    public HashMap<String, IState> getStateMap() {
        return stateMap;
    }


    public void clear() {
        stateMap.clear();
    }

}
