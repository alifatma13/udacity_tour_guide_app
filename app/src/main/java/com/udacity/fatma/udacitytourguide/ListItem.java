package com.udacity.fatma.udacitytourguide;


/**
 * Created by fali10 on 5/6/2018.
 */

public class ListItem {


    /**
     * Name of the places to visit or events to attend
     */
    private String mPlaceName;
    /**
     * Location of the places to visit or events to attend
     */
    private String mPlaceLocation;
    /**
     * Description of the places to visit or events to attend
     */
    private String mPlaceDescription;

    /**
     * Image resource ID for the word
     */
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    /**
     * Constant value that represents no image was provided for this word
     */
    private static final int NO_IMAGE_PROVIDED = -1;

    private int mAudioResourceId;

    /**
     * Create a new ListItem object.
     *
     * @param placeName        is the name of Places in Bengaluru that people can visit
     * @param placeLocation    is the name of the area where this place is located
     * @param placeDescription is Description about the place mentioned
     * @param imageResourceId  is the raw audio file ID for the audio associated with the item
     */

    public ListItem(String placeName, String placeDescription, String placeLocation, int imageResourceId) {
        mPlaceName = placeName;
        mPlaceLocation = placeLocation;
        mPlaceDescription = placeDescription;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the Place Name
     */
    public String getPlaceName() {
        return mPlaceName;
    }

    /**
     * Get the Place's Location
     */

    public String getPlaceLocation() {
        return mPlaceLocation;
    }

    /**
     * Get Place's Description
     */

    public String getPlaceDescription() {
        return mPlaceDescription;
    }

    /**
     * Return the image resource ID of the
     * list Iem.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Returns whether or not there is an image for this listItem.
     */
    public boolean hasImage() {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    @Override
    public String toString() {
        return "Word{" +
                "mPlaceName='" + mPlaceName + '\'' +
                ", mPlaceDescription='" + mPlaceLocation + '\'' +
                ", mPlaceLocation='" + mPlaceDescription + '\'' +
                ", mImageResourceId=" + mImageResourceId +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }

}
