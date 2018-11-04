package com.example.griefgrocerystore;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentFirstPage extends Fragment {
    public FragmentFirstPage() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_page, container, false);
        Log.i("FragmentFirstPage", "Success Create");
        return view;
    }
}
