package com.example.begroup_web_0.trabzon.View.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.begroup_web_0.trabzon.Presenter.countryPresenter;
import com.example.begroup_web_0.trabzon.Presenter.searchTourismPlacePresenter;
import com.example.begroup_web_0.trabzon.Presenter.tourismPlacePresenter;
import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.customAdapter.searchAdapter;
import com.example.begroup_web_0.trabzon.customAdapter.searchresultAdapter;
import com.example.begroup_web_0.trabzon.interfacee.MVP;
import com.example.begroup_web_0.trabzon.interfacee.tourismPlaceMvp;
import com.example.begroup_web_0.trabzon.library.library;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class searchResult_frag extends Fragment implements tourismPlaceMvp.interfaces.View {
  RecyclerView searchresultlist;
  RecyclerView.Adapter searchresultAdapter;
  RecyclerView.LayoutManager layoutManager;
    library library;
  View view;
    searchTourismPlacePresenter tourismPlacePresenter;
    ImageView gridView;

    public searchResult_frag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_search_result, container, false);
        searchresultlist=(RecyclerView)view.findViewById(R.id.searchresultlist);
        String filter = getArguments().getString("name");
        String countryId=getArguments().getString("countryId");
        library=new library();
        Toast.makeText(getActivity(), library.getCountryId(getActivity()), Toast.LENGTH_LONG).show();
        tourismPlacePresenter =new searchTourismPlacePresenter(searchResult_frag.this,getActivity(),searchresultlist,R.layout.searchresulltitemright,filter,library.getCategoryId(getActivity()),library.getCountryId(getActivity()));
        tourismPlacePresenter.getData();
        return view;
    }
}
