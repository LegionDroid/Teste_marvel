package com.app.comics.marvels.ui.home.favorites;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.app.comics.marvels.BuildConfig;
import com.app.comics.marvels.R;
import com.app.comics.marvels.dao.HeroiDao;
import com.app.comics.marvels.data.network.MarvelApi;
import com.app.comics.marvels.data.network.model.Characters;
import com.app.comics.marvels.data.network.model.Heroi;
import com.app.comics.marvels.data.network.model.Result;
import com.app.comics.marvels.ui.home.characters.CharacterItemDecoration;
import com.app.comics.marvels.ui.home.characters.CharacterLikeAnimator;
import com.app.comics.marvels.ui.home.characters.CharacterRVAdapter;
import com.app.comics.marvels.util.Constants;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FavoritesFragment extends Fragment{

    private Context context;

    private RecyclerView recyclerView;
    private FavoritesAdapter favoritesAdapter;
    private HeroiDao heroiDao;
    private List<Heroi> herois;

    public static FavoritesFragment newInstance() {
        Bundle args = new Bundle();
        FavoritesFragment fragment = new FavoritesFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_favorites, container, false);

        inicializaVariaves(mView);
        inicializaAcoes();


        return mView;
    }


    private void inicializaVariaves(View mView) {


        context = getActivity();

        recyclerView = mView.findViewById(R.id.rv_favoritos);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        //
        heroiDao = new HeroiDao(context);
        //
        herois = heroiDao.obterListaDeHerois();

        favoritesAdapter = new FavoritesAdapter(herois, context);
        recyclerView.setAdapter(favoritesAdapter);
    }

    private void inicializaAcoes() {

    }


}
