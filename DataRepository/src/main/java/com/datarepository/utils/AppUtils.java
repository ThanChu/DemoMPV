package com.datarepository.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by ThangNTX on 12/1/2016.
 */

public final class AppUtils {

    private AppUtils() {
    }

    public static void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }
}
