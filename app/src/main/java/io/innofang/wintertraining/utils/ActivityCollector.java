package io.innofang.wintertraining.utils;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: Inno Fang
 * Time: 2018/1/20 16:40
 * Description:
 */


public class ActivityCollector {

    private static List<Activity> mActivities = new ArrayList<>();

    public static void add(Activity activity) {
        mActivities.add(activity);
    }

    public static void remove(Activity activity) {
        mActivities.remove(activity);
    }

    public static void finishAll() {
        for (Activity activity : mActivities) {
            activity.finish();
        }
    }

}
