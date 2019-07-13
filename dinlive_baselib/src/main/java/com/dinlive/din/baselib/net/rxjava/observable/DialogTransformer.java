package com.dinlive.din.baselib.net.rxjava.observable;

import android.content.Context;
import android.content.DialogInterface;

import com.android.tu.loadingdialog.LoadingDialog;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * Created by superman on 2018/6/20.
 */
public class DialogTransformer {
    private Context context;
    private static String msg = "数据加载中...";
    private boolean cancelable;

    public DialogTransformer(Context context) {
        this(context, msg);
    }

    public DialogTransformer(Context context, String msg) {
        this(context, msg, false);
    }

    public DialogTransformer(Context context, String msg, boolean cancelable) {
        this.context = context;
        this.msg = msg;
        this.cancelable = cancelable;
    }

    public <T> ObservableTransformer<T, T> showDialog() {
        return new ObservableTransformer<T, T>() {
            LoadingDialog.Builder builder = new LoadingDialog.Builder(context)
                    .setMessage(msg)
                    .setCancelable(false);
            private LoadingDialog dialog = builder.create();

            @Override
            public ObservableSource<T> apply(final Observable<T> upstream) {

                return upstream.doOnSubscribe(new Consumer<Disposable>() {
                    @Override
                    public void accept(@NonNull final Disposable disposable) throws Exception {
                        dialog = builder.create();
                        dialog.show();
                        if (cancelable) {
                            dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                                @Override
                                public void onCancel(DialogInterface dialog) {
                                    disposable.dispose();
                                    dialog.dismiss();
                                }
                            });
                        }
                    }
                }).doOnTerminate(new Action() {
                    @Override
                    public void run() throws Exception {
                        if (dialog.isShowing()) {
                            dialog.dismiss();
                        }
                    }
                });
            }
        };
    }
}
