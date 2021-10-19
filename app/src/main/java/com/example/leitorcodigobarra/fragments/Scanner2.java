package com.example.leitorcodigobarra.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.leitorcodigobarra.R;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Scanner2 extends Fragment {
    ZXingScannerView sv00_S2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_scanner2, container, false);
        sv00_S2 = view.findViewById (R.id.sv00_sa2);
        return view;
    }

    @Override
    public void onStart() {
        sv00_S2.startCamera();
        sv00_S2.setResultHandler(this::handleResult2);
        super.onStart();
    }

    @Override
    public void onPause() {
        sv00_S2.stopCamera();
        super.onPause();
    }

    public void handleResult2(Result result2) {
        Log.i ("LOG_S2", result2.toString());
    }
}