package com.example.quizuno.listasavanzadas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView lv_noticias;
    //noticiaAdapter es una clase
    NoticiaAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv_noticias=findViewById(R.id.lv_noticias);
        //se crea un adaptador customizado
        customAdapter = new NoticiaAdapter(this);
        lv_noticias.setAdapter(customAdapter);
        //hola


        Noticia noticia1 = new Noticia("Cambio en el logo de hoy es diseño", "van a cambiar el logo de hoy es diseño!!!!!!!! nisiquiera sabia que eso tenia logo", "31/08/2018");

        Noticia noticia2 = new Noticia("Cambio en el logo de hoy es diseño", "van a cambiar el logo de hoy es diseño!!!!!!!! nisiquiera sabia que eso tenia logo", "31/08/2018");

        customAdapter.agergarNoticia(noticia1);
        customAdapter.agergarNoticia(noticia2);

        lv_noticias.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Noticia noticia_click = (Noticia) customAdapter.getItem(position);
                Toast.makeText(MainActivity.this, noticia_click.getTitulo(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}
