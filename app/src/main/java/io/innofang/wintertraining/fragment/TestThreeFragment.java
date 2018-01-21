package io.innofang.wintertraining.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.innofang.wintertraining.R;

public class TestThreeFragment extends Fragment {

    private TextView numberTextView;
    private Button addButton;

    public static TestThreeFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TestThreeFragment fragment = new TestThreeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_test, container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        numberTextView = view.findViewById(R.id.number_text_view);
        addButton = view.findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.valueOf(numberTextView.getText().toString());
                numberTextView.setText(String.valueOf(++number));
            }
        });

        LinearLayout linearLayout = view.findViewById(R.id.linear_layout);
        linearLayout.setBackgroundColor(Color.BLUE);
    }
}
