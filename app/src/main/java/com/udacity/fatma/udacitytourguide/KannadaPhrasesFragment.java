package com.udacity.fatma.udacitytourguide;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link KannadaPhrasesFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link KannadaPhrasesFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KannadaPhrasesFragment extends Fragment {


    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private AudioManager.OnAudioFocusChangeListener afChangeListener =
            new AudioManager.OnAudioFocusChangeListener() {
                public void onAudioFocusChange(int focusChange) {
                    if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                        // Permanent loss of audio focus
                        mMediaPlayer.pause();
                        mMediaPlayer.seekTo(0);
                    } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                        // Lower the volume, keep playing
                        mMediaPlayer.start();
                    } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                        // Your app has been granted audio focus again
                        // Raise volume to normal, restart playback if necessary
                        releaseMediaPlayer();
                    }
                }
            };


    private OnFragmentInteractionListener mListener;

    public KannadaPhrasesFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KannadaPhrasesFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KannadaPhrasesFragment newInstance(String param1, String param2) {
        KannadaPhrasesFragment fragment = new KannadaPhrasesFragment();
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
        View rootView = inflater.inflate(R.layout.word_list, container, false);
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word(getResources().getString(R.string.welcome), getResources().getString(R.string.welcome_kannada), R.raw.welcome_kn));
        words.add(new Word(getResources().getString(R.string.hello), getResources().getString(R.string.hello_kannada), R.raw.hello2_kn));
        words.add(new Word(getResources().getString(R.string.how_are_you), getResources().getString(R.string.how_are_you_kannada), R.raw.howareyou1_kn));
        words.add(new Word(getResources().getString(R.string.what_is_your_name), getResources().getString(R.string.what_is_your_name_kannada), R.raw.name1_kn));
        words.add(new Word(getResources().getString(R.string.my_name_is), getResources().getString(R.string.my_name_is_kannada), R.raw.mynameis_kn));
        words.add(new Word(getResources().getString(R.string.good_morning), getResources().getString(R.string.good_morning_kannada), R.raw.goodmorning_kn));
        words.add(new Word(getResources().getString(R.string.good_bye), getResources().getString(R.string.good_bye_kannada), R.raw.goodbye_kn));
        words.add(new Word(getResources().getString(R.string.dont_understand), getResources().getString(R.string.dont_understand_kannada), R.raw.nounderstand1_kn));
        words.add(new Word(getResources().getString(R.string.speak_slowly), getResources().getString(R.string.speak_slowly_kannada), R.raw.slowly1_kn));
        words.add(new Word(getResources().getString(R.string.sorry), getResources().getString(R.string.sorry_kannada), R.raw.excuseme_kn));
        words.add(new Word(getResources().getString(R.string.thankyou), getResources().getString(R.string.thankyou_kannada), R.raw.thanks_kn));
        words.add(new Word(getResources().getString(R.string.please), getResources().getString(R.string.please_kannada), R.raw.please_kn));
        words.add(new Word(getResources().getString(R.string.where_is_washroom), getResources().getString(R.string.where_is_washroom_kannada), R.raw.toilet1_kn));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(getActivity(), words, R.color.icons);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = rootView.findViewById(R.id.word_list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Word word = words.get(position);
                releaseMediaPlayer();
                //AudioManager.OnAudioFocusChangeListener afChangeListener = null;
                // Request audio focus for playback
                int result = mAudioManager.requestAudioFocus(afChangeListener,
                        // Use the music stream.
                        AudioManager.STREAM_MUSIC,
                        // Request permanent focus.
                        AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // Start playback
                    mMediaPlayer = MediaPlayer.create(getActivity(), word.getAudioResourceId());
                    mMediaPlayer.start();
                    mMediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mp) {
                            releaseMediaPlayer();

                        }
                    });
                }
            }
        });

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

    /**
     * Clean up the media player by releasing its resources.
     */
    public void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(afChangeListener);
        }
    }

    @Override
    public void onStop() {
        super.onStop();

        // When the activity is stopped, release the media player resources because we won't
        // be playing any more sounds.
        releaseMediaPlayer();
    }
}
