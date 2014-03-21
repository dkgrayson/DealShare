package com.example.dealshare;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.Menu;

public class MainActivity extends FragmentActivity implements ActionBar.TabListener {
	
	private GoogleMap gm;
	private ViewPager vp;
	private TabsPagerAdapter ma;
	private ActionBar ab;
	//private String[] tabs = { "Map", "Search", "Post" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		try{
			initializeMap();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		
		vp = (ViewPager) findViewById(R.id.pager);
		ab = getActionBar();
		ma = new TabsPagerAdapter(getSupportFragmentManager());
		
		vp.setAdapter(ma);
		ab.setHomeButtonEnabled(false);
		ab.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
		
		/*for (String tab_name : tabs) {
            //ab.addTab(ab.newTab().setText(tab_name)
              //      .setTabListener(this));
			ab.addTab(ab.newTab().setText(tab_name)
                    .setTabListener(this).setIcon(R.drawable.map_icon));
        }*/
		//ab.setIcon(R.drawable.map_icon);
		
		ab.addTab(ab.newTab().setText("   Map")
				.setTabListener(this).setIcon(R.drawable.map_icon2));
		ab.addTab(ab.newTab().setText("   Search")
				.setTabListener(this).setIcon(R.drawable.search_icon2));
		ab.addTab(ab.newTab().setText("   Post")
				.setTabListener(this).setIcon(R.drawable.post_icon2));
		
		//ab.setBackgroundDrawable(new ColorDrawable(Color.DKGRAY));
		//ab.setStackedBackgroundDrawable(new ColorDrawable(getResources().getColor(Color.LTGRAY)));

		
		vp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			 
		    @Override
		    public void onPageSelected(int position) {
		        // on changing the page
		        // make respected tab selected
		        ab.setSelectedNavigationItem(position);
		    }
		 
		    @Override
		    public void onPageScrolled(int arg0, float arg1, int arg2) {
		    }
		 
		    @Override
		    public void onPageScrollStateChanged(int arg0) {
		    }
		});
	}

	private void initializeMap() {
		if(gm == null){
			gm = ((SupportMapFragment)  getSupportFragmentManager().findFragmentById(R.id.map))
		               .getMap();
			gm.setMyLocationEnabled(true);
			gm.getUiSettings().setMyLocationButtonEnabled(true);
		}
		if (gm == null) {
           //error
        }		
	}
	
	/*protected void onResume() {
        super.onResume();
        initializeMap();
    }*/

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTabSelected(Tab arg0, FragmentTransaction arg1) {
		vp.setCurrentItem(arg0.getPosition());
	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
		// TODO Auto-generated method stub
		
	}

}
