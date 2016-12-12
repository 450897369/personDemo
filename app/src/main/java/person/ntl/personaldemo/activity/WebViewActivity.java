package person.ntl.personaldemo.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import java.util.HashMap;
import java.util.Map;

import person.ntl.personaldemo.R;

public class WebViewActivity extends Activity {

    WebView webView;
    String url;
    Map map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = (WebView) findViewById(R.id.webview);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setUseWideViewPort(false);
        settings.setLoadWithOverviewMode(false);
        settings.setSupportZoom(false);
        settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
        settings.setDomStorageEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setAppCacheMaxSize(1024*1024*8);
        String appCachePath = this.getApplicationContext().getCacheDir().getAbsolutePath();
        settings.setAppCachePath(appCachePath);
        settings.setAllowFileAccess(true);
        settings.setSavePassword(false);
        if (Build.VERSION.SDK_INT >= 16) {
            settings.setAllowFileAccessFromFileURLs(true);
            settings.setAllowUniversalAccessFromFileURLs(true);
        }
//        settings.setUserAgentString(settings.getUserAgentString() + " Jz Imaster Android V" + AppUtils.getVersionCode(getContext()));
        webView.removeJavascriptInterface("searchBoxJavaBridge_");
        webView.removeJavascriptInterface("accessibility");
        webView.removeJavascriptInterface("accessibilityTraversal");
        webView.clearCache(true);

//        webView.addJavascriptInterface(getHtmlObject(), SyncStateContract.Constants.h5key);
//        token = MyApplication.token;
        map = new HashMap<>();
        url = "http://test.dev.honglingjinclub.com/web/index.html#/static/myAccount?token=n5SlfZ6GEyFZagmu9cf82TkwNjFhYzdiNWFiNjhiN2JiZDhmNjYwZTc0N2UzZmNjN2JkZDM3MDE1YTA0YjlkNTI5ZGQ4ZjU4NmM4M2FlNTQl6XhMPKLWFbDDp9-o18jp7_OTIwWMd76rn0od471yEgf3fvhv0npfXbvunuj1fqr1691hzCqhkt9hfgcEJxFHXPUWi9_Tiaah71fABjFe9xoKwuADD3Thizjrwy5tRg-jSPBiKC4MtGcGKYA7HCUw";
        map.put("token", "n5SlfZ6GEyFZagmu9cf82TkwNjFhYzdiNWFiNjhiN2JiZDhmNjYwZTc0N2UzZmNjN2JkZDM3MDE1YTA0YjlkNTI5ZGQ4ZjU4NmM4M2FlNTQl6XhMPKLWFbDDp9-o18jp7_OTIwWMd76rn0od471yEgf3fvhv0npfXbvunuj1fqr1691hzCqhkt9hfgcEJxFHXPUWi9_Tiaah71fABjFe9xoKwuADD3Thizjrwy5tRg-jSPBiKC4MtGcGKYA7HCUw");
        webView.loadUrl(url);
        webView.setWebViewClient(new WebViewClient(){
            @Override
            public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
                Map<String, String> requestHeaders = null;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    requestHeaders = request.getRequestHeaders();
                }
                requestHeaders.put("token","abcdefg");
                return super.shouldInterceptRequest(view, request);
            }
        });
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public void onReceivedTitle(WebView view, String title) {
                setTitle(title);
                super.onReceivedTitle(view, title);
            }
        });


        Button button = (Button) findViewById(R.id.btn_refresh);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.reload();
            }
        });
    }

}
