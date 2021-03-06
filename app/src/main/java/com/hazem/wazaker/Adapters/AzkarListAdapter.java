package com.hazem.wazaker.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import com.hazem.wazaker.Activites.AzkarListActivity;
import com.hazem.wazaker.Models.AzkarModel;
import com.hazem.wazaker.listeners.ItemListner;
import com.hazem.wazkar.R;

import java.util.List;

public class AzkarListAdapter extends RecyclerView.Adapter<AzkarListAdapter.ViewHolder> {



    private ItemListner listner;
    private final List<AzkarModel> azkar_modelList;


    public AzkarListAdapter(List<AzkarModel> items, AzkarListActivity azkarListActivity) {
        this.azkar_modelList = items;
    }




    public void setListner(ItemListner listner) {
        this.listner = listner;
    }

    @Override
    public AzkarListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View v = layoutInflater.inflate(R.layout.simple_cell, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder,  int position) {

        AzkarModel azkarModel = azkar_modelList.get(position);
        holder.title.setText(azkarModel.getName());
       
    }

    @Override
    public int getItemCount() {
        return azkar_modelList.size();
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;

        public ViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
            itemView.setOnClickListener((e) -> {
                listner.onItemCLicked(getAdapterPosition());
            });
        }
    }

}

