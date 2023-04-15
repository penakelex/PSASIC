package com.example.psasic;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.psasic.databinding.FragmentBottomMapBinding;

public class BottomMapFragment extends Fragment {
    private FragmentBottomMapBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentBottomMapBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = FragmentBottomMapBinding.inflate(getLayoutInflater());
        binding.messengerButton.setOnClickListener(v -> changeActivity(1));
        binding.friendsButton.setOnClickListener(v -> changeActivity(2));
    }
    @Override

    private void changeActivity(int activity) {
        switch (activity) {
            case 1:
                startActivity(new Intent(getActivity(), MessengerActivity.class));
                break;
            case 2:
                startActivity(new Intent(getActivity(), FriendsActivity.class));
                break;
        }
    }
}