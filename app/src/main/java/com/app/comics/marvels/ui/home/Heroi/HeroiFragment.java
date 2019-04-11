package com.app.comics.marvels.ui.home.Heroi;

import android.support.v4.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.comics.marvels.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class HeroiFragment extends DialogFragment {

    private Context context;

    private ImageView iv;
    private TextView tv_nome;
    private TextView tv_descricao;

    private String imagem;
    private String nome;
    private String descricao;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_heroi, container, false);

        inicializaVariaves(mView);
        inicializaAcoes();


        return mView;
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = ViewGroup.LayoutParams.WRAP_CONTENT;
        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);
    }

    private void inicializaVariaves(View mView) {
        context = getActivity();

        iv = mView.findViewById(R.id.fragment_heroi_iv);
        tv_nome = mView.findViewById(R.id.fragment_heroi_tv_nome);
        tv_descricao = mView.findViewById(R.id.textView2);

        imagem = getArguments().getString("imagem");
        nome = getArguments().getString("nome");
        descricao = getArguments().getString("descricao");

        Glide.with(context)
                .load(imagem)
                .diskCacheStrategy(DiskCacheStrategy.RESULT)
                .centerCrop()
                .crossFade()
                .into(iv);

        tv_nome.setText(nome);

        if (descricao.equals("")) {
            tv_descricao.setVisibility(View.GONE);
        } else {
            tv_descricao.setText(descricao);
        }
    }

    private void inicializaAcoes() {


    }
}
