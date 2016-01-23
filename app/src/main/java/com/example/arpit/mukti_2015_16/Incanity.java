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

public class Incanity extends Fragment implements View.OnClickListener {
    View view;
    Button b;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.incanity, container, false);
        b=(Button)view.findViewById(R.id.button2);
        b.setOnClickListener(this);
        return  view;
    }

    @Override
    public void onClick(View v) {


        // custom dialog
        final Dialog dialog = new Dialog(getContext(),R.style.cust_dialog);
        dialog.setContentView(R.layout.custom);
        dialog.setTitle("          Co-ordinators");
        dialog.setCanceledOnTouchOutside(false);



        // set the custom dialog components - text, image and button


        Button dialogButton = (Button) dialog.findViewById(R.id.dialogButtonOK);
        // if button is clicked, close the custom dialog
        Button call=(Button)dialog.findViewById(R.id.cbutton);
        call.setText("Arpit Singh");

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:9832821697"));
                startActivity(callIntent);
                dialog.dismiss();

            }
        });

        dialog.show();


    }
}
