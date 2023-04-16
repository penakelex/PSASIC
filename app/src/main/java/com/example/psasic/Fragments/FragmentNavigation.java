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

import com.example.psasic.Activities.ChatsActivity;
import com.example.psasic.Activities.FriendsActivity;
import com.example.psasic.Activities.MapActivity;
import com.example.psasic.R;
import com.example.psasic.databinding.FragmentNavigationBinding;

public class FragmentNavigation extends Fragment {

    private FragmentNavigationBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = FragmentNavigationBinding.inflate(inflater, container, false);
        //binding = FragmentNavigationBinding.inflate(getLayoutInflater());
        binding.chatButton.setOnClickListener(v -> changeActivity(1));
        binding.friendsButton.setOnClickListener(v -> changeActivity(2));
        binding.mapButton.setOnClickListener(v -> changeActivity(3));
        return binding.getRoot();
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void changeActivity(int activity) {
        switch (activity) {
            case 1:
                startActivity(new Intent(getActivity(), ChatsActivity.class));
                break;
            case 2:
                startActivity(new Intent(getActivity(), FriendsActivity.class));
                break;
            case 3:
                startActivity(new Intent(getActivity(), MapActivity.class));
                break;
        }
    }
}