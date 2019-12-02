package com.example.android.fragmentdatasharing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class FragmentTwo extends Fragment {

    private SharedViewModel sharedViewModel;
    private TextView receivedText;
    private Observer<String> nameObserver;

    public FragmentTwo() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);

        nameObserver = new Observer<String>() {
            @Override
            public void onChanged(String name) {
                receivedText.setText(name);
            }
        };

        sharedViewModel.getNameData().observe(this, nameObserver);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_two, container, false);

        receivedText = rootView.findViewById(R.id.text_receiver);

        return rootView;
    }
}
