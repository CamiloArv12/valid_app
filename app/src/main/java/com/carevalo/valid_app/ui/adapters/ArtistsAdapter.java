package com.carevalo.valid_app.ui.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.carevalo.valid_app.R;
import com.carevalo.valid_app.network.response.Artist;
import com.carevalo.valid_app.network.response.LastFmImage;
import com.carevalo.valid_app.utils.AnnotationPicSize;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ArtistsAdapter extends RecyclerView.Adapter<ArtistsAdapter.ArtistsViewHolder>  {

    ArrayList<Artist> artists;

    public ArtistsAdapter( ArrayList<Artist> artists) {
        this.artists = artists;
    }

    @NonNull
    @Override
    public ArtistsAdapter.ArtistsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.artist_layout, null, false);
        return new  ArtistsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ArtistsAdapter.ArtistsViewHolder holder, int position) {
        String urlImg = "";
        for (LastFmImage img: artists.get(position).getListImages()) {
            if (img.getSize().contentEquals(AnnotationPicSize.MEDIUM))
                urlImg = img.getText();
        }

        holder.tvName.setText(artists.get(position).getName());
        holder.tvListeners.setText(artists.get(position).getListeners());
        holder.tvMbid.setText(artists.get(position).getMbid());
        holder.tvUrl.setText(artists.get(position).getUrl());
        holder.tvStreamable.setText(artists.get(position).getStreamable());

        Picasso.get().load(urlImg).into(holder.ivArtist);
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public class ArtistsViewHolder extends RecyclerView.ViewHolder{

        TextView tvName;
        TextView tvListeners;
        ImageView ivArtist;
        TextView tvMbid;
        TextView tvUrl;
        TextView tvStreamable;

        public ArtistsViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.name_tv);
            tvListeners = itemView.findViewById(R.id.listeners_tv);
            ivArtist = itemView.findViewById(R.id.artist_iv);
            tvMbid = itemView.findViewById(R.id.mbid_tv);
            tvUrl = itemView.findViewById(R.id.url_tv);
            tvStreamable = itemView.findViewById(R.id.streamable_tv);

        }
    }
}
