package com.alipictures.movie.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.alipictures.movie.demo.state.BizState;
import com.alipictures.movie.demo.state.LoadingState;
import com.alipictures.movie.statemanager.StateLayout;

/**
 * 自定义State及动态注册
 */

public class CustomStateActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customstate);
        final StateLayout stateLayout = (StateLayout) findViewById(R.id.statelayout);
        stateLayout.addState(new BizState());
        Button requestData = (Button) findViewById(R.id.request_data);

        requestData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateLayout.showState(LoadingState.STATE);
                //mock request data
                stateLayout.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        BizState.BizMo bizMo = new BizState.BizMo();
                        bizMo.title = "我是自定义State";
                        bizMo.desc = "动态注册一个State，只有当需要展示State的时候，才会动态创建View";
                        bizMo.content = "自定义State适合多个页面复用共同的逻辑，类似于轻量级的Fragment，尽量只做渲染层面的事";
                        stateLayout.showState(bizMo);
                    }
                }, 3000);

            }
        });

    }



}
