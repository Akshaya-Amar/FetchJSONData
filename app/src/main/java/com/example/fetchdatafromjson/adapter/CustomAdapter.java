package com.example.fetchdatafromjson.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fetchdatafromjson.databinding.ListItemsBinding;
import com.example.fetchdatafromjson.model.ImageModel;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private final Context context;
    private final List<ImageModel> listItems;

    public CustomAdapter(Context context, List<ImageModel> listItems) {
        this.context = context;
        this.listItems = listItems;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ListItemsBinding binding = ListItemsBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageModel image = listItems.get(position);
        Glide.with(context).load(image.getThumbnailUrl()).into(holder.binding.imageView);
        holder.binding.imageId.setText(String.valueOf(image.getId()));
        holder.binding.imageTitle.setText(image.getTitle());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private final ListItemsBinding binding;

        public ViewHolder(@NonNull ListItemsBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
