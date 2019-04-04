package edu.uic.group19.a422ndbank;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;


public class LoginProgressFragment extends Fragment {

    public static final String STEP_CREDNETIALS = "CREDENTIALS";
    public static final String STEP_TWO_FACTOR = "2FA";

    private ImageView imageLock;
    private CheckBox boxCredentials;
    private CheckBox boxTwoFactor;


    //
    public LoginProgressFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment LoginProgressFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginProgressFragment newInstance() {
        LoginProgressFragment fragment = new LoginProgressFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }


    //
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    //
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_login_progress, container, false);

        imageLock = rootView.findViewById(R.id.image_lock);
        boxCredentials = rootView.findViewById(R.id.checkbox_credentials);
        boxTwoFactor = rootView.findViewById(R.id.checkbox_twoFactor);

        return rootView;
    }


    //
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }


    //
    @Override
    public void onDetach() {
        super.onDetach();
    }


    //
    public void setProgressCheck(String step, boolean checked) {
        if(step.equals(STEP_CREDNETIALS)) {
            boxCredentials.setChecked(checked);
        } else if(step.equals(STEP_TWO_FACTOR)) {
            boxTwoFactor.setChecked(checked);
        }
    }


    //
    public void setLockStatus(boolean locked) {
        if(locked) {
            imageLock.setImageResource(R.drawable.lock_closed);
        } else {
            imageLock.setImageResource((R.drawable.lock_open));
        }
    }
}
