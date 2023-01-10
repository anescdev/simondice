package com.tutorialesprogramacionya.proyecto041;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button boton0, boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9;
    private TextView tv1;
    private MediaPlayer mp1;
    private String numeroRecordar;                //  "01111"
    private String numeroJugador;
    private boolean dificultad = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton0=findViewById(R.id.boton0);
        boton1=findViewById(R.id.boton1);
        boton2=findViewById(R.id.boton2);
        boton3=findViewById(R.id.boton3);
        boton4=findViewById(R.id.boton4);
        boton5=findViewById(R.id.boton5);
        boton6=findViewById(R.id.boton6);
        boton7=findViewById(R.id.boton7);
        boton8=findViewById(R.id.boton8);
        boton9=findViewById(R.id.boton9);
        tv1=findViewById(R.id.tv1);
        desactivarBotones();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        this.getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.difficultSwitch:
                this.dificultad = !this.dificultad;
                if (this.dificultad==true)
                    item.setTitle("Modo fácil");
                else
                    item.setTitle("Modo difícil");
                return true;
            default:
                return false;
        }
    }

    private void desactivarBotones() {
        boton0.setEnabled(false);
        boton1.setEnabled(false);
        boton2.setEnabled(false);
        boton3.setEnabled(false);
        boton4.setEnabled(false);
        boton5.setEnabled(false);
        boton6.setEnabled(false);
        boton7.setEnabled(false);
        boton8.setEnabled(false);
        boton9.setEnabled(false);
    }

    private void activarBotones() {
        boton0.setEnabled(true);
        boton1.setEnabled(true);
        boton2.setEnabled(true);
        boton3.setEnabled(true);
        boton4.setEnabled(true);
        boton5.setEnabled(true);
        boton6.setEnabled(true);
        boton7.setEnabled(true);
        boton8.setEnabled(true);
        boton9.setEnabled(true);
    }

    public void iniciarJuego(View v)
    {
        desactivarBotones();
        numeroRecordar="";
        agregarUnNumeroAlFinal();
        tv1.setText("Cantidad de cifras a recordar:"+numeroRecordar.length());
        numeroJugador="";
        emitirSonido(0);
    }

    private void emitirSonido(int posicion) {
       if (mp1!=null)
           mp1.release();
       switch (numeroRecordar.charAt(posicion)){
           case '0':
               mp1=MediaPlayer.create(this,R.raw.cero);
               break;
           case '1':
               mp1=MediaPlayer.create(this,R.raw.uno);
               break;
           case '2':
               mp1=MediaPlayer.create(this,R.raw.dos);
               break;
           case '3':
               mp1=MediaPlayer.create(this,R.raw.tres);
               break;
           case '4':
               mp1=MediaPlayer.create(this,R.raw.cuatro);
               break;
           case '5':
               mp1=MediaPlayer.create(this,R.raw.cinco);
               break;
           case '6':
               mp1=MediaPlayer.create(this,R.raw.seis);
               break;
           case '7':
               mp1=MediaPlayer.create(this,R.raw.siete);
               break;
           case '8':
               mp1=MediaPlayer.create(this,R.raw.ocho);
               break;
           case '9':
               mp1=MediaPlayer.create(this,R.raw.nueve);
               break;
       }
        assert mp1 != null;
        mp1.setVolume(1.0f,1.0f);
        mp1.start();
        mp1.setOnCompletionListener((mediaPlayer -> {
            if (posicion<numeroRecordar.length()-1) {
                emitirSonido(posicion+1);
            }else
                activarBotones();
        }));

    }

    private void agregarUnNumeroAlFinal() {
        int ale=(int)(Math.random()*10);
        switch (ale) {
            case 0:
                numeroRecordar = numeroRecordar + "0";
                break;
            case 1:
                numeroRecordar = numeroRecordar + "1";
                break;
            case 2:
                numeroRecordar = numeroRecordar + "2";
                break;
            case 3:
                numeroRecordar = numeroRecordar + "3";
                break;
            case 4:
                numeroRecordar = numeroRecordar + "4";
                break;
            case 5:
                numeroRecordar = numeroRecordar + "5";
                break;
            case 6:
                numeroRecordar = numeroRecordar + "6";
                break;
            case 7:
                numeroRecordar = numeroRecordar + "7";
                break;
            case 8:
                numeroRecordar = numeroRecordar + "8";
                break;
            case 9:
                numeroRecordar = numeroRecordar + "9";
                break;
        }
    }

    public void presionBoton0(View v)
    {
        numeroJugador=numeroJugador+"0";
        controlarSiEsCorrecto();
    }

    public void presionBoton1(View v)
    {
        numeroJugador=numeroJugador+"1";
        controlarSiEsCorrecto();
    }
    public void presionBoton2(View v)
    {
        numeroJugador=numeroJugador+"2";
        controlarSiEsCorrecto();
    }
    public void presionBoton3(View v)
    {
        numeroJugador=numeroJugador+"3";
        controlarSiEsCorrecto();
    }
    public void presionBoton4(View v)
    {
        numeroJugador=numeroJugador+"4";
        controlarSiEsCorrecto();
    }
    public void presionBoton5(View v)
    {
        numeroJugador=numeroJugador+"5";
        controlarSiEsCorrecto();
    }
    public void presionBoton6(View v)
    {
        numeroJugador=numeroJugador+"6";
        controlarSiEsCorrecto();
    }
    public void presionBoton7(View v)
    {
        numeroJugador=numeroJugador+"7";
        controlarSiEsCorrecto();
    }
    public void presionBoton8(View v)
    {
        numeroJugador=numeroJugador+"8";
        controlarSiEsCorrecto();
    }
    public void presionBoton9(View v)
    {
        numeroJugador=numeroJugador+"9";
        controlarSiEsCorrecto();
    }

    private void controlarSiEsCorrecto() {
        if (numeroJugador.charAt(numeroJugador.length()-1)!=numeroRecordar.charAt(numeroJugador.length()-1))
        {
            Toast.makeText(this,"Perdiste",Toast.LENGTH_LONG).show();
            desactivarBotones();
        }
        else
            if (numeroJugador.length()==numeroRecordar.length())
            {
                desactivarBotones();
                numeroJugador="";
                agregarUnNumeroAlFinal();
                emitirSonido(0);
                tv1.setText("Cantidad de cifras a recordar:"+numeroRecordar.length());
            }
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mp1!=null)
        {
            mp1.release();
            mp1=null;
        }
    }
}