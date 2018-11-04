package com.example.griefgrocerystore;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainMenuActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener,
        ViewPager.OnPageChangeListener {
    // UI控件
    private RadioGroup mTabMenuBar;
    private RadioButton mTabMenuFirstPage;
    private RadioButton mTabMenuMailbox;
    private RadioButton mTabMenuUser;
    private RadioButton mTabMenuWrite;
    private ViewPager mViewPager;
    // FragmentPagerAdapter
    private MyFragmentPagerAdapter mFragmentPagerAdapter;
    // 页面表示常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        mFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager());
        bindViews();
        // 设置“首页”为初始选中状态
        mTabMenuFirstPage.setChecked(true);
    }

    private void bindViews() {
        // findViewById
        mTabMenuBar = findViewById(R.id.tab_menu_bar);
        mTabMenuFirstPage = findViewById(R.id.tab_menu_firstpage);
        mTabMenuMailbox = findViewById(R.id.tab_menu_mailbox);
        mTabMenuUser = findViewById(R.id.tab_menu_user);
        mTabMenuWrite = findViewById(R.id.tab_menu_write);
        // 为RadioButton注册监听事件
        mTabMenuBar.setOnCheckedChangeListener(this);
        // 设置ViewPager
        mViewPager = findViewById(R.id.viewpager);
        mViewPager.setAdapter(mFragmentPagerAdapter);
        mViewPager.setCurrentItem(0);
        // 为ViewPager设置监听器
        mViewPager.addOnPageChangeListener(this);
    }

    // RadioGroup监听函数重写
    @Override
    public void onCheckedChanged(RadioGroup mGroup, int checkedId) {
        switch (checkedId) {
            case R.id.tab_menu_firstpage:
                mViewPager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.tab_menu_mailbox:
                mViewPager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.tab_menu_user:
                mViewPager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.tab_menu_write:
                mViewPager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }

    // 重写ViewPager页面切换处理方法
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) { }

    @Override
    public void onPageSelected(int position) { }

    @Override
    public void onPageScrollStateChanged(int state) {
        //状态：0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (mViewPager.getCurrentItem()) {
                case PAGE_ONE:
                    mTabMenuFirstPage.setChecked(true);
                    break;
                case PAGE_TWO:
                    mTabMenuMailbox.setChecked(true);
                    break;
                case PAGE_THREE:
                    mTabMenuUser.setChecked(true);
                    break;
                case PAGE_FOUR:
                    mTabMenuWrite.setChecked(true);
                    break;
            }
        }
    }
}
