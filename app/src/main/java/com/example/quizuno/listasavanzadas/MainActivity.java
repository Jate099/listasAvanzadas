package com.example.quizuno.listasavanzadas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private ListView lv_noticias;
    EditText et_colocartitulo;
    Button btn_generar;
    //noticiaAdapter es una clase
    NoticiaAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_colocartitulo = findViewById(R.id.et_colocartitulo);
        btn_generar = findViewById(R.id.btn_generar);

        lv_noticias=findViewById(R.id.lv_noticias);
        //se crea un adaptador customizado
        customAdapter = new NoticiaAdapter(this);
        lv_noticias.setAdapter(customAdapter);
        //hola


        Noticia noticia1 = new Noticia("Cambios extraños que hay en mi", "van a cambiar el logo de hoy es diseño!!!!!!!! nisiquiera sabia que eso tenia logo", "31/08/2018");

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

        btn_generar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //traer la fecha actual
                Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                month += 1;
                int day = c.get(Calendar.DAY_OF_MONTH);
                String fecha = day+"/"+month+"/"+year;

                String titulo = et_colocartitulo.getText().toString();
                Noticia newNoticia = new Noticia(titulo, "descricpion", fecha);
                customAdapter.agergarNoticia(newNoticia);
            }
        });

    }
}
