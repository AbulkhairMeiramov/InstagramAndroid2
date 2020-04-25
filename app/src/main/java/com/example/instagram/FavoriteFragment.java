package com.example.instagram;

import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class FavoriteFragment extends Fragment {

    private RecyclerView recyclerView;
    private LinearLayout linearLayout;
    private final String KEY_RECYCLER_STATE = "recycler_state";
    private final String KEY_HorizontalScrollView_STATE = "horizontalScrollViewState";
    private static Bundle mBundle;
    private SwipeRefreshLayout swipeRefreshLayout;

    private ArrayList<String> avatars = new ArrayList<>();
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<String> images = new ArrayList<>();
    private ArrayList<String> views = new ArrayList<>();
    private ArrayList<String> descriptions = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favorite, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);

        recyclerView = view.findViewById(R.id.recycle_view_favorite);
        FavoriteRecycleViewAdapter adapter = new FavoriteRecycleViewAdapter(this.getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));

        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                MainActivity.Refresh();
            }
        });
    }

}
