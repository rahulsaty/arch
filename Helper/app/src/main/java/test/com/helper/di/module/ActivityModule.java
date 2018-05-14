package test.com.helper.di.module;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import test.com.helper.ImageModel;
import test.com.helper.ImagePresenter;
import test.com.helper.MainModel;
import test.com.helper.MainPresenter;
import test.com.helper.SplashPresenter;
import test.com.helper.ui.RatingDialogPresenter;

@Module
public class ActivityModule {


    @Provides
    SplashPresenter provideSplashPresenter() {
        return new SplashPresenter();
    }

    @Provides
    MainPresenter provideMainPresenter(MainModel mainModel) {
        return new MainPresenter(mainModel);
    }
    @Provides
    ImagePresenter provideImagePresenter(ImageModel mainModel) {
        return new ImagePresenter(mainModel);
    }

    @Provides
    MainModel provideMainModel( Retrofit retrofit) {
        return new MainModel(retrofit);
    }
    @Provides
    RatingDialogPresenter provideRatingDialogPresenter() {
        return new RatingDialogPresenter();
    }


}
