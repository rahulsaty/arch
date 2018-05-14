package test.com.helper;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import test.com.helper.base.BaseModel;
import test.com.helper.base.BaseModelListener;
import test.com.helper.pojo.Album;
import test.com.helper.service.ApiService;

public class ImageModel extends BaseModel<ImageModel.Callback> {
    Retrofit retrofit;

    Callback callback;

    @Inject
    public ImageModel(Retrofit retrofit) {
        super();
        this.retrofit = retrofit;
    }

    public void setListener(Callback callback){
        this.callback = callback;
    }


    public void loadData() {
        Observable<List<Album>> data = retrofit.create(ApiService.class).getPhotos();

        data.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResults, this::handleError);
    }

    private void handleResults(List<Album> users) {
        if (users != null) {
            callback.onSuccess(users);
        } else {
            callback.onError(new Exception("NOt found"));
        }
    }

    private void handleError(Throwable t) {
        Log.e("Observer", "" + t.toString());
        callback.onError(t);
    }


    public interface Callback extends BaseModelListener {
        void onSuccess(List<Album> users);

        void onError(Throwable t);
    }


}
