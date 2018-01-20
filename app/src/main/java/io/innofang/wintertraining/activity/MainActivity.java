package io.innofang.wintertraining.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import io.innofang.wintertraining.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.dialog_activity:
                startActivity(new Intent(this, DialogActivity.class));
                break;
            case R.id.activity_learning:
                startActivity(new Intent(this, LearnForActivity.class));
                break;

        }
    }
}
