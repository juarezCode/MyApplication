package com.juarez.myapplication.adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.juarez.myapplication.DetailActivity;
import com.juarez.myapplication.R;
import com.juarez.myapplication.SeriesActivity;
import com.juarez.myapplication.model.Series;

import java.util.ArrayList;

public class SeriesAdapter extends RecyclerView.Adapter<SeriesAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Series> mDataset;
    private String endpointBanner = "https://www.thetvdb.com/banners/";

    // viewholder accede a todas las vistas
    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        ImageView photo;
        TextView serieName;

        ViewHolder(View v) {
            super(v);
            serieName = v.findViewById(R.id.txtSeriesName);
            photo = v.findViewById(R.id.imageSeriesBack);

        }
    }

    // constructor
    public SeriesAdapter(Context context, ArrayList<Series> myDataset) {
        mDataset = myDataset;
        mContext = context;
    }


    // Crea nuevas vistas (invocadas pot el layout manager)
    @Override
    public SeriesAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // crear una nueva vista
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_series, parent, false);

        return new SeriesAdapter.ViewHolder(v);
    }

    // Reemplazar el contenido del layout manager
    @Override
    public void onBindViewHolder(final SeriesAdapter.ViewHolder holder, final int position) {
        // - obtiene los elementos del dataset en una posicion definida
        Glide.with(mContext)
                .load(endpointBanner + mDataset.get(position).getBanner())
                .placeholder(R.drawable.bannermediomelon)
                .into(holder.photo);
        holder.serieName.setText(mDataset.get(position).getSeriesName());
        //lanzar a pantalla detalles de serie
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Adapter", "id: " + mDataset.get(position).getId());

                /*Series serie = new Series(
                        mDataset.get(position).getAliases(),
                        mDataset.get(position).getBanner(),
                        mDataset.get(position).getFirstAired(),
                        mDataset.get(position).getId(),
                        mDataset.get(position).getNetwork(),
                        mDataset.get(position).getOverview(),
                        mDataset.get(position).getSeriesName(),
                        mDataset.get(position).getSlug(),
                        mDataset.get(position).getStatus());*/

                Intent intent = new Intent(v.getContext(), DetailActivity.class);
                intent.putExtra("seriesName", mDataset.get(position).getSeriesName());
                intent.putExtra("serie", mDataset.get(position));
                mContext.startActivity(intent);
            }
        });

    }

    // Devuelve el tamaño de tu dataset
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}

