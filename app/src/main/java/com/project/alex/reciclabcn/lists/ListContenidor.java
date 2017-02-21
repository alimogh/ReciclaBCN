package com.project.alex.reciclabcn.lists;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.project.alex.reciclabcn.R;

import java.util.ArrayList;
import java.util.List;

public class ListContenidor extends AppCompatActivity {

    private List<Material> materialList = new ArrayList<>();
    private RecyclerView recyclerView;
    private MaterialsAdapter materialsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_materials);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //toolbar.setBackgroundColor(Color.parseColor(getIntent().getStringExtra("color")));
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); //Fletxa
        getSupportActionBar().setDisplayShowHomeEnabled(true); //Fletxa
        getSupportActionBar().setTitle(getIntent().getStringExtra("title"));

        recyclerView = (RecyclerView) findViewById(R.id.material_recycler_view);
        materialList = new ArrayList<>();
        materialsAdapter = new MaterialsAdapter(getApplicationContext(), materialList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(materialsAdapter);

        prepareMaterials();
    }


    private void prepareMaterials() {

        int[] covers = new int[]{
                R.drawable.contenidor,
                R.drawable.contenidor,
                R.drawable.contenidor,
                R.drawable.contenidor,
                R.drawable.contenidor,
                R.drawable.contenidor,
                R.drawable.contenidor,
                R.drawable.contenidor,
                R.drawable.contenidor,
                R.drawable.contenidor,
                R.drawable.contenidor};

        Material material = new Material("Paper", covers[0]);
        materialList.add(material);

        material = new Material("Cartró", covers[1]);
        materialList.add(material);

        material = new Material("Etiqueta", covers[2]);
        materialList.add(material);

        material = new Material("Més paper", covers[3]);
        materialList.add(material);

        material = new Material("Més cartró", covers[4]);
        materialList.add(material);

        material = new Material("Diari", covers[5]);
        materialList.add(material);

        material = new Material("Bossa de paper o cartró", covers[6]);
        materialList.add(material);

        material = new Material("Capsa de cartró", covers[7]);
        materialList.add(material);

        material = new Material("Revista", covers[8]);
        materialList.add(material);

        material = new Material("Sobre de paper", covers[9]);
        materialList.add(material);

        materialsAdapter.notifyDataSetChanged();
    }
}