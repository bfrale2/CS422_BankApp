package edu.uic.group19.a422ndbank;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link TwoFactorFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link TwoFactorFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TwoFactorFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private EditText fieldSecurityCode;
    private Button btnSubmit;


    //
    public TwoFactorFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment TwoFactorFragment.
     */
    public static TwoFactorFragment newInstance() {
        TwoFactorFragment fragment = new TwoFactorFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_two_factor, container, false);

        fieldSecurityCode = rootView.findViewById(R.id.edit_securityCode);
        fieldSecurityCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}

            @Override
            public void afterTextChanged(Editable s) {
                mListener.onTwoFactorChanged(fieldSecurityCode.getText().toString());
            }
        });

        btnSubmit = rootView.findViewById(R.id.btn_enterCode);
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onTwoFactorSubmit(fieldSecurityCode.getText().toString());
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
        void onTwoFactorChanged(String code);
        void onTwoFactorSubmit(String code);
    }


    //
    public void enableSubmit(boolean enabled) {
        btnSubmit.setEnabled(true);
    }
}
