package test.com.helper;

import android.app.Application;

import test.com.helper.di.component.AppComponent;
import test.com.helper.di.component.DaggerAppComponent;
import test.com.helper.di.module.AppModule;
import test.com.helper.di.module.NetworkModule;

public class App extends Application {

    private AppComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        mNetComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule("https://jsonplaceholder.typicode.com/"))
                .build();
    }

    public AppComponent getNetComponent() {
        return mNetComponent;
    }
}