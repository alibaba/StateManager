package com.alipictures.movie.demo.state;

import android.view.View;
import android.widget.TextView;

import com.alipictures.movie.demo.R;
import com.alipictures.movie.statemanager.state.BaseState;
import com.alipictures.movie.statemanager.state.StateProperty;

public class BizState extends BaseState<BizState.BizMo> {
    public final static String BIZ_STATE = "BizState";

    private TextView title;
    private TextView desc;
    private TextView content;

    @Override
    protected int getLayoutId() {
        return R.layout.biz_state;
    }

    @Override
    protected void onViewCreated(View stateView) {
        title = stateView.findViewById(R.id.title);
        desc = stateView.findViewById(R.id.desc);
        content = stateView.findViewById(R.id.content);
    }

    @Override
    public void setViewProperty(BizMo bizMo) {
        super.setViewProperty(bizMo);

        title.setText(bizMo.title);

        desc.setText(bizMo.desc);

        content.setText(bizMo.content);
    }

    @Override
    public String getState() {
        return BIZ_STATE;
    }



    public static class BizMo implements StateProperty {
        public String title;
        public String desc;
        public String content;

        @Override
        public String getState() {
            return BizState.BIZ_STATE;
        }
    }

}