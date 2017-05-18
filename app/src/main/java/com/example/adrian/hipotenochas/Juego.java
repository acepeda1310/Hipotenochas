package com.example.adrian.hipotenochas;

import java.util.Random;

/**
 * Created by Adrian on 01/12/2015.
 */
public class Juego {

    int lado;
    int minas;
    Casilla[][] tablero;
    public int banderas=0;
    public int botonesUsados=0;

    Juego(int lado, int minas){
        this.lado=lado;
        this.minas=minas;
        crear();
    }

    private void crear(){
        tablero=new Casilla[lado][lado];
        for(int i=0; i<lado; i++){
            for(int j=0; j<lado; j++){
                tablero[i][j]=new Casilla();
            }
        }
        for(int i=0; i<minas; i++){
            int x=(int)(Math.random()*lado);
            int y=(int)(Math.random()*lado);
            if(tablero[x][y].getHipotenocha()){
                i--;
            } else{
                tablero[x][y].setHipotenocha();
            }
        }
        for(int i=0; i<lado; i++){
            for(int j=0; j<lado; j++){
                establecerColindantes(i,j);
            }
        }
    }

    public void establecerColindantes(int i, int j){
        int colindantes=0;
        try{
            if(tablero[i-1][j-1].getHipotenocha())
                colindantes++;
        } catch(Exception ignored){}
        try{
            if(tablero[i-1][j].getHipotenocha())
                colindantes++;
        } catch(Exception ignored){}
        try{
            if(tablero[i-1][j+1].getHipotenocha())
                colindantes++;
        } catch(Exception ignored){}
        try{
            if(tablero[i][j-1].getHipotenocha())
                colindantes++;
        } catch(Exception ignored){}
        try{
            if(tablero[i][j+1].getHipotenocha())
                colindantes++;
        } catch(Exception ignored){}
        try{
            if(tablero[i+1][j-1].getHipotenocha())
                colindantes++;
        } catch(Exception ignored){}
        try{
            if(tablero[i+1][j].getHipotenocha())
                colindantes++;
        } catch(Exception ignored){}
        try{
            if(tablero[i+1][j+1].getHipotenocha())
                colindantes++;
        } catch(Exception ignored){}
        tablero[i][j].setColindantes(colindantes);
    }

    public int getColindantes(int i, int j){
        return tablero[i][j].getColindantes();
    }

    public boolean getHipotenocha(int i, int j) {
        return tablero[i][j].getHipotenocha();
    }

}
