package com.example.solidcourse.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.solidcourse.R;
import com.example.solidcourse.databinding.FragmentFirstBinding;


public class FirstFragment extends Fragment {
    FragmentFirstBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        return view;
    }
}