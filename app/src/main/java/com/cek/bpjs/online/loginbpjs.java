package com.cek.bpjs.online;
import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class loginbpjs extends Activity
{
    WebView WebSiteView;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginbpjs);

        WebSiteView = (WebView)findViewById(R.id.webViewku1);
        WebSettings webSetting = WebSiteView.getSettings();

        webSetting.setJavaScriptEnabled(true);

        WebSiteView.getSettings().setLoadWithOverviewMode(true);
        WebSiteView.getSettings().setUseWideViewPort(true);
        String userAgent = "Mozilla/5.0 (X11; U; Linux i686; en-US; rv:1.9.0.4) Gecko/20100101 Firefox/4.0";
        WebSiteView.getSettings().setUserAgentString(userAgent);

        WebSiteView.setWebViewClient(new WebViewClient());

        WebSiteView.loadUrl("https://sso.bpjsketenagakerjaan.go.id/login.bpjs");
    }

    private class WebViewClient extends android.webkit.WebViewClient
    {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url)
        {
            return super.shouldOverrideUrlLoading(view, url);
        }
    }

}
