package com.example.griefgrocerystore;

import android.app.FragmentManager; // 主要用于Activity中操作Fragment
import android.app.FragmentTransaction; // Fragment事务处理
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainMenuActivity extends AppCompatActivity {
    private RadioGroup mTabMenuBar;
    private RadioButton mTabMenuFirstPage;

    // Fragment
    private MenuFragment mFragmentFirstPage, mFragmentMailbox, mFragmentUser, mFragmentWrite;
    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        mFragmentManager = getFragmentManager(); // 获取FragmentManager
        // 为RadioGroup注册监听事件
        mTabMenuBar = findViewById(R.id.tab_menu_bar);
        mTabMenuBar.setOnCheckedChangeListener(new TabMenuBarListener());
        // 获取“首页”按钮，并设置为选中状态
        mTabMenuFirstPage = findViewById(R.id.tab_menu_firstpage);
        mTabMenuFirstPage.setChecked(true);
    }

    private class TabMenuBarListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup mGroup, int checkedId) {
            FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction(); // 开启一个事务
            hideAllFragment(mFragmentTransaction);
            switch (checkedId) {
                case R.id.tab_menu_firstpage:
                    if(mFragmentFirstPage == null) {
                        mFragmentFirstPage = new MenuFragment();
                        mFragmentFirstPage.setContent("首页");
                        mFragmentTransaction.add(R.id.frame_layout_content, mFragmentFirstPage); // 向Activity中添加Fragment
                    }
                    else {
                        mFragmentTransaction.show(mFragmentFirstPage); // 显示Fragment
                    }
                    break;
                case R.id.tab_menu_mailbox:
                    if(mFragmentMailbox == null) {
                        mFragmentMailbox = new MenuFragment();
                        mFragmentMailbox.setContent("信箱");
                        mFragmentTransaction.add(R.id.frame_layout_content, mFragmentMailbox);
                    }
                    else {
                        mFragmentTransaction.show(mFragmentMailbox);
                    }
                    break;
                case R.id.tab_menu_user:
                    if(mFragmentUser == null) {
                        mFragmentUser = new MenuFragment();
                        mFragmentUser.setContent("我的");
                        mFragmentTransaction.add(R.id.frame_layout_content, mFragmentUser);
                    }
                    else {
                        mFragmentTransaction.show(mFragmentUser);
                    }
                    break;
                case R.id.tab_menu_write:
                    if(mFragmentWrite == null) {
                        mFragmentWrite = new MenuFragment();
                        mFragmentWrite.setContent("写信");
                        mFragmentTransaction.add(R.id.frame_layout_content, mFragmentWrite);
                    }
                    else {
                        mFragmentTransaction.show(mFragmentWrite);
                    }
                    break;
            }
            mFragmentTransaction.commit(); // 提交事务
        }
    }

    private void hideAllFragment(FragmentTransaction mFragmentTransaction) {
        if(mFragmentFirstPage != null)
            mFragmentTransaction.hide(mFragmentFirstPage); // 隐藏Fragment
        if(mFragmentMailbox != null)
            mFragmentTransaction.hide(mFragmentMailbox);
        if(mFragmentUser != null)
            mFragmentTransaction.hide(mFragmentUser);
        if(mFragmentWrite != null)
            mFragmentTransaction.hide(mFragmentWrite);
    }
}
