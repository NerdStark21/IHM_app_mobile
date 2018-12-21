package com.example.aurel.app_project;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class NameListAdapter extends RecyclerView.Adapter<NameViewHolder> {
    List<String> nameList;

    public NameListAdapter(Context context){
        this.nameList = new ArrayList<>();
    }

    @NonNull
    @Override
    public NameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_name, parent, false);
        return new NameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NameViewHolder holder, int i) {
        holder.setContent(nameList.get(i));
    }

    @Override
    public int getItemCount() {
        return nameList.size();
    }

    public void updateList(List<String> nameList){
        this.nameList.clear();
        this.nameList.addAll(nameList);
        notifyDataSetChanged();
    }
}
