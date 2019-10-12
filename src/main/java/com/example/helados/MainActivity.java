package com.example.helados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView cont;
    private static int palitoAgua, bombon, conoGelato, paletones, crocante, milkshake;
    private static int alfajores, bombonEscoces, almendrado, bombonSuizo, tiramisu, mixto;
    private static SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Seteo de icono dentro de la app
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


        cont = (TextView)findViewById(R.id.editText_monto);

        preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        cont.setText(preferences.getString("monto","0"));
        palitoAgua = Integer.parseInt(preferences.getString("palitoagua","0"));
        bombon = Integer.parseInt(preferences.getString("bombon", "0"));
        conoGelato = Integer.parseInt(preferences.getString("conogelato", "0"));
        paletones = Integer.parseInt(preferences.getString("paletones", "0"));
        crocante = Integer.parseInt(preferences.getString("crocante", "0"));
        milkshake = Integer.parseInt(preferences.getString("milkshake", "0"));
        alfajores = Integer.parseInt(preferences.getString("alfajores", "0"));
        bombonEscoces = Integer.parseInt(preferences.getString("bombonEscoces", "0"));
        almendrado = Integer.parseInt(preferences.getString("almendrado", "0"));
        bombonSuizo = Integer.parseInt(preferences.getString("bombonSuizo", "0"));
        tiramisu = Integer.parseInt(preferences.getString("tiramisu", "0"));
        mixto = Integer.parseInt(preferences.getString("mixto", "0"));


    }
    public static SharedPreferences getPreferences(){
        return preferences;
    }


    public static int getPalitoAgua()    { return palitoAgua;    }
    public static int getBombon()        { return bombon;        }
    public static int getConoGelato()    { return conoGelato;    }
    public static int getPaletones()     { return paletones;     }
    public static int getCrocante()      { return crocante;      }
    public static int getMilkshake()     { return milkshake;     }
    public static int getAlfajores()     { return alfajores;     }
    public static int getBombonEscoces() { return bombonEscoces; }
    public static int getAlmendrado()    { return almendrado;    }
    public static int getBombonSuizo()   { return bombonSuizo;   }
    public static int getTiramisu()      { return tiramisu;      }
    public static int getMixto()         { return mixto;         }

    public static void setPalitoAgua   (int num)  { palitoAgua    = num; }
    public static void setBombon       (int num)  { bombon        = num; }
    public static void setConoGelato   (int num)  { conoGelato    = num; }
    public static void setPaletones    (int num)  { paletones     = num; }
    public static void setCrocante     (int num)  { crocante      = num; }
    public static void setMilkshake    (int num)  { milkshake     = num; }
    public static void setAlfajores    (int num)  { alfajores     = num; }
    public static void setBombonEscoces(int num)  { bombonEscoces = num; }
    public static void setAlmendrado   (int num)  { almendrado    = num; }
    public static void setBombonSuizo  (int num)  { bombonSuizo   = num; }
    public static void setTiramisu     (int num)  { tiramisu      = num; }
    public static void setMixto        (int num)  { mixto         = num; }


        public void sumar(View view){

            // Si el monto está vacio, poner un 0
            if(cont.getText().toString().isEmpty())
                cont.setText(String.valueOf(0));

            // Calcular el valor del helado
            int valor_a_sumar = 0;
            switch(view.getId()){
                case R.id.button_palito:
                    valor_a_sumar = palitoAgua;
                    break;
                case R.id.button_bombon:
                    valor_a_sumar = bombon;
                    break;
                case R.id.button_cono:
                    valor_a_sumar = conoGelato;
                    break;
                case R.id.button_paletones:
                    valor_a_sumar = paletones;
                    break;
                case R.id.button_crocante:
                    valor_a_sumar = crocante;
                    break;
                case R.id.button_milkshake:
                    valor_a_sumar = milkshake;
                    break;
                case R.id.button_alfajores:
                    valor_a_sumar = alfajores;
                    break;
                case R.id.button_bombomEscoces:
                    valor_a_sumar = bombonEscoces;
                    break;
                case R.id.button_almendrado:
                    valor_a_sumar = almendrado;
                    break;
                case R.id.button_bombónSuizo:
                    valor_a_sumar = bombonSuizo;
                    break;
                case R.id.button_tiramisu:
                    valor_a_sumar = tiramisu;
                    break;
                case R.id.button_mixto:
                    valor_a_sumar = mixto;
                    break;

                case R.id.button_sumarUno:
                    valor_a_sumar = 1;
                    break;
                case R.id.button_restarUno:
                    valor_a_sumar = -1;
                    break;
                case R.id.button_resetear:
                    String monto_resetear = cont.getText().toString();
                    valor_a_sumar =  (-1) * Integer.parseInt(monto_resetear);
                    break;
            }

            // Obtengo el monto total actual
            String monto_string = cont.getText().toString();

            // Sumo el monto total con el valor del helado
            int monto_int = Integer.parseInt(monto_string);
            monto_int = monto_int + valor_a_sumar;

            // Seteo el resultado en la interfaz
            String resultado = String.valueOf(monto_int);
            cont.setText(resultado);

            // Guardo el monto en la memoria para que no se pierda
            preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
            SharedPreferences.Editor Obj_editor = preferences.edit();
            Obj_editor.putString("monto", resultado);
            Obj_editor.commit();

        }


        public void setearPrecios(View view){
            Intent precios = new Intent(this,activity_setearPrecios.class);
            startActivity(precios);
        }
}

