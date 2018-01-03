package com.example.student.aplikacjapogodowa;



import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.miejsce)
    TextView text;
    @BindView(R.id.editText)
    EditText editText;
    @BindView(R.id.chngPlace)
    Button button;
    @BindView(R.id.showList)
    Button showListButton;
    @BindView(R.id.img)
    ImageView imgBox;


    @OnClick(R.id.chngPlace)
    public void changePlaceClick() {
        String place = editText.getText().toString();
        text.setText(place);
    }

    @OnClick(R.id.showList)
    public void showListClick() {
        Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Glide.with(this).load("http://www.zachod.pl/files/2016/11/pogoda.png").into(imgBox);
        Intent getData = getIntent();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String place = bundle.getString("item");
            text.setText(place);
        }


    }


}


