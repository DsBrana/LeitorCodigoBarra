package com.example.leitorcodigobarra.activitys;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

import com.example.leitorcodigobarra.R;
import com.example.leitorcodigobarra.fragments.Scanner1;
import com.example.leitorcodigobarra.helpers.LeituraBarra;
import com.google.zxing.Result;

import java.util.Locale;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class MainActivity2 extends AppCompatActivity implements ZXingScannerView.ResultHandler {
    Button bt00_M2, bt01_M2;
    ZXingScannerView sv00_MA2;

    //Scanner1 fr1 = new Scanner1();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        sv00_MA2 = findViewById(R.id.sv00_ma2);

        bt00_M2 = findViewById(R.id.bt00_main2);
        bt00_M2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ScannerActivity();
                //FragmenteScanner1();
                //AlertReaderBar();
                LeituraBarra();
            }

        });

        bt01_M2 = findViewById(R.id.bt01_main2);
        bt01_M2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //ScannerActivity();
                //FragmenteScanner1();
                //AlertReaderBar();
                LeituraBarra();
            }
        });
   }

   private void LeituraBarra() {
       sv00_MA2.startCamera();
       sv00_MA2.setFocusable (true);
        sv00_MA2.setResultHandler(this);
   }

   private void ScannerActivity() {
       Intent scanner = new Intent(MainActivity2.this, ScannerActivity.class);
       scanner.putExtra("julio", "Funciona (MA2 para SCAN)");
       startActivity (scanner);
       finish();
   }

    @Override
    public void handleResult(Result result) {
        if (result == null) {
            Log.i("LOG", "Vazio!");
        } else {
            Log.i("LOG", "Cheio");
        }
    }

    @Override
    protected void onResume() {

        super.onResume();
    }

    @Override
    protected void onPause() {
        sv00_MA2.stopCamera();
        super.onPause();
    }

    /*
   private void FragmenteScanner1() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add (R.id.fr00_main2, fr1);
        ft.commit();
   }
*/

/*
   private void AlertReaderBar() {
       AlertDialog.Builder reader = new AlertDialog.Builder(this);
       LayoutInflater telaReader = this.getLayoutInflater();
       View visao = telaReader.inflate(R.layout.dialog_reader, null);
       reader.setView(visao);

       ZXingScannerView sv00_LD = visao.findViewById (R.id.sv00_ld);
       sv00_LD.startCamera();

       LeituraBarra rb = new LeituraBarra();
       rb.coletaVar(sv00_LD, getApplicationContext());

       reader.create();
       reader.show();
 */
}