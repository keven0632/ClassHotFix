package com.keven.hotfixarr;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        int checkCallPhonePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        if (checkCallPhonePermission != PackageManager.PERMISSION_GRANTED) {

        } else {
            //上面已经写好的拨号方法
            loadDex();
        }
    }

    private void loadDex() {
        FixDexUtils.loadFixedDex(this, Environment.getExternalStorageDirectory());
    }
}
