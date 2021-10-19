package com.example.leitorcodigobarra.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.leitorcodigobarra.R;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class ScannerActivity extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    ZXingScannerView sv00_SC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sv00_SC = new ZXingScannerView (this);
        setContentView(sv00_SC);

        Bundle dados = getIntent().getExtras();
        String julio = dados.getString("julio");

        Log.i ("julio", dados.getString("julio"));
    }

    @Override
    protected void onStart() {
        sv00_SC.startCamera();
        sv00_SC.setResultHandler (this);
        super.onStart();
    }

    @Override
    protected void onStop() {
        sv00_SC.stopCamera();
        super.onStop();
    }

    @Override
    public void handleResult(Result result) {
            String momento = result.toString();
            Log.i("LOG", momento);

    }

    private void Voltar () {
        Intent voltar = new Intent(getApplicationContext(), MainActivity2.class);
        startActivity (voltar);
        finish();
    }
}