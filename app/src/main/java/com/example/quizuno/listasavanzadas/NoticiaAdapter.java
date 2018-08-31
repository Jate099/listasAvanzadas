package com.example.quizuno.listasavanzadas;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    public View getView(final int position, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = activity.getLayoutInflater();

        //el inflater transforma un xml en algo visible. pasa xml a View
        View renglon = inflater.inflate(R.layout.renglon, null, false);
        TextView item_titulo = renglon.findViewById(R.id.item_titulo);
        TextView item_fecha = renglon.findViewById(R.id.item_fecha);
        TextView item_descripcion = renglon.findViewById(R.id.item_descripcion);
        Button item_llamar = renglon.findViewById(R.id.item_llamar);

        //se linkea el arraylist al listView
        item_titulo.setText(noticias.get(position).getTitulo());
        item_fecha.setText(noticias.get(position).getFecha());
        item_descripcion.setText(noticias.get(position).getDescripcion());
        item_llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final int Request_phone_call= 1;
                Intent llamar = new Intent(Intent.ACTION_CALL);
                llamar.setData(Uri.parse("tel:3116435652"));

                if(android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.N){
                    if(ContextCompat.checkSelfPermission(activity, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.CALL_PHONE}, Request_phone_call);
                    }else{
                        activity.startActivity(llamar);
                    }
                }

                
                //remueve la noticia respecto a la posicion del arreglo
               //noticias.remove(position);
               //notifyDataSetChanged();

                //ir a otra actividad
                //Intent intent = new Intent(activity, NoticiaCompleta.class);
                //activity.startActivity(intent);

                //Ejemplo de como se debe hacer cuando hacemos el intent desde la mainActivity
                //Intent intent= new Intent(MainActivity.this, NoticiaCompleta.class);


            }
        });

        return renglon;
    }

    public void agergarNoticia(Noticia noticia){
        noticias.add(noticia);
        notifyDataSetChanged();

    }
}
