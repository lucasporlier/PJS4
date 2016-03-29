package com.project.appmobil.roleplaieavecmauvaisjeudemot.Dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;

import com.project.appmobil.roleplaieavecmauvaisjeudemot.R;

/**
 * Created by qu2 on 29/03/2016.
 */
public class DialogUseItem extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_use_object, container, false);
        getDialog().setTitle("Use Item");

        return rootView;
    }
}