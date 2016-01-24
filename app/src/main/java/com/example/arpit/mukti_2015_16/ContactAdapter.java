package com.example.arpit.mukti_2015_16;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class ContactAdapter extends FragmentStatePagerAdapter {
    int mNumOfTabs;

    public ContactAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                Namit tab1 = new Namit();
                return tab1;
            case 1:
                Arijit tab2 = new Arijit();
                return tab2;
            case 2:
                Adarsh tab3 = new Adarsh();
                return tab3;
            case 3:
                Sanky tab4 = new Sanky();
                return tab4;
            case 4:
                Abdur tab5=new Abdur();
                return tab5;
            case 5:
                Arpit tab6=new Arpit();
                return tab6;
            case 6:
                Sammita tab7=new Sammita();
                return tab7;
            case 7:
                Pragya tab8=new Pragya();
                return tab8;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
    }
}
