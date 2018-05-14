package test.com.helper;

import android.os.Handler;

import test.com.helper.base.BasePresenter;

public class SplashPresenter<V extends SplashView> extends BasePresenter<V> {



    void movetoNextScreen(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getMvpView().openActivity();
            }
        },5000);
    }
}
