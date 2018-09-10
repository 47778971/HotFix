package com.lj.hotfixtest;

import android.app.Application;

import com.lj.hotfix.AndFixManager;

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        AndFixManager.with().initAndFix(this, Integer.toString(CommonUtil.getVersionCode(this)));
    }
}
