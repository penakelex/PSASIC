package com.example.psasic.Fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.psasic.databinding.FragmentMapBinding;

public class MapFragment extends Fragment {

    FragmentMapBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMapBinding.inflate(inflater);
        // Inflate the layout for this fragment
        return binding.getRoot();
    }
}