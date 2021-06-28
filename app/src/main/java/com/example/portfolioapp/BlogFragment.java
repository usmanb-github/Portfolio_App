package com.example.portfolioapp;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BlogFragment extends Fragment{


    RecyclerView rv_blog;
    BlogAdapter blogAdapter;
    List<BlogItem> mdata;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_blog, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_blog = view.findViewById(R.id.rv_blog);
        mdata = new ArrayList<>();
        mdata.add( new BlogItem("How I got started with Android Development?"));

        rv_blog.setLayoutManager(new LinearLayoutManager(getContext()));
        blogAdapter = new BlogAdapter(mdata);
        rv_blog.setAdapter(blogAdapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(rv_blog.getContext(),
                new LinearLayoutManager(getContext()).getOrientation());
        rv_blog.addItemDecoration(dividerItemDecoration);
    }
}
