package com.example.arpit.mukti_2015_16;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Namit extends Fragment implements View.OnClickListener {
    View view;
    Button b;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.namit, container, false);
        b=(Button)view.findViewById(R.id.button1);
        b.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onClick(View v) {



        Intent callIntent = new Intent(Intent.ACTION_CALL);
        callIntent.setData(Uri.parse("tel:9804022350"));
        startActivity(callIntent);


    }

}

