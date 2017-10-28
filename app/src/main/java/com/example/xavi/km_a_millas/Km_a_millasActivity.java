package com.example.xavi.km_a_millas;

import android.content.DialogInterface;
import android.net.sip.SipAudioCall;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Km_a_millasActivity extends AppCompatActivity {

    private String valor_km;
    private String valor_millas;
    private float km;
    private float millas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_km_a_millas);

        final EditText edit_txt_km = (EditText) findViewById(R.id.edit_txt_km);
        final EditText edit_txt_millas = (EditText) findViewById(R.id.edit_txt_millas);
        Button btn_acabar = (Button)findViewById(R.id.btn_acabar);


        edit_txt_km.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                valor_km = edit_txt_km.getText().toString();
                km = Float.parseFloat(valor_km);
                millas = km / 1.609344f;
                valor_millas = String.format("%f", millas);
                edit_txt_millas.setText(valor_millas);
                return false;
            }
        });
        edit_txt_millas.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                valor_millas = edit_txt_millas.getText().toString();
                millas = Float.parseFloat(valor_millas);
                km = millas * 1.609344f;
                valor_km = String.format("%f", km);
                edit_txt_km.setText(valor_km);

                return false;
            }
        });

        btn_acabar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Km_a_millasActivity.this);
                builder.setTitle(R.string.acabar);
                builder.setMessage(R.string.confirmacion);
                builder.setPositiveButton(R.string.acabar, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast toast = Toast.makeText(Km_a_millasActivity.this,
                                R.string.broma,
                                Toast.LENGTH_LONG);
                        toast.show();
                    }
                });
                builder.setNegativeButton(android.R.string.cancel, null);
                builder.create().show();

            }
        });
    }
}