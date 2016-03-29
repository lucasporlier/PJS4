package com.project.appmobil.roleplaieavecmauvaisjeudemot.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;



/**
 * Created by qu2 on 29/03/2016.
 */


    public class AlertDFragment extends DialogFragment {
        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            return new AlertDialog.Builder(getActivity())
                            // Set Dialog Title
                    .setTitle("Use Item")
                            // Set Dialog Message
                    .setMessage("How much ? ")

                            // Positive button
                    .setPositiveButton("Use", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })

                            // Negative Button
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,	int which) {

                        }
                    }).create();
        }
    }

