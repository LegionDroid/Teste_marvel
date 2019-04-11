package com.app.comics.marvels.ui.home.favorites;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.comics.marvels.R;
import com.app.comics.marvels.data.network.model.Heroi;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {

    private List<Heroi> herois;
    private Context context;

    public FavoritesAdapter(List<Heroi> herois, Context context) {
        this.herois = herois;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context)
                .inflate(R.layout.favorites_item_layout, parent, false);
        return new ViewHolder(v, context);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Heroi itemHeroi = herois.get(position);
        holder.bind(itemHeroi, position);
    }

    @Override
    public int getItemCount() {
        return herois.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv;
        private TextView tv_nome;

        private Context context;

        public ViewHolder(View itemView, Context context) {
            super(itemView);
            this.context = context;

            iv = itemView.findViewById(R.id.celula_favoritos_iv);
            tv_nome = itemView.findViewById(R.id.celula_favoritos_tv_nome);
        }

        public void bind(Heroi itemHeroi, final int position) {

            Glide.with(context)
                    .load(itemHeroi.getImagem())
                    .diskCacheStrategy(DiskCacheStrategy.RESULT)
                    .centerCrop()
                    .crossFade()
                    .into(iv);

            tv_nome.setText(itemHeroi.getNome());

        }
    }
}
