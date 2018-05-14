package com.udacity.fatma.udacitytourguide;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by fali10 on 5/6/2018.
 */

public class ListItemAdapter extends ArrayAdapter<ListItem> {

    /**
     * Resource ID for the background color for this list of words
     */
    private int mColorResourceId;


    /**
     * Create a new {@link ListItemAdapter} object.
     *
     * @param context         is the current context (i.e. Activity) that the adapter is being created in.
     * @param listItem        is the list of {@link ListItem}s to be displayed.
     * @param colorResourceId is the resource ID for the background color for this list of listItems
     */
    public ListItemAdapter(Context context, ArrayList<ListItem> listItem, int colorResourceId) {
        super(context, 0, listItem);
        mColorResourceId = colorResourceId;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link ListItem} object located at this position in the list
        ListItem currentListItem = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name_text_view.
        TextView nameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        // Get the Place's name from the currentListItem object and set this text on
        // the nameTextView.
        nameTextView.setText(currentListItem.getPlaceName());

        // Find the TextView in the list_item.xml layout with the ID description_text_view .
        TextView descriptionTextView = (TextView) listItemView.findViewById(R.id.description_text_view);
        // Get the description of the current place from the currentListItem object and set this text on
        // the description TextView.
        descriptionTextView.setText(currentListItem.getPlaceDescription());

        // Find the TextView in the list_item.xml layout with the ID location_text_view .
        TextView locationTextView = (TextView) listItemView.findViewById(R.id.location_text_view);
        // Get the location of the current place from the currentListItem object and set this text on
        // the location TextView.
        locationTextView.setText(currentListItem.getPlaceLocation());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Check if an image is provided for this word or not
        if (currentListItem.hasImage()) {
            // If an image is available, display the provided image based on the resource ID
            imageView.setImageResource(currentListItem.getImageResourceId());
            // Make sure the view is visible
            imageView.setVisibility(View.VISIBLE);
        } else {
            // Otherwise hide the ImageView (set visibility to GONE)
            imageView.setVisibility(View.GONE);
        }

        // Set the theme color for the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // Find the color that the resource ID maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // Set the background color of the text container View
        textContainer.setBackgroundColor(color);


        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
