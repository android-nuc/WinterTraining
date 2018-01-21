package io.innofang.wintertraining.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import io.innofang.wintertraining.R;
import io.innofang.wintertraining.adapter.ViewPagerAdapter;
import io.innofang.wintertraining.fragment.TestFourFragment;
import io.innofang.wintertraining.fragment.TestOneFragment;
import io.innofang.wintertraining.fragment.TestThreeFragment;
import io.innofang.wintertraining.fragment.TestTwoFragment;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        mViewPager = findViewById(R.id.view_pager);
        mTabLayout = findViewById(R.id.tab_layout);

        String[] titles = {"Test One", "Test Two", "Test Three", "Test Four"};
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), titles);

        adapter.addFragment(TestOneFragment.newInstance());
        adapter.addFragment(TestTwoFragment.newInstance());
        adapter.addFragment(TestThreeFragment.newInstance());
        adapter.addFragment(TestFourFragment.newInstance());

        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setCurrentItem(0);

    }
}
