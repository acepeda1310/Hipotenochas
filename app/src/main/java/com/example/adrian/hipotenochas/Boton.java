package com.example.adrian.hipotenochas;

import android.content.Context;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Adrian on 01/12/2015.
 */
public class Boton extends ImageView implements View.OnClickListener, View.OnLongClickListener {

    Casilla[][] tablero;
    int i, j;
    boolean sinUsar = true;
    public static boolean seguimos=true;

    public Boton(Context context) {
        super(context);
    }

    public Boton(Context context, Casilla[][] tablero, int i, int j) {
        super(context);
        this.tablero = tablero;
        this.i = i;
        this.j = j;
        this.setImageResource(R.drawable.sinusar);
        this.setOnClickListener(this);
        this.setOnLongClickListener(this);
    }

    public void descubrirHipotenochas() {
        for (int x = 0; x < tablero.length; x++) {
            for (int y = 0; y < tablero.length; y++) {
                if (tablero[x][y].getHipotenocha() && !(x == i && y == j)) {
                    MainActivity.buttonArray[x][y].setImageResource(R.drawable.mina);
                }
            }
        }
    }


    @Override
    public void onClick(View v) {
        if (tablero[i][j].getHipotenocha() & !tablero[i][j].getMarcada()) {
            setImageResource(R.drawable.minadetonada);
            this.setEnabled(false);
            descubrirHipotenochas();
            seguimos=false;
            Toast.makeText(getContext(), "Perdiste!", Toast.LENGTH_SHORT).show();
        } else if (!tablero[i][j].getMarcada()) {
            try {
                comprobar(i, j);
            } catch (Exception ignored) {
            }
        }
    }

    public void comprobar(int x, int y) throws Exception {
        if (sinUsar & !tablero[x][y].getMarcada()&seguimos) {
            if (!tablero[x][y].getHipotenocha()) {
                sinUsar = false;
                this.setEnabled(false);
                MainActivity.juego.botonesUsados++;

                switch (tablero[x][y].getColindantes()) {
                    case 0:
                        setImageResource(R.drawable.vacio);
                        try {
                            MainActivity.buttonArray[x - 1][y].comprobar(x - 1, y);
                        } catch (Exception ignored) {
                        }
                        try {
                            MainActivity.buttonArray[x][y - 1].comprobar(x, y - 1);
                        } catch (Exception ignored) {
                        }
                        try {
                            MainActivity.buttonArray[x][y + 1].comprobar(x, y + 1);
                        } catch (Exception ignored) {
                        }
                        try {
                            MainActivity.buttonArray[x + 1][y].comprobar(x + 1, y);
                        } catch (Exception ignored) {
                        }
                        try {
                            MainActivity.buttonArray[x - 1][y+1].comprobar(x - 1, y+1);
                        } catch (Exception ignored) {
                        }
                        try {
                            MainActivity.buttonArray[x-1][y - 1].comprobar(x-1, y - 1);
                        } catch (Exception ignored) {
                        }
                        try {
                            MainActivity.buttonArray[x+1][y + 1].comprobar(x+1, y + 1);
                        } catch (Exception ignored) {
                        }
                        try {
                            MainActivity.buttonArray[x + 1][y-1].comprobar(x + 1, y-1);
                        } catch (Exception ignored) {
                        }
                        break;
                    case 1:
                        setImageResource(R.drawable.n1);
                        break;
                    case 2:
                        setImageResource(R.drawable.n2);
                        break;
                    case 3:
                        setImageResource(R.drawable.n3);
                        break;
                    case 4:
                        setImageResource(R.drawable.n4);
                        break;
                    case 5:
                        setImageResource(R.drawable.n5);
                        break;
                    case 6:
                        setImageResource(R.drawable.n6);
                        break;
                    case 7:
                        setImageResource(R.drawable.n7);
                        break;
                    case 8:
                        setImageResource(R.drawable.n8);
                        break;
                }
                if (MainActivity.juego.botonesUsados == ((MainActivity.juego.lado * MainActivity.juego.lado) - MainActivity.juego.minas)) {
                    seguimos = false;
                    Toast.makeText(getContext(), "Ganaste!", Toast.LENGTH_SHORT).show();
                }
            }
        }

    }


    @Override
    public boolean onLongClick(View v) {
        if (tablero[i][j].getMarcada()) {
            tablero[i][j].setMarcada(false);
            setImageResource(R.drawable.sinusar);
            MainActivity.juego.banderas--;
        } else {
            tablero[i][j].setMarcada(true);
            setImageResource(R.drawable.bandera);
            MainActivity.juego.banderas++;
        }
        return false;
    }
}
