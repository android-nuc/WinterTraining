package io.innofang.wintertraining.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import io.innofang.wintertraining.R;
import io.innofang.wintertraining.adapter.RecyclerAdapter;
import io.innofang.wintertraining.bean.User;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;

    private List<User> mUsers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);

        mRecyclerView = findViewById(R.id.recycler_view);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        Random random = new Random();
        for (int i = 1; i <= 100; i++) {
            mUsers.add(new User("username" + i, random.nextInt(50)));
        }

        RecyclerAdapter adapter = new RecyclerAdapter(mUsers);

        adapter.setOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(User user) {
                Toast.makeText(RecyclerViewActivity.this, user.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        mRecyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_recycler_view, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.vertical:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
                break;
            case R.id.horizontal:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
                break;
            case R.id.two_columns:
                mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
