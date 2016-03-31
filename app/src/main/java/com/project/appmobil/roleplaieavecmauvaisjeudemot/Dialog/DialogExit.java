package com.project.appmobil.roleplaieavecmauvaisjeudemot.Dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;

/**
 *
 * Created by ZHOU Eric on 12/02/2016.
 */
public class DialogExit extends DialogFragment {

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {

		AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());


		dialog.setTitle(R.string.exit);

		dialog.setMessage(R.string.exit_confirm);

		dialog.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				getActivity().finish();
			}
		});

		dialog.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {

			}
		});

		return dialog.create();

	}
}
