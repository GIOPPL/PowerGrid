package com.gioppl.powergrid.adapt;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gioppl.powergrid.R;
import com.suke.widget.SwitchButton;

/**
 * Created by GIOPPL on 2017/7/19.
 */

public class SwitchAdapt extends RecyclerView.Adapter {
    private int switch_num=1;
    private Context mContext;

    public SwitchAdapt(Context mContext){
        this.mContext=mContext;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_switch, parent, false);
        return new SwitchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        ((SwitchViewHolder)holder).tv_switch.setText("开关"+switch_num);
        switch_num++;
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class SwitchViewHolder extends RecyclerView.ViewHolder{
        private SwitchButton sBtn;
        private TextView tv_switch;
        public SwitchViewHolder(View itemView) {
            super(itemView);
            sBtn= (SwitchButton) itemView.findViewById(R.id.sBtn_main);
            tv_switch= (TextView) itemView.findViewById(R.id.tv_switch_switch);
        }
    }
}
