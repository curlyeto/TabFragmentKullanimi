package com.example.ertugrul.tabfragmentkullanimi.Adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.ertugrul.tabfragmentkullanimi.Fragment.FragmentAnasayfa;
import com.example.ertugrul.tabfragmentkullanimi.Fragment.FragmentMuzik;
import com.example.ertugrul.tabfragmentkullanimi.Fragment.FragmentOyunlar;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
    private  int tabSayisi=0;

    public void setTabSayisi(int tabSayisi) {
        this.tabSayisi = tabSayisi;
    }

    public SectionsPagerAdapter(FragmentManager fm) {
            super( fm );
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f;
            switch (position) {
                case 0:
                    f = new FragmentAnasayfa();
                    break;
                case 1:
                    f = new FragmentOyunlar();
                    break;
                case 2:
                    f = new FragmentMuzik();
                    break;
                default:
                    f=new FragmentAnasayfa();
                    break;
            }
            return f;
        }
        @Override
        public int getCount() {
            // Show 3 total pages.
            return tabSayisi;
        }
    }