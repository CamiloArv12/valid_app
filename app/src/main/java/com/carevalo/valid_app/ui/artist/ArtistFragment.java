package com.carevalo.valid_app.ui.artist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.carevalo.valid_app.R;
import com.carevalo.valid_app.network.response.Artist;
import com.carevalo.valid_app.network.response.TopArtists;
import com.carevalo.valid_app.ui.adapters.ArtistsAdapter;

import java.util.ArrayList;
import java.util.List;

public class ArtistFragment extends Fragment {

    ArrayList<Artist> articleArrayList = new ArrayList<>();
    ArtistsAdapter artistAdapter;
    RecyclerView rvArtist;
    ArtistViewModel artistViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_artist, container, false);
        rvArtist = view.findViewById(R.id.recycler_view);

        artistViewModel = ViewModelProviders.of(this).get(ArtistViewModel.class);
        artistViewModel.init();
        artistViewModel.getArtistsUseCase().observe(this, artistResponse -> {
           TopArtists topArtists = artistResponse.getTopArtists();
            articleArrayList.addAll(topArtists.getArtist());
            artistAdapter.notifyDataSetChanged();
        });

        setupRecyclerView();
        return view;
    }


    private void setupRecyclerView() {
        if (artistAdapter == null) {

            artistAdapter = new ArtistsAdapter( articleArrayList);
            rvArtist.setLayoutManager(new LinearLayoutManager(getContext()));
            rvArtist.setAdapter(artistAdapter);
            rvArtist.setItemAnimator(new DefaultItemAnimator());
            rvArtist.setNestedScrollingEnabled(true);

        } else {
            artistAdapter.notifyDataSetChanged();
        }
    }




}
