package com.example.psasic;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.psasic.databinding.ItemUserBinding;

import java.util.List;

public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.ViewHolder>{

    private final LayoutInflater inflater;
    private final List<UserItem> users;
    ItemUserBinding binding;

    UsersAdapter(Context context, List<UserItem> users) {
        this.users = users;
        this.inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public UsersAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        binding = ItemUserBinding.inflate(inflater);
        View view = inflater.inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(UsersAdapter.ViewHolder holder, int position) {
        UserItem user = users.get(position);
        holder.avatar.setImageURI(Uri.parse(user.icon));
        holder.name.setText(user.name+" "+user.surname);
        holder.description.setText(user.dateOfBirth);
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView avatar;
        final TextView name, description;
        ViewHolder(View view){
            super(view);
            avatar = view.findViewById(R.id.avatar);
            name = view.findViewById(R.id.name);
            description = view.findViewById(R.id.description);
        }
    }
}
