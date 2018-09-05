package com.alipictures.movie.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.alipictures.movie.demo.state.LoadingState;
import com.alipictures.statemanager.StateLayout;
import com.alipictures.statemanager.state.CoreState;

public class RecyclerViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview_demo);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new Adapter());

    }


    public class Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            RecyclerView.ViewHolder viewHolder = null;
            if (viewType == 0) {
                viewHolder = new DefaultViewHolder(
                    LayoutInflater.from(RecyclerViewActivity.this).inflate(R.layout.default_viewholder, parent, false));
            } else {
                viewHolder = new StateManagerViewHolder(
                    LayoutInflater.from(RecyclerViewActivity.this).inflate(R.layout.statemanager_viewholder, parent, false));
            }

            return viewHolder;
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            if (holder instanceof DefaultViewHolder) {
                ((DefaultViewHolder) holder).textView.setText("这是第" + (position + 1) + "个Item");
            } else if (holder instanceof StateManagerViewHolder) {
                ((StateManagerViewHolder) holder).stateLayout.showState(LoadingState.STATE);
                ((StateManagerViewHolder) holder).showCoreState();
            }
        }

        @Override
        public int getItemCount() {
            return 20;
        }

        @Override
        public int getItemViewType(int position) {
            return position == 9 ? 1 : 0;
        }

        @Override
        public void onViewDetachedFromWindow(RecyclerView.ViewHolder holder) {
            super.onViewDetachedFromWindow(holder);
            holder.itemView.removeCallbacks(null);
        }
    }


    public class StateManagerViewHolder extends RecyclerView.ViewHolder {
        StateLayout stateLayout;

        public StateManagerViewHolder(View itemView) {
            super(itemView);
            stateLayout = itemView.findViewById(R.id.statelayout);
        }

        public void showCoreState() {
            itemView.postDelayed(new Runnable() {
                @Override
                public void run() {
                    stateLayout.showState(CoreState.STATE);
                }
            }, 3000);
        }
    }


    public class DefaultViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public DefaultViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textview);
        }
    }
}
