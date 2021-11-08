package com.dacasa.nyimbozakristo;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.dacasa.nyimbozakristo.Adapter.NyimboAdapter;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NyimboFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NyimboFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //get the list of songs titles and contents in string array

    String[] titles = {};
    String[] contents = {};



    RecyclerView postListView;
    NyimboAdapter nyimboAdapter;
    EditText searchInput;
    ConstraintLayout rootlayout;


    public NyimboFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NyimboFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NyimboFragment newInstance(String param1, String param2) {
        NyimboFragment fragment = new NyimboFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View fragmentView = inflater.inflate(R.layout.fragment_nyimbo, container, false);

        titles = getActivity().getResources().getStringArray(R.array.songs_title);
        contents = getActivity().getResources().getStringArray(R.array.songs_content);

        postListView = fragmentView.findViewById(R.id.songListView);
        rootlayout = fragmentView.findViewById(R.id.root_layout);
        searchInput = fragmentView.findViewById(R.id.search_input);
        postListView.setLayoutManager(new LinearLayoutManager(getActivity()));
        postListView.setHasFixedSize(true);

        return fragmentView;
    }


    @Override
    public void onStart() {
        super.onStart();


        nyimboAdapter = new NyimboAdapter(getActivity(),titles,contents);
        postListView.setAdapter(nyimboAdapter);

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence , int i, int i1, int i2) {
                nyimboAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }


}