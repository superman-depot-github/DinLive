package com.dinlive.din.baselib.base;

import android.content.Intent;
import android.support.annotation.ColorInt;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.dinlive.din.baselib.R;
import com.dinlive.din.baselib.R2;
import com.dinlive.din.baselib.utils.ARouterHub;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.just.agentweb.AgentWeb;
import com.just.agentweb.MiddlewareWebChromeBase;
import com.just.agentweb.MiddlewareWebClientBase;
import com.just.agentweb.WebChromeClient;
import com.just.agentweb.WebViewClient;

import butterknife.BindView;

@Route(path = ARouterHub.BASE_FRAGMENT_AGENTWEB, name = "AgentWeb_Fragment界面")
public class AgentWebFragment extends BaseFragment {
    @Autowired(name = "Url", desc = "链接")
    public String Url;
    @Autowired(name = "hideShare", desc = "是否开启分享")
    public boolean hideShare;
    @BindView(R2.id.fl_web)
    FrameLayout fl_web;
    @BindView(R2.id.bar_title)
    TextView bar_title;
    protected AgentWeb mAgentWeb;
    protected BridgeWebView bridgeWebView;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_web;
    }

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    protected void initView(View mRootView) {
        mAgentWeb = AgentWeb.with(this)
                .setAgentWebParent(fl_web, new ViewGroup.LayoutParams(-1, -1))
                .useDefaultIndicator(getIndicatorColor(), getIndicatorHeight())
                .setWebViewClient(getWebViewClient())
                .setWebChromeClient(getWebChromeClient())
                .useMiddlewareWebChrome(getMiddleWareWebChrome())
                .useMiddlewareWebClient(getMiddleWareWebClient())
                .setWebView(createJsBridgeWebView())
                .setSecurityType(AgentWeb.SecurityType.DEFAULT_CHECK)
                .createAgentWeb()
                .ready()
                .go(Url);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
    }


    protected @ColorInt
    int getIndicatorColor() {
        return -1;
    }

    protected int getIndicatorHeight() {
        return -1;
    }

    protected WebViewClient getWebViewClient() {
        return null;
    }

    protected WebChromeClient getWebChromeClient() {
        return new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
                super.onReceivedTitle(view, title);
                bar_title.setText(title);
            }
        };
    }

    protected MiddlewareWebChromeBase getMiddleWareWebChrome() {
        return new MiddlewareWebChromeBase() {
        };
    }

    protected MiddlewareWebClientBase getMiddleWareWebClient() {
        return new MiddlewareWebClientBase() {
        };
    }

    private BridgeWebView createJsBridgeWebView() {
        if (bridgeWebView == null) {
            bridgeWebView = new BridgeWebView(getActivity());
        }
        WebSettings webSettings = bridgeWebView.getSettings();
        webSettings.setUserAgentString(webSettings.getUserAgentString() + " safety");
        bridgeWebView.registerHandler("goback", (data, function) -> {
            function.onCallBack("success");
            getActivity().finish();
        });
        syncCookie();
        return bridgeWebView;
    }

    protected void syncCookie() {
//        String token = LoginUser.getInstance().getToken();
//        if (token != null && !token.isEmpty()) {
//            AgentWebConfig.syncCookie("http://sc.staq360.com", "token=" + token);
//        } else {
//            AgentWebConfig.removeAllCookies();
//        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }

    public static AgentWebFragment newInstance(String url, boolean hideShare) {
        return (AgentWebFragment) ARouter.getInstance()
                .build(ARouterHub.BASE_FRAGMENT_AGENTWEB)
                .withString("Url", url)
                .withBoolean("hideShare", hideShare)
                .navigation();
    }
}
