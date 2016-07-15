package com.example.sarthak.cathapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URL;

import javax.xml.transform.Result;

public class ResultActivity extends AppCompatActivity {

    WebView wv;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        wv=(WebView)findViewById(R.id.webView);
        wv.getSettings().setJavaScriptEnabled(true);

        Intent i=getIntent();
        if(i.getIntExtra("check",0)==2) {

            wv.setWebViewClient(new WebViewClient() {

                @Override
                public void onPageStarted(WebView view, String url, Bitmap bitmap) {
                    super.onPageStarted(view, url, bitmap);
                    progressDialog = new ProgressDialog(ResultActivity.this);
                    progressDialog.setMessage("Loading...");
                    // progressDialog.setMessage("Please Wait");
                    progressDialog.setCancelable(true);
                    progressDialog.show();

                }

                @Override
                public void onPageFinished(WebView view, String url) {
                    super.onPageFinished(view, url);
                    progressDialog.dismiss();

                }
            });
        }else{
            wv.setWebViewClient(new WebViewClient());
        }


        if(i.getIntExtra("check",0)==1) {
            wv.loadUrl(i.getStringExtra("url"));
        }else if(i.getIntExtra("check",0)==2){
            wv.loadUrl(i.getStringExtra("url"));
        }
        else{
            wv.loadUrl("https://drive.google.com/open?id=19YP21cyzGrvf_IRMdW6VRufiZlBCPKs4bdmopP1S_Ns");
        }

    }

}
