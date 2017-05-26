package com.curry.note;

import android.app.Application;

import com.curry.note.constant.SharedTag;
import com.curry.note.util.SPUtils;
import com.curry.note.util.Utils;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.rrtoyewx.andskinlibrary.manager.SkinLoader;

import cn.sharesdk.framework.ShareSDK;

/**
 * Created by curry on 2017/5/14.
 */

public class NoteApplication extends Application {

    public SPUtils spUtils;

    private static NoteApplication instance;

    public static NoteApplication getInstance() {
        if (instance == null) {
            synchronized (NoteApplication.class) {
                if (instance == null) {
                    instance = new NoteApplication();
                }
            }
        }
        return instance;
    }

    @Override
    public void onCreate() {

        super.onCreate();
        Fresco.initialize(this);
        // TODO: 5/18/2017  这个工具类要项目依赖
        Utils.init(this);
        spUtils = new SPUtils(SharedTag.SP_USER);
        SkinLoader.getDefault().init(this);
        ShareSDK.initSDK(this);

    }
}
