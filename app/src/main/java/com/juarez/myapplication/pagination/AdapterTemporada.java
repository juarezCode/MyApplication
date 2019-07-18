package com.juarez.myapplication.pagination;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.juarez.myapplication.R;

import java.util.ArrayList;

public class AdapterTemporada extends RecyclerView.Adapter<AdapterTemporada.ViewHolder> {
    private Context mContext;
    public ArrayList<Temporada> mSeasons;
    private OnSeasonListener mOnSeasonListener;

    // constructor
    public AdapterTemporada(Context context, ArrayList<Temporada> myDataset, OnSeasonListener onSeasonListener) {
        mSeasons = myDataset;
        mContext = context;
        this.mOnSeasonListener = onSeasonListener;
    }

    // Crea nuevas vistas (invocadas pot el layout manager)
    @Override
    public AdapterTemporada.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                          int viewType) {
        // crear una nueva vista
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_temporada, parent, false);

        return new AdapterTemporada.ViewHolder(v, mOnSeasonListener);
    }

    // Reemplazar el contenido del layout manager
    @Override
    public void onBindViewHolder(final AdapterTemporada.ViewHolder holder, final int position) {

        holder.numberTemporada.setText(String.valueOf(mSeasons.get(position).getNumber()));

    }

    @Override
    public int getItemCount() {
        return mSeasons.size();
    }


    // implememta de interface
    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView numberTemporada;
        OnSeasonListener onSeasonListener;//instancia

        ViewHolder(View v, OnSeasonListener onSeasonListener) {//parametro
            super(v);
            numberTemporada = v.findViewById(R.id.txtNumerSeason);
            this.onSeasonListener = onSeasonListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onSeasonListener.onSeasonClick(getAdapterPosition());
        }
    }

    //interface
    public interface OnSeasonListener {
        void onSeasonClick(int posicion);
    }


}
