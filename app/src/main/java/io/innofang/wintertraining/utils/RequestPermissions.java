package io.innofang.wintertraining.utils;

import android.app.Activity;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Inno Fang
 * Time: 2018/1/20 22:27
 * Description:
 */


public class RequestPermissions {

    private static final int PERMISSION_REQUEST_CODE = 1 << 5;

    private static OnRequestPermissionsListener sListener;

    public static void requestPermissions(Activity activity, String[] permissions,
                                          OnRequestPermissionsListener listener) {
        sListener = listener;


        List<String> permissionList = new ArrayList<>();
        for (String permission : permissions) {
            if (ContextCompat.checkSelfPermission(activity, permission)
                    != PackageManager.PERMISSION_GRANTED) {
                permissionList.add(permission);
            }
        }

        if (!permissionList.isEmpty()) {
            ActivityCompat.requestPermissions(activity,
                    permissionList.toArray(new String[permissionList.size()]),
                    PERMISSION_REQUEST_CODE);
        } else {
            listener.onGranted();
        }
    }

    public static void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0) {
                List<String> deniedPermissions = new ArrayList<>();
                for (int i = 0; i < grantResults.length; i++) {
                    if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                        deniedPermissions.add(permissions[i]);
                    }
                }
                if (deniedPermissions.isEmpty()) {
                    sListener.onGranted();
                } else {
                    sListener.onDenied(deniedPermissions);
                }
            }

        }
    }

    public interface OnRequestPermissionsListener {
        /* 权限已授权 */
        void onGranted();

        /* 权限被拒绝 */
        void onDenied(List<String> deniedPermission);
    }

}
