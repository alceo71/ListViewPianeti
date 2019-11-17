package com.example.listviewpianeti;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.widget.ListView;

import com.example.listviewpianeti.model.Pianeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    public List<Pianeta> pianeti(){
        List<Pianeta> pianeti = new ArrayList<Pianeta>();
        pianeti.add(new Pianeta("Mercurio",0.38709893,0.0056,0,"\u263f"));
        pianeti.add(new Pianeta("Venere",0.72333199,0.857,0,"\u2640"));
        pianeti.add(new Pianeta("Terra",1,1,1,"\u2295"));
        pianeti.add(new Pianeta("Marte",1.52366231,0.149,2,"\u2642"));
        pianeti.add(new Pianeta("Giove",5.20336301,1316,67,"\u2643"));
        pianeti.add(new Pianeta("Saturno",9.53707032,755,62,"\u2644"));
        pianeti.add(new Pianeta("Urano",19.19126393,52,27,"\u2645"));
        pianeti.add(new Pianeta("Nettuno",30.06896348,44,14,"\u2646"));
        return pianeti;
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            getResources().getConfiguration().setLocale(Locale.ITALY);
        } else{
            getResources().getConfiguration().locale = Locale.ITALY;
        }

        ListView listaPianeti = (ListView) findViewById(R.id.lista_pianeti);
        PianetiAdapter adapter = new PianetiAdapter(this, pianeti(), R.layout.pianeta);
        listaPianeti.setAdapter(adapter);
    }
}
