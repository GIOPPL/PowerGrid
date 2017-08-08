package com.gioppl.powergrid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

/**
 * Created by GIOPPL on 2017/7/24.
 */

public class Test extends Activity{
    Activity context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Intent(Test.this,MainActivity.class);
    }
}
