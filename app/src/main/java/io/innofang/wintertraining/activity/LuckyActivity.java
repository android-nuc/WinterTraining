package io.innofang.wintertraining.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.Random;

import io.innofang.wintertraining.R;

public class LuckyActivity extends AppCompatActivity {
    private static final String EXTRA_LUCKY = "lucky";
    private TextView luckNumberTextView;

    public static Intent newIntent(Context context, int lucky) {
        Intent intent = new Intent(context, LuckyActivity.class);
        intent.putExtra(EXTRA_LUCKY, lucky);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lucky);

        luckNumberTextView = findViewById(R.id.luck_number_text_view);

        int base = getIntent().getIntExtra(EXTRA_LUCKY, 0);

        Random random = new Random();
        int lucky = base + random.nextInt(101);
        luckNumberTextView.setText(lucky + "");

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("lucky", luckNumberTextView.getText().toString());
        setResult(Activity.RESULT_OK, intent);
        super.onBackPressed();
    }
}
