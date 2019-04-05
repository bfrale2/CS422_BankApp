package edu.uic.group19.a422ndbank.MainApp.AccountCreation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import edu.uic.group19.a422ndbank.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SecurityTutorialFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SecurityTutorialFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SecurityTutorialFragment extends Fragment {

    private OnFragmentInteractionListener mListener;

    private int pageStringIds[] = {R.string.security_content_1, R.string.security_content_2, R.string.security_content_3, R.string.security_content_4};
    private int currentPage;

    TextView textPageCounter;
    TextView textContent;

    Button btnPrevious;
    Button btnNext;
    Button btnSkip;


    //
    public SecurityTutorialFragment() {
        // Required empty public constructor
    }


    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SecurityTutorialFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SecurityTutorialFragment newInstance() {
        SecurityTutorialFragment fragment = new SecurityTutorialFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_security_tutorial, container, false);
        btnPrevious = rootView.findViewById(R.id.btn_previous);
        btnNext = rootView.findViewById(R.id.btn_next);
        btnSkip = rootView.findViewById(R.id.btn_skipTutorial);
        textPageCounter = rootView.findViewById(R.id.text_pageCounter);
        textContent = rootView.findViewById(R.id.text_securityTutorialContent);

        setContentPage(0);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentPage(currentPage + 1);
            }
        });

        btnPrevious.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentPage(currentPage - 1);
            }
        });

        btnSkip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onTutorialEnded();
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
        void onTutorialEnded();
    }


    //
    private void setContentPage(int page) {
        if(page == 0) {
            btnPrevious.setEnabled(false);
        }else if(page < pageStringIds.length) {
            btnPrevious.setEnabled(true);
        }
        if(page >= 0 && page < pageStringIds.length) {
            currentPage = page;
            textContent.setText(pageStringIds[currentPage]);
            textPageCounter.setText(String.format("(%d/%d)", page + 1, pageStringIds.length));
        }
        if(page == pageStringIds.length) {
            mListener.onTutorialEnded();
        }
    }
}
