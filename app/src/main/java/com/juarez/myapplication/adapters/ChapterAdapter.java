package com.juarez.myapplication.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.juarez.myapplication.R;
import com.juarez.myapplication.model.Chapter;

import java.util.ArrayList;

public class ChapterAdapter extends RecyclerView.Adapter<ChapterAdapter.ViewHolder> {
    private Context mContext;
    private ArrayList<Chapter> mDataset;
    private String endpointBanner = "https://www.thetvdb.com/banners/";

    // viewholder accede a todas las vistas
    static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case

        ImageView chapterPhoto;
        TextView chapterName;
        TextView chapterOverview;
        TextView chapterFisrtAired;
        TextView chapterRating;

        ViewHolder(View v) {
            super(v);
            chapterName = v.findViewById(R.id.txtChapterNumber);
            chapterPhoto = v.findViewById(R.id.imgChapterImage);
            chapterFisrtAired = v.findViewById(R.id.txtChapterFirstAired);
            chapterOverview = v.findViewById(R.id.txtChapterOverview);
            chapterRating = v.findViewById(R.id.txtChapterSiteRating);

        }
    }

    // constructor
    public ChapterAdapter(Context context, ArrayList<Chapter> myDataset) {
        mDataset = myDataset;
        mContext = context;
    }


    // Crea nuevas vistas (invocadas pot el layout manager)
    @Override
    public ChapterAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        // crear una nueva vista
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_chapter, parent, false);

        return new ChapterAdapter.ViewHolder(v);
    }

    // Reemplazar el contenido del layout manager
    @Override
    public void onBindViewHolder(final ChapterAdapter.ViewHolder holder, final int position) {
        // - obtiene los elementos del dataset en una posicion definida
        Glide.with(mContext)
                .load(endpointBanner + mDataset.get(position).getFilename())
                .placeholder(R.drawable.toolbarmediomelon)
                .into(holder.chapterPhoto);
        holder.chapterName.setText("Capitulo "+mDataset.get(position).getAiredEpisodeNumber()+": "+mDataset.get(position).getEpisodeName());
        holder.chapterOverview.setText(mDataset.get(position).getOverview());
        holder.chapterFisrtAired.setText("Emitido: "+mDataset.get(position).getFirstAired());
        holder.chapterRating.setText("Calificacion: "+mDataset.get(position).getSiteRating());

    }

    // Devuelve el tamaño de tu dataset
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
