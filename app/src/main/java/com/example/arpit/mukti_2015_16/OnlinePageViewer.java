package com.example.arpit.mukti_2015_16;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class OnlinePageViewer extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public OnlinePageViewer(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Oth tab1 = new Oth();
                return tab1;
            case 1:
                Codecra tab2 = new Codecra();
                return tab2;
            case 2:
                freemex tab3 = new freemex();
                return tab3;
            case 3:
                freepl tab4=new freepl();
                return tab4;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
