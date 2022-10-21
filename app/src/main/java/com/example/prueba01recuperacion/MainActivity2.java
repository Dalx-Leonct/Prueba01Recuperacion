package com.example.prueba01recuperacion;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {
    WebView webView;
    Button cerrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        cerrar = (Button) findViewById(R.id.buttonCerrar);
        webView= (WebView) findViewById(R.id.webview);

        String url = getIntent().getStringExtra("web");

        webView.setWebViewClient(new WebViewClient());

        webView.loadUrl("http://"+ url);

        cerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cerrar();
            }
        });
    }


    public void cerrar(){
        finish();
    }

}