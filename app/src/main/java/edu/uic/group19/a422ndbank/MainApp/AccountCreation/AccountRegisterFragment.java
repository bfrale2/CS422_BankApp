package edu.uic.group19.a422ndbank.MainApp.AccountCreation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.ArrayList;

import edu.uic.group19.a422ndbank.API.Database;
import edu.uic.group19.a422ndbank.MainApp.Global;
import edu.uic.group19.a422ndbank.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AccountRegisterFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AccountRegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AccountRegisterFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private EditText registerFirstName;
    private EditText registerLastName;
    private EditText registerEmail;
    private EditText registerPassword1;
    private EditText registerPassword2;


    //
    public AccountRegisterFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment AccountRegisterFragment.
     */
    public static AccountRegisterFragment newInstance() {
        AccountRegisterFragment fragment = new AccountRegisterFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_account_register, container, false);

        registerFirstName = rootView.findViewById(R.id.field_firstName);
        registerLastName = rootView.findViewById(R.id.field_lastName);
        registerEmail = rootView.findViewById(R.id.field_registerUsername);
        registerPassword1 = rootView.findViewById(R.id.field_registerPassword);
        registerPassword2 = rootView.findViewById(R.id.field_registerPasswordRepeat);

        Button registerButton = rootView.findViewById(R.id.btn_registerAccount);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onAccountCreated(registerFirstName.getText().toString(), registerLastName.getText().toString(), registerEmail.getText().toString(), registerPassword1.getText().toString(), registerPassword2.getText().toString());
            }
        });

        return inflater.inflate(R.layout.fragment_account_register, container, false);
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

        void onAccountCreated(String firstName, String lastName, String email, String password1, String password2);
    }
}
