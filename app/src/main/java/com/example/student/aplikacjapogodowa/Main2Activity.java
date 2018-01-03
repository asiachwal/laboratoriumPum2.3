package com.example.student.aplikacjapogodowa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.text)
    TextView text;

    String placeToPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Będzin", "Zamek"));
        places.add(new Place("Zabrze", "Multikino"));
        OnItemClick listener = (view, position) -> {
            placeToPass = places.get(position).getPlaceName();
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("item", placeToPass);
            intent.putExtras(bundle);
            startActivity(intent);
        };
        PlaceAdapter placeAdapter = new PlaceAdapter(places, listener);
        recyclerView.setAdapter(placeAdapter);

    }
}
