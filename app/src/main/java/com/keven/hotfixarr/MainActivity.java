package com.keven.hotfixarr;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_load;
    private TextView tv_besure;
    private View tv_besure2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_load = findViewById(R.id.tv_load);
        tv_besure = findViewById(R.id.tv_besure);
        tv_besure2 = findViewById(R.id.tv_besure2);

        tv_load.setOnClickListener(this);
        tv_besure.setOnClickListener(this);
        tv_besure2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_load://加载 dex 文件
                if (Build.VERSION.SDK_INT >= 23) {
                    int checkCallPhonePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                    if (checkCallPhonePermission != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                    } else {
                        //上面已经写好的拨号方法
                        loadDex();
                    }
                }
                break;
            case R.id.tv_besure:
                BugsClass.getBug(this);
                break;
            case R.id.tv_besure2:
                ClassStudent.getName(this);
                break;
        }

    }

    private void loadDex() {
        FixDexUtils.loadFixedDex(this, Environment.getExternalStorageDirectory());
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        loadDex();
    }
}