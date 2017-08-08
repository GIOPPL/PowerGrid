package com.gioppl.powergrid

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View

/**
 * Created by GIOPPL on 2017/7/24.
 */

class Login : Activity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
    }
    fun SignIn(view:View){
        startActivity(Intent(Login@this,MainActivity::class.java))
    }
}
