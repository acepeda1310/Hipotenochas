package com.example.adrian.hipotenochas;

/**
 * Created by Adrian on 01/12/2015.
 */
public class Casilla {
    int colindantes=0;
    boolean hipotenocha=false;
    boolean marcada=false;

    public void setHipotenocha(){
        hipotenocha=true;
    }

    public void setMarcada(boolean marcada){
        this.marcada=marcada;
    }

    public void setColindantes(int colindantes){
        this.colindantes=colindantes;
    }

    public int getColindantes(){
        return colindantes;
    }

    public boolean getHipotenocha(){
        return hipotenocha;
    }

    public boolean getMarcada(){
        return marcada;
    }

}
