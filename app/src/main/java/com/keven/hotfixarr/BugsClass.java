package com.keven.hotfixarr;

import android.content.Context;
import android.widget.Toast;

public class BugsClass {
    public static void getBug(Context context) {
        Toast.makeText(context, "这是个 bug", Toast.LENGTH_SHORT).show();
//        Toast.makeText(context, "恭喜已经修复 bug", Toast.LENGTH_SHORT).show();
    }
}
