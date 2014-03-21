package com.example.dealshare;

import com.example.dealshare.MapFragment;
import com.example.dealshare.SearchFragment;
import com.example.dealshare.PostFragment;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int arg0) {
		switch(arg0){
		case 0:
			return new MapFragment();
		case 1:
			return new SearchFragment();
		case 2:
			return new PostFragment();
		}
		
		return null;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return 3;
	}
	
}
