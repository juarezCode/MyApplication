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
import com.juarez.myapplication.model.Actor;
import com.juarez.myapplication.model.Series;

import java.util.ArrayList;

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ViewHolder>{
    private Context mContext;
    private ArrayList<Actor> mDataset;
    private String endpointBanner = "https://www.thetvdb.com/banners/";

    // viewholder accede a todas las vistas
    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        ImageView actorPhoto;
        TextView actorName;
        TextView actorRol;

        ViewHolder(View v) {
            super(v);
            actorName = v.findViewById(R.id.txtActorName);
            actorRol = v.findViewById(R.id.txtActorRol);
            actorPhoto = v.findViewById(R.id.imgActorImage);

        }
    }

    // constructor
    public ActorAdapter(Context context, ArrayList<Actor> myDataset) {
        mDataset = myDataset;
        mContext = context;
    }


    // Crea nuevas vistas (invocadas pot el layout manager)
    @Override
    public ActorAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // crear una nueva vista
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_actor, parent, false);

        return new ActorAdapter.ViewHolder(v);
    }

    // Reemplazar el contenido del layout manager
    @Override
    public void onBindViewHolder(final ActorAdapter.ViewHolder holder, final int position) {
        // - obtiene los elementos del dataset en una posicion definida
        Glide.with(mContext)
                .load(endpointBanner + mDataset.get(position).getImage())
                .placeholder(R.drawable.toolbarmediomelon)
                .into(holder.actorPhoto);
        holder.actorName.setText(mDataset.get(position).getName());
        holder.actorRol.setText(mDataset.get(position).getRole());

    }

    // Devuelve el tamaño de tu dataset
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
