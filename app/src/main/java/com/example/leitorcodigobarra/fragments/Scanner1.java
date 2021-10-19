package com.example.leitorcodigobarra.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.leitorcodigobarra.R;
import com.example.leitorcodigobarra.activitys.MainActivity2;
import com.google.zxing.Result;

import org.xmlpull.v1.XmlPullParser;

import me.dm7.barcodescanner.zxing.ZXingScannerView;

public class Scanner1 extends Fragment implements ZXingScannerView.ResultHandler {
    ZXingScannerView sv00_S1;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        sv00_S1 = new ZXingScannerView(getContext());

        View view = inflater.inflate(R.layout.fragment_scanner1, container, false);
        sv00_S1 = view.findViewById(R.id.sv00_sa1);

        sv00_S1.startCamera();
        sv00_S1.setResultHandler(this::handleResult);

        return view;
    }

    public void handleResult(Result result) {
        if (result != null) {
            sv00_S1.setFocusable (true);
            Toast.makeText(getContext(), "Com: " + result.toString(), Toast.LENGTH_LONG).show();
        }



    }

        private void Voltar() {

        }
    }