package io.innofang.wintertraining.activity.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import io.innofang.wintertraining.utils.ActivityCollector;


/**
 * Author: Inno Fang
 * Time: 2018/1/20 16:42
 * Description:
 */


public class BaseActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.add(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.remove(this);
    }
}
