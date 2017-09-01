package com.gioppl.powergrid;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.gioppl.powergrid.bean.ControlDetailEntity;
import com.gioppl.powergrid.present.ControlDetailPresent;
import com.gioppl.powergrid.view.ControlDetailView;

/**
 * Created by GIOPPL on 2017/8/30.
 */

public class AAAA extends AppCompatActivity implements ControlDetailView {

    private ControlDetailPresent present;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.four);
        present= new ControlDetailPresent(this);
        present.onCreate();
        present.getData(this,"NBJ01");
    }


    @Override
    public void onError(String e) {

        log(e);
    }


    private void log(String text){
        Log.i("##AAAA",text);
    }

    @Override
    public void onSuccess(ControlDetailEntity entity) {
        log(entity.getRESULT().get(0).getNAME());
    }

}
