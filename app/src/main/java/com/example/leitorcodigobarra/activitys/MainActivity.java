package com.example.leitorcodigobarra.activitys;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.leitorcodigobarra.R;
import com.google.zxing.Result;

import java.util.List;

import me.dm7.barcodescanner.core.CameraUtils;
import me.dm7.barcodescanner.zxing.ZXingScannerView;
import pub.devrel.easypermissions.EasyPermissions;
import pub.devrel.easypermissions.PermissionRequest;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks, ZXingScannerView.ResultHandler {
    int REQUEST_CODE_CAMERA = 190;

    ZXingScannerView sv00_M;
    Button bt00_M, bt01_M;

    String momento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sv00_M = findViewById (R.id.sv00_main);

        bt00_M = findViewById (R.id.bt00_main);
        bt00_M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CameraOn();

                Log.i ("BOTOES", "Opção 01");
            }
        });

        bt01_M = findViewById (R.id.bt01_main);
        bt01_M.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.i ("BOTOES", "Opção 02");

                //CameraOn();
            }
        });

        Permissao();

    }

    private void CameraOn() {
        sv00_M.startCamera();
        sv00_M.setAutoFocus(true);
        sv00_M.setResultHandler(this);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {     }

    private void Permissao() {
        EasyPermissions.requestPermissions (new PermissionRequest.Builder(this, REQUEST_CODE_CAMERA, Manifest.permission.CAMERA)
                .setRationale ("A permissão é necessária para este aplicativo")
        .setPositiveButtonText ("Sim")
        .setNegativeButtonText ("Não")
        .build() );
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {    }


    public void handleResult(Result result) {
        if (result == null) {
            Log.i("LOG", "Vazio!");
        } else {
            String teste = result.toString();
            Log.i("LOG", "Teste: " + teste);

        }

        }

    @Override
    protected void onStop() {
        sv00_M.stopCamera();
        sv00_M.setResultHandler(this);

        Camera camera = CameraUtils.getCameraInstance();
        if (camera != null) {
            camera.release();
        }

        super.onStop();
    }
}