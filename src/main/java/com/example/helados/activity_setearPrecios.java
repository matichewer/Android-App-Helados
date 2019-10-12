package com.example.helados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class activity_setearPrecios extends AppCompatActivity {

    private MainActivity Precio = new MainActivity();
    private EditText et_palito, et_bombon, et_cono, et_paletones, et_crocante, et_milkshake;
    private EditText et_alfajores, et_bombonEscoces, et_almendrado, et_bombonSuizo, et_tiramisu, et_mixto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setear_precios);


        // Seteo de icono dentro de la app
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);


        et_palito = (EditText)findViewById(R.id.et_palitoAgua);
        et_bombon= (EditText)findViewById(R.id.et_bombon);
        et_cono = (EditText)findViewById(R.id.et_conoGelato);
        et_paletones = (EditText)findViewById(R.id.et_Paletones);
        et_crocante = (EditText)findViewById(R.id.et_crocante);
        et_milkshake = (EditText)findViewById(R.id.et_milkshake);
        et_alfajores = (EditText)findViewById(R.id.et_alfajores);
        et_bombonEscoces = (EditText)findViewById(R.id.et_bombonEscoces);
        et_almendrado = (EditText)findViewById(R.id.et_almendrado);
        et_bombonSuizo = (EditText)findViewById(R.id.et_bombonSuizo);
        et_tiramisu = (EditText)findViewById(R.id.et_tiramisu);
        et_mixto = (EditText)findViewById(R.id.et_mixto);

        et_palito.setText(String.valueOf(Precio.getPalitoAgua()));
        et_bombon.setText(String.valueOf(Precio.getBombon()));
        et_cono.setText(String.valueOf(Precio.getConoGelato()));
        et_paletones.setText(String.valueOf(Precio.getPaletones()));
        et_crocante.setText(String.valueOf(Precio.getCrocante()));
        et_milkshake.setText(String.valueOf(Precio.getMilkshake()));
        et_alfajores.setText(String.valueOf(Precio.getAlfajores()));
        et_bombonEscoces.setText(String.valueOf(Precio.getBombonEscoces()));
        et_almendrado.setText(String.valueOf(Precio.getAlmendrado()));
        et_bombonSuizo.setText(String.valueOf(Precio.getBombonSuizo()));
        et_tiramisu.setText(String.valueOf(Precio.getTiramisu()));
        et_mixto.setText(String.valueOf(Precio.getMixto()));
    }

    public void volver(View view){
        finish();
    }

    public void cambiarPrecio(View view){

        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = preferencias.edit();

        String newPrecio_string;
        int newPrecio_int;

        newPrecio_string = et_palito.getText().toString();
        newPrecio_int = Integer.valueOf(newPrecio_string);
        Precio.setPalitoAgua(newPrecio_int);
        Obj_editor.putString("palitoagua", newPrecio_string);

        newPrecio_string = et_bombon.getText().toString();
        newPrecio_int = Integer.valueOf(newPrecio_string);
        Precio.setBombon(newPrecio_int);
        Obj_editor.putString("bombon", newPrecio_string);

        newPrecio_string = et_cono.getText().toString();
        newPrecio_int = Integer.valueOf(newPrecio_string);
        Precio.setConoGelato(newPrecio_int);
        Obj_editor.putString("conogelato", newPrecio_string);

        newPrecio_string = et_paletones.getText().toString();
        newPrecio_int = Integer.valueOf(newPrecio_string);
        Precio.setPaletones(newPrecio_int);
        Obj_editor.putString("paletones", newPrecio_string);

        newPrecio_string = et_crocante.getText().toString();
        newPrecio_int = Integer.valueOf(newPrecio_string);
        Precio.setCrocante(newPrecio_int);
        Obj_editor.putString("crocante", newPrecio_string);

        newPrecio_string = et_milkshake.getText().toString();
        newPrecio_int = Integer.valueOf(newPrecio_string);
        Precio.setMilkshake(newPrecio_int);
        Obj_editor.putString("milkshake", newPrecio_string);

        newPrecio_string = et_alfajores.getText().toString();
        newPrecio_int = Integer.valueOf(newPrecio_string);
        Precio.setAlfajores(newPrecio_int);
        Obj_editor.putString("alfajores", newPrecio_string);

        newPrecio_string = et_bombonEscoces.getText().toString();
        newPrecio_int = Integer.valueOf(newPrecio_string);
        Precio.setBombonEscoces(newPrecio_int);
        Obj_editor.putString("bombonEscoces", newPrecio_string);

        newPrecio_string = et_almendrado.getText().toString();
        newPrecio_int = Integer.valueOf(newPrecio_string);
        Precio.setAlmendrado(newPrecio_int);
        Obj_editor.putString("almendrado", newPrecio_string);

        newPrecio_string = et_bombonSuizo.getText().toString();
        newPrecio_int = Integer.valueOf(newPrecio_string);
        Precio.setBombonSuizo(newPrecio_int);
        Obj_editor.putString("bombonSuizo", newPrecio_string);

        newPrecio_string = et_tiramisu.getText().toString();
        newPrecio_int = Integer.valueOf(newPrecio_string);
        Precio.setTiramisu(newPrecio_int);
        Obj_editor.putString("tiramisu", newPrecio_string);

        newPrecio_string = et_mixto.getText().toString();
        newPrecio_int = Integer.valueOf(newPrecio_string);
        Precio.setMixto(newPrecio_int);
        Obj_editor.putString("mixto", newPrecio_string);

        // Cierra edición
        Obj_editor.commit();

        Toast myToast = Toast.makeText(this,"¡Precios actualizados!", Toast.LENGTH_SHORT);
        myToast.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL,0,0);
        myToast.show();

        //Toast.makeText(this, "¡Precios actualizados!", Toast.LENGTH_SHORT).show();
    }
}
