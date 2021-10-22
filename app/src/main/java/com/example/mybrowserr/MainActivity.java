package com.example.mybrowserr;

import static com.example.mybrowserr.R.menu.menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnGo;
    WebView webview;
    EditText txtAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAddress = findViewById(R.id.txtAddress);
        webview = findViewById(R.id.webview);
        webview.setWebViewClient(new WebViewClient());


        //////////
        if (getIntent() != null && getIntent().getData() != null){
            txtAddress.setText(getIntent().getData().toString());
            webview.loadUrl(getIntent().getData().toString());
        }
        //////////
        btnGo = findViewById(R.id.btnGo);
        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                webview.loadUrl("http://" + txtAddress.getText());
            }
        });





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }
}