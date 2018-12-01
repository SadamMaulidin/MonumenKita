package com.tapperware.monumenkita;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import static com.tapperware.monumenkita.R.id.imgList;
import static com.tapperware.monumenkita.R.id.txtListTitle;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    //TODO 1 membuat variable
    Context context;
    int[] gambarMonumen;
    String[] namaMonumen,detailMonumen;

    public Adapter(Context context, int[] gambarMonumen, String[] namaMonumen, String[] detailMonumen) {
        this.context = context;
        this.gambarMonumen = gambarMonumen;
        this.namaMonumen = namaMonumen;
        this.detailMonumen = detailMonumen;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder viewHolder, final int i) {
        viewHolder.txtNama.setText(namaMonumen[i]);
        Glide.with(context).load(gambarMonumen[i]).into(viewHolder.imgLogo);

        //TODO membuat onclicklistener
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pindah = new Intent(context, Detail.class);
                pindah.putExtra("nm", namaMonumen[i]);
                pindah.putExtra("dm", detailMonumen[i]);
                pindah.putExtra("gm", gambarMonumen[i]);
                context.startActivity(pindah);
            }
        });
    }

    @Override
    public int getItemCount() {
        return gambarMonumen.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgLogo;
        TextView txtNama;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgLogo = itemView.findViewById(imgList);
            txtNama = itemView.findViewById(txtListTitle);
        }
    }
}

