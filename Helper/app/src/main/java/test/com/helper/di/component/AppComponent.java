package test.com.helper.di.component;

import javax.inject.Singleton;

import dagger.Component;
import test.com.helper.ImageFragment;
import test.com.helper.MainActivity;
import test.com.helper.SplashActivity;
import test.com.helper.base.BaseActivity;
import test.com.helper.base.BaseDialog;
import test.com.helper.base.BaseFragment;
import test.com.helper.di.module.ActivityModule;
import test.com.helper.di.module.AppModule;
import test.com.helper.di.module.NetworkModule;
import test.com.helper.di.module.OkHttpModule;
import test.com.helper.di.module.SharedPrefModule;
import test.com.helper.ui.RateUsDialog;

@Singleton
@Component(modules = {
        AppModule.class, NetworkModule.class, OkHttpModule.class,
        SharedPrefModule.class,
        ActivityModule.class
})
public interface AppComponent {

    void inject(SplashActivity splashActivity);
    void inject(MainActivity mainActivity);
    void inject(BaseActivity baseActivity);
    void inject(BaseFragment baseFragment);
    void inject(BaseDialog baseDialog);
    void inject(ImageFragment imageFragment);
    void inject(RateUsDialog rateUsDialog);

}
