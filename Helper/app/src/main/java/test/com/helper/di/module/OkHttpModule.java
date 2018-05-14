package test.com.helper.di.module;

import android.support.annotation.NonNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import test.com.helper.BuildConfig;
import timber.log.Timber;

/**
 * Created by santiago on 31/08/15.
 */
@Module
public class OkHttpModule {

  @Provides
  @Singleton
  OkHttpClient provideServiceOkHttpClient(OkHttpClient.Builder clientBuilder
                                          ) {

//    addLoggingInterceptor(clientBuilder);

    return clientBuilder.build();
  }


  @Provides
  OkHttpClient.Builder provideOkHttpClientBuilder() {
    return new OkHttpClient.Builder();
  }







  private void addLoggingInterceptor(@NonNull OkHttpClient.Builder clientBuilder) {
    if (BuildConfig.DEBUG ) {
      HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(message -> Timber.tag("OkHttp").d(message));
      loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
      clientBuilder.addInterceptor(loggingInterceptor);
    }
  }


}
