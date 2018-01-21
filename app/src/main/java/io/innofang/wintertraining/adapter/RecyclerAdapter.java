package io.innofang.wintertraining.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.innofang.wintertraining.R;
import io.innofang.wintertraining.bean.User;

/**
 * Author: Inno Fang
 * Time: 2018/1/21 13:56
 * Description:
 */


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private List<User> mUsers;

    public RecyclerAdapter(List<User> users) {
        mUsers = users;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, null, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        holder.bindHolder(mUsers.get(position));
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView usernameTextView;
        private TextView ageTextView;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            usernameTextView = itemView.findViewById(R.id.username_text_view);
            ageTextView = itemView.findViewById(R.id.age_text_view);
        }

        public void bindHolder(final User user) {
            usernameTextView.setText(user.getUsername());
            ageTextView.setText(user.getAge() + "");
            if (mOnItemClickListener != null) {
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mOnItemClickListener.onClick(user);
                    }
                });
            }
        }
    }


    public OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        mOnItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener {
        public void onClick(User user);
    }
}
