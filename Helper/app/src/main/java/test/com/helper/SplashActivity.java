package test.com.helper;

import android.content.Intent;

import javax.inject.Inject;
import test.com.helper.base.BaseActivity;

public class SplashActivity extends BaseActivity  implements SplashView {
    @Inject
    SplashPresenter mSplashPresenter;

    @Override
    protected int getResourceID() {
        return R.layout.splash_layout;
    }

    @Override
    protected void setUp() {
        ((App)getApplication()).getNetComponent().inject(this);
        mSplashPresenter.onAttach(this);
        mSplashPresenter.movetoNextScreen();

    }

    @Override
    protected int containerId() {
        return 0;
    }

    @Override
    public void openActivity() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }
}
