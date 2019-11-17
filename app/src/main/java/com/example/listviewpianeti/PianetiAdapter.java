package com.example.listviewpianeti;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.listviewpianeti.model.Pianeta;

import org.w3c.dom.Text;

import java.util.List;

public class PianetiAdapter extends ArrayAdapter<Pianeta> {
    // Layout grafico da usare per un Pianeta
    private int resourceLayoutPianeta;

    public PianetiAdapter(Context context, List<Pianeta> pianeti, int resourceLayoutPianeta){
        super(context,resourceLayoutPianeta,pianeti);
        this.resourceLayoutPianeta = resourceLayoutPianeta;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Log.d("MIO", "Crea l'oggetto per il pianeta in posizione " + position + " usando la view " + convertView);

        // Recupera il pianeta usando il metodo di ArrayAdapter
        Pianeta pianeta = getItem(position);

        ViewHolder viewHolder = null;

        // Recupera il layout solo se necessario
        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(resourceLayoutPianeta, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.simbolo = ((TextView) convertView.findViewById(R.id.simbolo));
            viewHolder.nome = ((TextView) convertView.findViewById(R.id.nome_pianeta));
            viewHolder.distanza = ((TextView) convertView.findViewById(R.id.distanza));
            viewHolder.volume = ((TextView) convertView.findViewById(R.id.volume));
            viewHolder.satelliti = ((TextView) convertView.findViewById(R.id.satelliti));

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // Simbolo
        viewHolder.simbolo.setText(pianeta.simbolo);

        // Il nome del pianeta
        viewHolder.nome.setText(pianeta.nome);

        // Distanza dal sole
        String distanza = getContext().getString(R.string.ua, pianeta.distanzaSole);
        viewHolder.distanza.setText(distanza);

        // Volume
        String volume = getContext().getString(R.string.volume, pianeta.volumeTerra);
        viewHolder.volume.setText(volume);

        // Il numero di satelliti
        String satelliti = getContext().getResources().getQuantityString(R.plurals.satelliti,pianeta.numeroSatelliti,pianeta.numeroSatelliti);
        viewHolder.satelliti.setText(satelliti);

        return convertView;
    }


    private static class ViewHolder {
        TextView simbolo;
        TextView nome;
        TextView distanza;
        TextView volume;
        TextView satelliti;
    }



}
