package com.example.leitorcodigobarra.activitys;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.leitorcodigobarra.R;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.BeepManager;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.BarcodeView;
import com.journeyapps.barcodescanner.DecoratedBarcodeView;
import com.journeyapps.barcodescanner.DefaultDecoderFactory;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {
    Button bt00_M3, bt01_M3;
    int flag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        bt00_M3 = findViewById(R.id.bt00_main3);
        bt00_M3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = 1;
                IntentIntegrator scanner = new IntentIntegrator(MainActivity3.this);
                scanner.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                scanner.setBeepEnabled(false);
                scanner.initiateScan();
            }
        });

        bt01_M3 = findViewById(R.id.bt01_main3);
        bt01_M3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                flag = 2;
                IntentIntegrator scanner = new IntentIntegrator(MainActivity3.this);
                scanner.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES);
                scanner.setBeepEnabled(false);
                scanner.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (resultCode == Activity.RESULT_OK) {
            IntentResult ir = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
            if (ir != null) {
                if (ir.getContents() == null) {
                    Log.i ("LOG", "Cancelado");
                } else {
                    if (flag == 1) {
                        Log.i("LOG", "Flag 1: " + ir.getContents());
                        bt00_M3.setText(ir.getContents());
                        bt00_M3.setEnabled(false);
                    } else if (flag == 2) {
                        Log.i("LOG", "Flag 2: " + ir.getContents());
                        bt01_M3.setText(ir.getContents());
                        bt01_M3.setEnabled(false);
                    }
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data);
            }

        }
    }
}
