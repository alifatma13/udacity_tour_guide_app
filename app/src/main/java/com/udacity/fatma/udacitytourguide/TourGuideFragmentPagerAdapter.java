package com.udacity.fatma.udacitytourguide;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by fali10 on 5/12/2018.
 */

public class TourGuideFragmentPagerAdapter extends FragmentPagerAdapter {

    final private int PAGE_COUNT = 5;
    private String tabTitles[] = new String[]{"Heritage", "Restaurants", "Things To Do ", "Events", "Kannada Phrases"};
    private Context context;

    public TourGuideFragmentPagerAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    //Get the postirion of the tab and assign the fragments accordingly
    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            return new HistoricalHeritageFragment();
        } else if (position == 1) {
            return new RestaurantFragment();
        } else if (position == 2) {
            return new ThingsToDoFragment();
        } else if (position == 3) {
            return new EventsFragment();
        } else
            return new KannadaPhrasesFragment();
    }

    //get the number of tabs
    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        // Generate title based on item position
        return tabTitles[position];
    }
}
