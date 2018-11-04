package com.example.griefgrocerystore;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private final int PAGER_COUNT = 4;
    private FragmentFirstPage mFragmentFirstPage;
    private FragmentMailbox mFragmentMailbox;
    private FragmentUser mFragmentUser;
    private FragmentWrite mFragmentWrite;

    public MyFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
        mFragmentFirstPage = new FragmentFirstPage();
        mFragmentMailbox = new FragmentMailbox();
        mFragmentUser = new FragmentUser();
        mFragmentWrite = new FragmentWrite();
    }

    @Override
    public int getCount() {
        return PAGER_COUNT;
    }

    @Override
    public Object instantiateItem(ViewGroup vg, int position) {
        return super.instantiateItem(vg, position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        System.out.println("Position Destroy " + position);
        super.destroyItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fg = null;
        switch (position) {
            case MainMenuActivity.PAGE_ONE:
                fg = mFragmentFirstPage;
                break;
            case MainMenuActivity.PAGE_TWO:
                fg = mFragmentMailbox;
                break;
            case MainMenuActivity.PAGE_THREE:
                fg = mFragmentUser;
                break;
            case MainMenuActivity.PAGE_FOUR:
                fg = mFragmentWrite;
                break;
        }
        return fg;
    }
}
