package com.santidev.sliderfragmenttutorial;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.Fragment;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {

    SingleFragmentPageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<androidx.fragment.app.Fragment> fragmentList = new ArrayList<>();
        fragmentList.add(SingleFragment.newInstance("Hola"));
        fragmentList.add(SingleFragment.newInstance("Hace un buen tiempo"));
        fragmentList.add(SingleFragment.newInstance("Q no te veia"));
        fragmentList.add(SingleFragment.newInstance("Adios"));

        adapter = new SingleFragmentPageAdapter(fragmentList, getSupportFragmentManager());
        ViewPager pager = (ViewPager) findViewById(R.id.pager);

        pager.setAdapter(adapter);

    }

    private class SingleFragmentPageAdapter extends FragmentPagerAdapter {

        private List<androidx.fragment.app.Fragment> fragments;

        public SingleFragmentPageAdapter(List<androidx.fragment.app.Fragment> fragments, FragmentManager fragmentManager){
            super(fragmentManager);
            this.fragments = fragments;

        }


        @NonNull
        @Override
        public androidx.fragment.app.Fragment getItem(int position) {
            return this.fragments.get(position);
        }


        @Override
        public int getCount() {
            return this.fragments.size();
        }
    }
}