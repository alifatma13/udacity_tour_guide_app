package com.udacity.fatma.udacitytourguide;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link RestaurantFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link RestaurantFragment} factory method to
 * create an instance of this fragment.
 */
public class RestaurantFragment extends Fragment {


    private OnFragmentInteractionListener mListener;

    public RestaurantFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.tour_guide_list, container, false);

        // Create a list of words
        final ArrayList<ListItem> listItems = new ArrayList<>();
        listItems.add(new ListItem(getResources().getString(R.string.restaurant_name_1),
                getResources().getString(R.string.restaurant_description_1),
                getResources().getString(R.string.restaurant_location_1), R.drawable.restaurant_1));
        listItems.add(new ListItem(getResources().getString(R.string.restaurant_name_2),
                getResources().getString(R.string.restaurant_description_2),
                getResources().getString(R.string.restaurant_location_2), R.drawable.restaurant_2));
        listItems.add(new ListItem(getResources().getString(R.string.restaurant_name_3),
                getResources().getString(R.string.restaurant_description_3),
                getResources().getString(R.string.restaurant_location_3), R.drawable.restaurant_3));
        listItems.add(new ListItem(getResources().getString(R.string.restaurant_name_4),
                getResources().getString(R.string.restaurant_description_4),
                getResources().getString(R.string.restaurant_location_4), R.drawable.restaurant_4));
        listItems.add(new ListItem(getResources().getString(R.string.restaurant_name_5),
                getResources().getString(R.string.restaurant_description_5),
                getResources().getString(R.string.restaurant_location_5), R.drawable.restaurant_5));
        // Create an {@link ListItemAdapter}, whose data source is a list of {@link List}s. The
        // adapter knows how to create list items for each item in the list.
        ListItemAdapter adapter = new ListItemAdapter(getActivity(), listItems, R.color.icons);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // tour_guide_list.xml layout file.
        ListView listView =  rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ListItemAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link ListItem} in the list.
        listView.setAdapter(adapter);
        return rootView;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }


    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
