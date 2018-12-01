package com.tapperware.monumenkita;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecycleActivity extends AppCompatActivity {

    @BindView(R.id.my_recyler_view)
    RecyclerView myRecylerView;

    String[] namaMonumen,detailMonumen;
    int[] gambarMonumen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycle);
        ButterKnife.bind(this);

        namaMonumen = getResources().getStringArray(R.array.nama_monumen);
        detailMonumen = getResources().getStringArray(R.array.detail_monumen);
        gambarMonumen = new int[]{R.drawable.mons, R.drawable.jam, R.drawable.sura, R.drawable.bali, R.drawable.candi};

        Adapter adapter = new Adapter(RecycleActivity.this, gambarMonumen, namaMonumen, detailMonumen);

        myRecylerView.setHasFixedSize(true);
        myRecylerView.setLayoutManager(new LinearLayoutManager(RecycleActivity.this));
        myRecylerView.setAdapter(adapter);
    }
}
