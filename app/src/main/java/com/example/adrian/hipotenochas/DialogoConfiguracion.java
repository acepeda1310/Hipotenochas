package com.example.adrian.hipotenochas;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Adrian on 20/11/2015.
 */
public class DialogoConfiguracion extends DialogFragment {



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        String[] lista={"Fácil","Medio","Difícil"};
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        builder.setTitle("Configuración");
        builder.setSingleChoiceItems(lista,0,new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialogo, int item){
                Intent intent=new Intent(getActivity(),MainActivity.class);
                intent.putExtra("dif", item);
                startActivity(intent);
            }
        });
        return builder.create();
    }

}
