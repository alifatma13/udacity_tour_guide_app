package com.udacity.fatma.udacitytourguide;


/**
 * {@link Word} represents a vocabulary word that the user wants to learn.
 * It contains a default translation, a Kannada translation, and an image for that word.
 */
public class Word {

    /**
     * Default translation for the word
     */
    private String mDefaultTranslation;

    /**
     * Kannada translation for the word
     */
    private String mKannadaTranslation;


    private int mAudioResourceId;

    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param kannadaTranslation is the word in the Kannada language
     * @param audioResourceId    is the raw audio file ID for the audio associated with the item
     */
    public Word(String defaultTranslation, String kannadaTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mKannadaTranslation = kannadaTranslation;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Kannada translation of the word.
     */
    public String getKannadaTranslation() {
        return mKannadaTranslation;
    }

    /**
     * Return the audio resource ID of the word.
     */
    public int getAudioResourceId() {
        return mAudioResourceId;
    }


    @Override
    public String toString() {
        return "Word{" +
                "mDefaultTranslation='" + mDefaultTranslation + '\'' +
                ", mKannadaTranslation='" + mKannadaTranslation + '\'' +
                ", mAudioResourceId=" + mAudioResourceId +
                '}';
    }

}