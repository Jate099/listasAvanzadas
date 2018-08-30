package com.example.quizuno.listasavanzadas;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class NoticiaAdapter extends BaseAdapter {

    ArrayList<Noticia> noticias;
    Activity activity;

    public NoticiaAdapter(Activity activity){
        this.activity = activity;
        noticias = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return noticias.size();
    }

    @Override
    public Object getItem(int i) {
        return noticias.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    //generar un renglon por objeto
    //posiscion = posicion del arreglo
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();

        //el inflater transforma un xml en algo visible. pasa xml a View
        View renglon = inflater.inflate(R.layout.renglon, null, false);
        TextView item_titulo = renglon.findViewById(R.id.item_titulo);
        TextView item_fecha = renglon.findViewById(R.id.item_fecha);
        TextView item_descripcion = renglon.findViewById(R.id.item_descripcion);

        //se linkea el arraylist al listView
        item_titulo.setText(noticias.get(position).getTitulo());
        item_fecha.setText(noticias.get(position).getFecha());
        item_descripcion.setText(noticias.get(position).getDescripcion());

        return renglon;
    }

    public void agergarNoticia(Noticia noticia){
        noticias.add(noticia);
        notifyDataSetChanged();

    }
}
