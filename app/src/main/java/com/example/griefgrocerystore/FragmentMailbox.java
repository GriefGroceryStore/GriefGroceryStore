package com.example.griefgrocerystore;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class FragmentMailbox extends Fragment {
    public FragmentMailbox() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mailbox, container, false);
        Log.i("FragmentMailbox", "Success Create");
        return view;
    }
}