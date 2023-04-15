package com.example.psasic;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.psasic.databinding.ActivityFriendsBinding;
import com.example.psasic.databinding.FragmentBottomMapBinding;

public class BottomMapFragment extends Fragment {
    FragmentBottomMapBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_bottom_map, container, false);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = FragmentBottomMapBinding.inflate(getLayoutInflater());

        binding.messengerButton.setOnClickListener(v -> changeActivity("messenger"));
        binding.friendsButton.setOnClickListener(v -> changeActivity("friends"));
    }

    private void changeActivity(String activityName) {
        Intent intent = null;
        if (activityName.equals("messenger")) {
            intent =  new Intent(getContext(), MessengerActivity.class);
        } else if (activityName.equals("friends")) {
            intent =  new Intent(getContext(), FriendsActivity.class);
        }

        if (intent!=null) {
            startActivity(intent);
        }
    }
}