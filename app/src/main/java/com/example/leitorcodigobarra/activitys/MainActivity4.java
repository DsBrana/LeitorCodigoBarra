package com.example.leitorcodigobarra.activitys;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.KeyListener;
import android.text.method.Touch;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.leitorcodigobarra.R;

import java.security.Key;

public class MainActivity4 extends AppCompatActivity {
    public EditText et00_M4, et01_M4, et02_M4;
    Button bt00_M4;

    int maxLength = 13;
    String teste, teste1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        et00_M4 = findViewById(R.id.et00_main4);
        et00_M4.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});

        et00_M4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                teste = et00_M4.getText().toString();
                if (teste.length() == 14) {
                    et00_M4.setEnabled(false);

                    et01_M4.setEnabled(true);
                    et01_M4.requestFocus();

                    Toast.makeText(MainActivity4.this, "Valor 1 = \n" + teste, Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }

        });

        et01_M4 = findViewById(R.id.et01_main4);
        et01_M4.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});
        et01_M4.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                teste1 = et01_M4.getText().toString();
                if (teste1.length() == 14) {
                    et01_M4.setEnabled(false);

                    et02_M4.setEnabled(true);
                    et02_M4.requestFocus();
                    Toast.makeText(MainActivity4.this, "Valor 2 = \n" + teste1, Toast.LENGTH_SHORT).show();
                    return true;
                }
                return false;
            }
        });



        et02_M4 = findViewById(R.id.et01_main4);
        et02_M4.setFilters(new InputFilter[]{new InputFilter.LengthFilter(maxLength)});


        bt00_M4 = findViewById(R.id.bt00_main4);
        bt00_M4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity4.this, "valores= \n" + "'" + teste + "', \n" + "'" + teste1 + "'.", Toast.LENGTH_LONG).show();
            }
        });
    }

    KeyListener kl = new KeyListener() {
        @Override
        public int getInputType() {
            return 0;
        }

        @Override
        public boolean onKeyDown(View view, Editable editable, int i, KeyEvent keyEvent) {
            return false;
        }

        @Override
        public boolean onKeyUp(View view, Editable editable, int i, KeyEvent keyEvent) {

            return false;
        }

        @Override
        public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
            return false;
        }

        @Override
        public void clearMetaKeyState(View view, Editable editable, int i) {

        }
    };
}
