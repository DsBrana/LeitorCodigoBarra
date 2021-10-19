package com.example.leitorcodigobarra.helpers;


import android.content.Context;
import android.util.Log;

import com.example.leitorcodigobarra.activitys.MainActivity2;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public final class LeituraBarra  implements ZXingScannerView.ResultHandler{

    public Boolean coletaVar(ZXingScannerView sv, Context context) {
        if (sv != null) {
            sv.startCamera();
            sv.setFocusable(true);
            sv.setResultHandler(this);
            return true;
        } else {
            Log.i ("LOGIF", "Vazio!");
            return false;
        }
    }

    @Override
    public void handleResult(Result result) {
        Log.i ("LOG", result.toString());
    }


}
