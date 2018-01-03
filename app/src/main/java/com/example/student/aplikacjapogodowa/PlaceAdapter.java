package com.example.student.aplikacjapogodowa;

/**
 * Created by asiachwal on 02.01.2018.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder> {

    private ArrayList<Place> places = new ArrayList<>();
    public String place;
    private OnItemClick listener;
    PlaceAdapter(ArrayList<Place> places, OnItemClick listener) {
        this.places = places;
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemLayoutView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.place_layout, null);
        return new ViewHolder(itemLayoutView, listener);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.setPlaceName(places.get(position).getPlaceName());
        holder.setPlaceInf(places.get(position).getInformation() + "");

    }

    @Override
    public int getItemCount() {
        return places.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @BindView(R.id.nameTextView)
        TextView placeName;

        @BindView(R.id.infTextView)
        TextView placeInf;
        private OnItemClick listener;
        public ViewHolder(View itemView, OnItemClick listener) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }
        private void setPlaceName(String name) {
            placeName.setText(name);
        }

        private void setPlaceInf(String age) {
            placeInf.setText(age);
        }
        @Override
        public void onClick(View view) {
            listener.onItemClick(view, getAdapterPosition());
        };
    }
}
