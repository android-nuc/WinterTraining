package io.innofang.wintertraining.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

import io.innofang.wintertraining.R;

public class LearnForActivity extends AppCompatActivity {

    private static final String TAG = "learn_for_activity";

    private Button testLuckyButton;
    private TextView luckNumberTextView;
    private final int REQUEST_FOR_LUCKY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_for);

        Log.i(TAG, "onCreate: is called");

        testLuckyButton = findViewById(R.id.test_lucky_button);
        luckNumberTextView = findViewById(R.id.luck_number_text_view);

        testLuckyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Random random = new Random();
                int lucky = random.nextInt(101);
                Intent intent = LuckyActivity.newIntent(LearnForActivity.this, lucky);
//                Intent intent = new Intent(LearnForActivity.this, LuckyActivity.class);
//                intent.putExtra("lucky", lucky);
                startActivityForResult(intent, REQUEST_FOR_LUCKY);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart: is called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume: is called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause: is called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop: is called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy: is called");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart: is called");
    }

    private final String EXTRA_SAVE = "save_lucky";

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState: is called");
        String lucky = luckNumberTextView.getText().toString();
        outState.putString(EXTRA_SAVE, lucky);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "onRestoreInstanceState: is called");
        luckNumberTextView.setText(savedInstanceState.getString(EXTRA_SAVE));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != Activity.RESULT_OK)
            return;

        if (requestCode == REQUEST_FOR_LUCKY) {
            String lucky = data.getStringExtra("lucky");
            luckNumberTextView.setText(lucky);
        }
    }
}
