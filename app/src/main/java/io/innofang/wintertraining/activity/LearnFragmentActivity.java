package io.innofang.wintertraining.activity;

import android.support.v4.app.Fragment;

import io.innofang.wintertraining.R;
import io.innofang.wintertraining.activity.base.FragmentContainerActivity;
import io.innofang.wintertraining.fragment.TestOneFragment;

public class LearnFragmentActivity extends FragmentContainerActivity {

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_learn_fragment;
    }

    @Override
    protected int getFragmentContainerId() {
        return R.id.fragment_container;
    }

    @Override
    protected Fragment createFragment() {
        return TestOneFragment.newInstance();
    }

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_learn_fragment);
//
//        getSupportFragmentManager().beginTransaction()
//                .add(R.id.fragment_container, new TestOneFragment())
//                .commit();
//    }
}
