package com.gioppl.powergrid

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by GIOPPL on 2017/7/24.
 */
class MyAPP : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this);
    }
}