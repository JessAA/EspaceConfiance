package com.example.usrmac_0238.mytf1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by usrmac-0238 on 24/07/2017.
 */

public class WebviewActivity extends Activity {

    private WebView webview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        webview = findViewById(R.id.webview);

        WebSettings settings = webview.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        webview.loadUrl(getString(R.string.tv_url_espace_de_confiance));
        webview.setWebViewClient(new MyWebClient());

        /*webview.setWebViewClient(new MyWebClient());


        webview.getSettings().setJavaScriptEnabled(true);
        webview.loadUrl(getString(R.string.tv_url_espace_de_confiance));*/
    }

    public class MyWebClient extends WebViewClient{

        @Override
        public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);
            handler.proceed();
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }

    }


}
