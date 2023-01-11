package com.tutorialesprogramacionya.proyecto041;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button boton0, boton1, boton2, boton3, boton4, boton5, boton6, boton7, boton8, boton9;
    private TextView tv1;
    private MediaPlayer mp1;
    private String numeroRecordar;                //  "01111"
    private String numeroJugador;
    private boolean dificil = false;
    private MenuItem difficultItemMenu;
    private TableLayout contenedorBotones;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Establecemos como vista de la actividad la que se ha creado
        this.setContentView(R.layout.activity_main);
        //Buscamos dentro de la vista todos los elementos necesarios
        this.boton0=findViewById(R.id.boton0);
        this.boton1=findViewById(R.id.boton1);
        this.boton2=findViewById(R.id.boton2);
        this.boton3=findViewById(R.id.boton3);
        this.boton4=findViewById(R.id.boton4);
        this.boton5=findViewById(R.id.boton5);
        this.boton6=findViewById(R.id.boton6);
        this.boton7=findViewById(R.id.boton7);
        this.boton8=findViewById(R.id.boton8);
        this.boton9=findViewById(R.id.boton9);
        this.tv1=findViewById(R.id.tv1);
        this.contenedorBotones = findViewById(R.id.contenedorBotones);
        //Desactivamos los botones
        desactivarBotones();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /*
         * Obtenemos el objeto que mostrará el menú, este tipo  de objetos suelen llamarse inflater o infladores que
         * "inflan desde que no se ve hasta que está en el tamaño normal" un elemento a la vista. Esto no es así
         * pero para entenderse sirve, entonces pasamos al método inflate el id dle menu y el parámetro del método
         * que después de esta línea, menu hará referencia al menu mostrado en la vista
         */
        this.getMenuInflater().inflate(R.menu.menu, menu);
        //guardamos el elemento dle menú en la propiedad
        this.difficultItemMenu = menu.getItem(0);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Si el item del menú al que se le dió click tiene el mismo id que el del botón difficultSwitch
        if (item.getItemId() == R.id.difficultSwitch) {
            //Asignamos a dificil el valor contrario
            this.dificil = !this.dificil;
            //si dificil es true el texto del item menu pasa a facil
            if (this.dificil)
                item.setTitle("Modo fácil");
            //si dificil es true el texto del item menu pasa a difícil
            else
                item.setTitle("Modo difícil");
            return true;
        }
        return false;
    }

    /**
     * Método que desactiva todos los botones
     */
    private void desactivarBotones() {
        this.boton0.setEnabled(false);
        this.boton1.setEnabled(false);
        this.boton2.setEnabled(false);
        this.boton3.setEnabled(false);
        this.boton4.setEnabled(false);
        this.boton5.setEnabled(false);
        this.boton6.setEnabled(false);
        this.boton7.setEnabled(false);
        this.boton8.setEnabled(false);
        this.boton9.setEnabled(false);
    }
    /**
     * Método que activa todos los botones
     */
    private void activarBotones() {
        this.boton0.setEnabled(true);
        this.boton1.setEnabled(true);
        this.boton2.setEnabled(true);
        this.boton3.setEnabled(true);
        this.boton4.setEnabled(true);
        this.boton5.setEnabled(true);
        this.boton6.setEnabled(true);
        this.boton7.setEnabled(true);
        this.boton8.setEnabled(true);
        this.boton9.setEnabled(true);
    }

    /**
     * Método que inicia el juego
     * @param v Parámetro necesario para que el editor gráfico muestre este método
     */
    public void iniciarJuego(View v)
    {
        //Seteamos el número a recordar vacío
        numeroRecordar="";
        //Agregamos un numero al final
        agregarUnNumeroAlFinal();
        //establecemos el texto de aviso con la nueva longitud
        tv1.setText("Cantidad de cifras a recordar:"+numeroRecordar.length());
        //Numero que el jugador va completando si escribe el número correcto
        numeroJugador="";
        //Emitimos sonido con el numero que acabamos de añadir al numero a adivinar
        emitirSonido(0);
        //Desactivamos el elemento del menu que permite cambiar la dificultad
        this.difficultItemMenu.setEnabled(false);
        //Animación para que los botones se muestren en una transición de medio segundo
        this.contenedorBotones.animate()
                .alpha(1f)
                .setDuration(500);
    }

    private void emitirSonido(int posicion) {
        //Si ya hay un mediaplayer creado, lo liberamos para que no consuma recursos innecesarios
        if (mp1!=null)
           mp1.release();
        //Dependiendo de la posición pasada por parámetro, se crea un mediaplayer con el audio correspondiente al número de la posición
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
        //Nos aseguramos de que mp1 no sea nulo
        assert mp1 != null;
        //Subimos el volumen al máximo(esto lo hago ya que en mi caso no se escuchaba nada pero al probarlo en otros sitios si)
        mp1.setVolume(1.0f,1.0f);
        /*
         * Si dificil es igual a true cambiamos los parámetros del video, obteniendo los actuales para que tenga ya los por defecto
         * menos la velocidad que la multiplicamos por 2,5
         */
        if (this.dificil){
            mp1.setPlaybackParams(mp1.getPlaybackParams().setSpeed(2.5f));
        }
        //Comenzamos la reproducción
        mp1.start();
        //establecemos un listener para que se ejecute cada vez que se termine de reproducirlo
        mp1.setOnCompletionListener((mediaPlayer -> {
            //Si la posición es menor al último numero a recordar, reproducimos el sonido correpondiente al siguiente número
            if (posicion<numeroRecordar.length()-1) {
                emitirSonido(posicion+1);
            //Activamos los botones en caso de que ya no haya más numeros que reproducir
            }else
                activarBotones();
        }));

    }

    private void agregarUnNumeroAlFinal() {
        //variable que generará un numero aleatorio del 0 al 10(excluyendo el 10) y lo añadimos al final del que ya tenemos
        numeroRecordar = numeroRecordar + (int)(Math.random()*10);
    }
    /*
     * Todos hacen lo mismo por lo que:
     * Añadimos al numero del jugador el correspondiente al numero presionado
     */

    public void presionBoton(View v)
    {
        numeroJugador=numeroJugador+((Button)v).getText();
        controlarSiEsCorrecto();
    }

    private void controlarSiEsCorrecto() {
        //Si el último numero dle jugadodr es diferente al último numero generado
        if (numeroJugador.charAt(numeroJugador.length()-1)!=numeroRecordar.charAt(numeroJugador.length()-1))
        {
            //Creamos un toast de corta duración marcando que perdimos
            Toast.makeText(this,"Perdiste",Toast.LENGTH_LONG).show();
            //Habilitamos el botón de cambiar dificultad
            this.difficultItemMenu.setEnabled(true);
            /*
             * Hacemos desaparecer los botones con una transición de medio segundo y los desactivamos para que no
             * se pueda hacer click
             */
            this.contenedorBotones.animate()
                    .alpha(0f)
                    .setDuration(500)
                    .setListener(new AnimatorListenerAdapter() {
                        @Override
                        public void onAnimationEnd(Animator animation) {
                            desactivarBotones();
                        }
                    });

        }
        else
            /*
             * si la longitud del numero del jugador es igual al de recordar, desactivamos botones, reiniciamos el numero de jugador
             * para la siguiente ronda, agregamos un numero más al numero a recordar, hacemos que la aplicación reproduzca el numero
             * entero y  actualizamos el mensaje de aviso con la nueva longitud
             */
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
        //Si se sale de la aplicación por mucho tiempo y hay un mediaplayer en mp1, liberamos recursos y indicamos mp1 como null
        if (mp1!=null)
        {
            mp1.release();
            mp1=null;
        }
    }
}