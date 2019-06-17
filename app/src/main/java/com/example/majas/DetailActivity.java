package com.example.majas;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;


public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_PENGERTIAN = "extra_pengertian";
    public static final String EXTRA_CONTOH = "extra_contoh";
    public static final String EXTRA_NAME = "extra_name";
    public static final String EXTRA_GAMBAR = "extra_gambar";

    TextView majas, pengertian, contoh;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_view);

        setActionBarTitle("Detail");
        majas = findViewById(R.id.majas_detail);
        pengertian = findViewById(R.id.pengertian);
        img = findViewById(R.id.gambar_detail);
        contoh = findViewById(R.id.contoh);

        go();

    }

    private void go() {

        String nama = getIntent().getStringExtra(EXTRA_NAME);
        String detail1 = getIntent().getStringExtra(EXTRA_PENGERTIAN);
        String detail2 = getIntent().getStringExtra(EXTRA_CONTOH);
        String photo = getIntent().getStringExtra(EXTRA_GAMBAR);

        Glide.with(DetailActivity.this)
                .load(photo)
                .apply(new RequestOptions().override(200,100))
                .into(img);

        majas.setText(nama);
        pengertian.setText(detail1);
        contoh.setText(detail2);

    }
    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);
    }
}
