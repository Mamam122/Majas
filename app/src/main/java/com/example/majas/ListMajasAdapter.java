package com.example.majas;

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
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListMajasAdapter extends RecyclerView.Adapter<ListMajasAdapter.CategoryViewHolder>{
    public ListMajasAdapter(Context context) {
        this.context = context;
    }

    private Context context;

    public ArrayList<Majas> getListMajas() {
        return listMajas;
    }


    public void setListMajas(ArrayList<Majas> listMajas) {
        this.listMajas = listMajas;
    }

    private ArrayList<Majas> listMajas;


    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int i) {
        categoryViewHolder.majas.setText(getListMajas().get(i).getMajas());
        Glide.with(context)
                .load(getListMajas().get(i).getGambar())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);
        final int position = categoryViewHolder.getAdapterPosition();

        categoryViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_NAME, getListMajas().get(position).getMajas());
                intent.putExtra(DetailActivity.EXTRA_PENGERTIAN, getListMajas().get(position).getPengertian());
                intent.putExtra(DetailActivity.EXTRA_GAMBAR, getListMajas().get(position).getGambar());
                intent.putExtra(DetailActivity.EXTRA_CONTOH, getListMajas().get(position).getContoh());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListMajas().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView majas;
        ImageView imgPhoto;
        TextView dtlmajas;
        ImageView dtlphoto;
        TextView dtlpengertian;
        TextView dtlcontoh;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            majas = itemView.findViewById(R.id.majas);
            imgPhoto = itemView.findViewById(R.id.gambar);
            dtlpengertian = itemView.findViewById(R.id.pengertian);
            dtlcontoh = itemView.findViewById(R.id.contoh);
            dtlmajas = itemView.findViewById(R.id.majas_detail);
            dtlphoto = itemView.findViewById(R.id.gambar_detail);
        }
    }
}
