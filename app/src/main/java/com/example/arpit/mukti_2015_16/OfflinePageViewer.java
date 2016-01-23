package com.example.arpit.mukti_2015_16;

import android.support.v4.app.Fragment;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class OfflinePageViewer extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public OfflinePageViewer(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Connectify tab1 = new Connectify();
                return tab1;
            case 1:
                Incanity tab2 = new Incanity();
                return tab2;
            case 2:
                Lipi tab3 = new Lipi();
                return tab3;
            case 3:
                Bts tab4=new Bts();
                return tab4;
            case 4:
                Fanfoot tab5=new Fanfoot();
                return tab5;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}

