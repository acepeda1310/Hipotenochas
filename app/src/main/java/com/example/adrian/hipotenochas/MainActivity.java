package com.example.adrian.hipotenochas;

import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

public class MainActivity extends AppCompatActivity {

    private static int dificultad = 0;
    public static Boton[][] buttonArray;
    public static Juego juego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Boton.seguimos=true;
        try {
            Bundle bundle = getIntent().getExtras();
            dificultad = bundle.getInt("dif");
        } catch (Exception ignored) {
        }
        int hipotenochas = 0;
        for (int i = 0; i <= dificultad; i++) {
            hipotenochas += (i+1);
        }
        juego = new Juego((4 + dificultad) * 2, hipotenochas * 10);
        generarBotones((4 + dificultad) * 2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Instrucciones: {
                FragmentManager fragmentManager = getFragmentManager();
                DialogoInstrucciones dialogo = new DialogoInstrucciones();
                dialogo.show(fragmentManager, "Instrucciones");
                break;
            }
            case R.id.Nuevo: {
                Intent intent = new Intent(this, MainActivity.class);
                intent.putExtra("dif", dificultad);
                finish();
                startActivity(intent);
                break;
            }
            case R.id.Configuracion: {
                FragmentManager fragmentManager = getFragmentManager();
                DialogoConfiguracion dialogo = new DialogoConfiguracion();
                dialogo.show(fragmentManager, "Configuración");
                break;
            }

        }
        return true;
    }

    public void generarBotones(int lado) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.grid);
        buttonArray = new Boton[lado][lado];
        TableLayout table = new TableLayout(this);
        for (int row = 0; row < lado; row++) {
            TableRow currentRow = new TableRow(this);
            for (int button = 0; button < lado; button++) {
                buttonArray[row][button] = new Boton(this, juego.tablero, row, button);
                TableRow.LayoutParams parametros=new TableRow.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,1);
                parametros.setMargins(0,0,0,0);
                buttonArray[row][button].setLayoutParams(parametros);
                currentRow.addView(buttonArray[row][button]);
            }
            table.addView(currentRow);
        }
        layout.addView(table);
    }

}
