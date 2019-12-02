package com.example.android.fragmentdatasharing;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class FragmentOne extends Fragment {

    private SharedViewModel sharedViewModel;
    private TextInputEditText submitText;
    private MaterialButton submitButton;

    public FragmentOne() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedViewModel = ViewModelProviders.of(requireActivity()).get(SharedViewModel.class);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_one, container, false);

        submitButton = rootView.findViewById(R.id.submit_button);
        submitText = rootView.findViewById(R.id.submit_Text_Field);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedViewModel.setNameData(submitText.getText().toString());

                Toast.makeText(requireContext(), "Submitted!", Toast.LENGTH_SHORT).show();

                //You can use either: sharedViewModel.setNameData(submitText.getText().toString()); or
                //sharedViewModel.getNameData().setValue(submitText.getText().toString());
            }
        });

        return rootView;
    }
}
