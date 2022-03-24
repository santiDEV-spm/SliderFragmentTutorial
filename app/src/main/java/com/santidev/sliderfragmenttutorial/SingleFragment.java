package com.santidev.sliderfragmenttutorial;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class SingleFragment extends androidx.fragment.app.Fragment {

    public static final String MESSAGE = "santi";

    public static androidx.fragment.app.Fragment newInstance(String message){
        SingleFragment fragment = new SingleFragment();
        Bundle bundle = new Bundle(1);
        bundle.putString(MESSAGE, message);

        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        String message = getArguments().getString(MESSAGE);
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        TextView textView = (TextView) view.findViewById(R.id.fragment_textview);
        textView.setText(message);
        //Podemos anadir mas objetos visuales al fragmento

        return view;
    }
}
