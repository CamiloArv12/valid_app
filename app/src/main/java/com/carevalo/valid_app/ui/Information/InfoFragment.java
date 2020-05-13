package com.carevalo.valid_app.ui.Information;

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

import com.carevalo.valid_app.R;

public class InfoFragment extends Fragment {

    private InfoViewModel dashboardViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(InfoViewModel.class);
        View root = inflater.inflate(R.layout.fragment_info, container, false);

      
        return root;
    }
}
