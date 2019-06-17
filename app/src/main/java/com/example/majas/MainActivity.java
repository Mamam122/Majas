package com.example.majas;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvCategory;
    ImageView gambar;
    private ArrayList<Majas> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvCategory = findViewById(R.id.list_catagori);
        rvCategory.setHasFixedSize(true);
        list.addAll(DataMajas.getListData());
        showRecyclerList();

    }


    private void showRecyclerList() {
        rvCategory.setLayoutManager(new LinearLayoutManager(this));
        ListMajasAdapter listPresidentAdapter = new ListMajasAdapter(this);
        listPresidentAdapter.setListMajas(list);
        rvCategory.setAdapter(listPresidentAdapter);


    }
}
