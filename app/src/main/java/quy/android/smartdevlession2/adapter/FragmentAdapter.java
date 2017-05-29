package quy.android.smartdevlession2.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import quy.android.smartdevlession2.fragment.FragmentFour;
import quy.android.smartdevlession2.fragment.FragmentOne;
import quy.android.smartdevlession2.fragment.FragmentThree;
import quy.android.smartdevlession2.fragment.FragmentTwo;

/**
 * Created by iamme on 17/05/26.
 */

public class FragmentAdapter extends FragmentStatePagerAdapter {
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment frag=null;
        switch (position){
            case 0:
                frag = new FragmentOne();
                break;
            case 1:
                frag = new FragmentTwo();
                break;
            case 2:
                frag = new FragmentThree();
                break;
            case 3:
                frag = new FragmentFour();
                break;
        }
        return frag;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = "";
        switch (position){
            case 0:
                title = "One";
                break;
            case 1:
                title = "Two";
                break;
            case 2:
                title = "Three";
                break;
            case 3:
                title = "Four";
                break;
        }
        return title;
    }
}
