package com.example.fragment2_dynamic;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FragmentA extends Fragment {
    private RecyclerView recyclerView;
    private Button button;
    private List<Example> arrayList=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView=view.findViewById(R.id.recycler);
        button=view.findViewById(R.id.btn);
        builddata();
        buildrecycle();
    }

    private void builddata() {
        MyApi myApi=Network.getInstance().create(MyApi.class);
        myApi.getmodels().enqueue(new Callback<List<Example>>() {
            @Override
            public void onResponse(Call<List<Example>> call, Response<List<Example>> response) {
                arrayList=response.body();
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        buildrecycle();
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Example>> call, Throwable t) {

            }
        });
    }

    private void buildrecycle() {
        MyAdapter adapter=new MyAdapter(arrayList);
        LinearLayoutManager gridLayoutManager=new LinearLayoutManager(FragmentA.this.getContext());
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
    }
}