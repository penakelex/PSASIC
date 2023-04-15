package com.example.psasic.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.psasic.Activities.FriendsActivity;
import com.example.psasic.Activities.MainActivity;
import com.example.psasic.Activities.MessengerActivity;
import com.example.psasic.R;
import com.example.psasic.databinding.FragmentNavigationBinding;

public class FragmentNavigation extends Fragment {

    private FragmentNavigationBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentNavigationBinding.inflate(inflater, container, false);
        //binding = FragmentNavigationBinding.inflate(getLayoutInflater());
        binding.chatBtn.setOnClickListener(v -> changeActivity(1));
        binding.friendsBtn.setOnClickListener(v -> changeActivity(2));
        binding.mapBtn.setOnClickListener(v -> changeActivity(3));
        return binding.getRoot();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void changeActivity(int activity) {
        switch (activity) {
            case 1:
                startActivity(new Intent(getActivity(), MessengerActivity.class));
                break;
            case 2:
                startActivity(new Intent(getActivity(), FriendsActivity.class));
                break;
            case 3:
                startActivity(new Intent(getActivity(), MainActivity.class));
                break;
        }
    }
}