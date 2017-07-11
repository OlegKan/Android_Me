package com.example.android.android_me.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.android.android_me.R;
import com.example.android.android_me.data.AndroidImageAssets;

import java.util.List;

public class MasterListFragment extends Fragment {

    public static MasterListFragment newInstance() {
        return new MasterListFragment();
    }

    public MasterListFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_master_list, container, false);

        GridView gridView = (GridView) rootView.findViewById(R.id.gridView);

        gridView.setNumColumns(3);

        List<Integer> imageIds = AndroidImageAssets.getAll();
        MasterListAdapter adapter = new MasterListAdapter(getContext(), imageIds);
        gridView.setAdapter(adapter);

        return rootView;
    }
}
