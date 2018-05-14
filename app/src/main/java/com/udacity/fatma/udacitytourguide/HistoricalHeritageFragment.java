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
 * {@link HistoricalHeritageFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HistoricalHeritageFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoricalHeritageFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    public HistoricalHeritageFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoricalHeritageFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoricalHeritageFragment newInstance(String param1, String param2) {
        HistoricalHeritageFragment fragment = new HistoricalHeritageFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
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
        listItems.add(new ListItem(getResources().getString(R.string.heritage_name_1),
                getResources().getString(R.string.heritage_description_1),
                getResources().getString(R.string.heritage_location_1), R.drawable.vidhan_soudh));
        listItems.add(new ListItem(getResources().getString(R.string.heritage_name_2),
                getResources().getString(R.string.heritage_description_2),
                getResources().getString(R.string.heritage_location_2), R.drawable.bangalore_palace));
        listItems.add(new ListItem(getResources().getString(R.string.heritage_name_3),
                getResources().getString(R.string.heritage_description_3),
                getResources().getString(R.string.heritage_location_3), R.drawable.tipu_palace));
        listItems.add(new ListItem(getResources().getString(R.string.heritage_name_4),
                getResources().getString(R.string.heritage_description_4),
                getResources().getString(R.string.heritage_location_4), R.drawable.central_library));
        listItems.add(new ListItem(getResources().getString(R.string.heritage_name_5),
                getResources().getString(R.string.heritage_description_5),
                getResources().getString(R.string.heritage_location_5), R.drawable.attara_kacheri));
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

    // TODO: Rename method, update argument and hook method into UI event
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
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
