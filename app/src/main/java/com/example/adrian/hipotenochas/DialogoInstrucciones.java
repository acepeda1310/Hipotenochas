package com.example.adrian.hipotenochas;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

/**
 * Created by Adrian on 20/11/2015.
 */
public class DialogoInstrucciones extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());

        builder.setMessage("Pulse sobre los botones para despejar una posición sin minas, o bien mantenga pulsado para señalar una. Los números indican las minas que tocan a su botón");
        builder.setTitle("Instrucciones");
        builder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        return builder.create();
    }

}
