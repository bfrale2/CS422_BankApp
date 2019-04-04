package edu.uic.group19.a422ndbank;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CredentialsFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CredentialsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CredentialsFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private EditText fieldUsername;
    private EditText fieldPassword;


    //
    public CredentialsFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment CredentialsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CredentialsFragment newInstance() {
        CredentialsFragment fragment = new CredentialsFragment();
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
        final View rootView = inflater.inflate(R.layout.fragment_credentials, container, false);

        fieldUsername = rootView.findViewById(R.id.edit_username);
        fieldPassword = rootView.findViewById(R.id.edit_password);

        Button loginButton = rootView.findViewById(R.id.btn_login);
        loginButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = fieldUsername.getText().toString();
                String password = fieldPassword.getText().toString();

                mListener.onCredentialsEntered(username, password);
            }
        });

        return rootView;
    }


    //
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }


    //
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
        void onCredentialsEntered(String username, String password);
    }
}
