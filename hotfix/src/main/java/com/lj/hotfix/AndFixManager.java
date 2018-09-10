package com.lj.hotfix;

import android.content.Context;

import com.alipay.euler.andfix.patch.PatchManager;

import java.io.IOException;

public class AndFixManager {

    private static volatile AndFixManager instance;

    private PatchManager patchManager;

    private AndFixManager() {
        if (null != instance) {
            throw new IllegalStateException("Already initialized.");
        }
    }

    public static AndFixManager with() {
        AndFixManager result = instance;
        if (null == result) {
            synchronized (AndFixManager.class) {
                result = instance;
                if (null == result) {
                    instance = result = new AndFixManager();
                }
            }
        }
        return result;
    }

    public void initAndFix(Context context, String appVersion) {
        if (null == patchManager) patchManager = new PatchManager(context);
        patchManager.init(appVersion);
        patchManager.loadPatch();
    }

    public void addPatch(String path) {
        if (null != patchManager) {
            try {
                patchManager.addPatch(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
