package com.example.griefgrocerystore;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MenuFragment extends Fragment {
    private String content;

    public MenuFragment() {
        this.content = "test";
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 加载fragment布局文件
        View mView = inflater.inflate(R.layout.frame_layout_content, container, false);
        TextView mTextView = mView.findViewById(R.id.frame_layout_test);
        mTextView.setText(content);
        return mView;
    }
}
