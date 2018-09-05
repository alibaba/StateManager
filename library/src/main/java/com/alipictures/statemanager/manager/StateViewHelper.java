package com.alipictures.statemanager.manager;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import com.alipictures.statemanager.state.IState;

/**
 * StateView控制器，控制StateView显示、隐藏、创建
 */
public class StateViewHelper {

    /**
     * 显示视图
     * 如果stateView为null，则需要创建
     *
     * @return
     */
    public static boolean showStater(Context context, ViewGroup overallView, IState stater) {

        if (stater == null || overallView ==null) {
            return false;
        }
        View staterView = stater.getView();
        if (staterView == null) {
            stater.onStateCreate(context, overallView);
            staterView = stater.getView();
            if (staterView == null) {
                return false;
            }
        }

        ViewGroup.LayoutParams layoutParams = overallView.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        }
        layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
        layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
        if (overallView.indexOfChild(staterView) < 0 && staterView.getParent() == null) {
            overallView.addView(staterView, layoutParams);
        }
        stater.getView().setVisibility(View.VISIBLE);
        stater.onStateResume();
        return true;
    }

    /**
     * 隐藏视图
     * 如果stateView没有创建，则不做处理
     *
     * @return
     */
    public static boolean hideStater(IState stater) {

        if (stater == null || stater.getView() == null) {
            return false;
        }
        stater.getView().setVisibility(View.GONE);
        stater.onStatePause();
        return true;
    }

}
