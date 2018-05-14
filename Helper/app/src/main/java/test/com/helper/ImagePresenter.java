package test.com.helper;

import android.view.View;

import java.util.List;

import javax.inject.Inject;

import test.com.helper.base.BasePresenter;
import test.com.helper.pojo.Album;

public class ImagePresenter<V extends ImageView> extends BasePresenter<V> implements ImageModel.Callback {


    ImageModel model;
    @Inject
    public ImagePresenter(ImageModel mainModel){
        this.model = mainModel;
        this.model.setListener(this);

    }

    void loadData(){
        getMvpView().showLoading();
        model.loadData();
    }


    void onClickListiner(View v){
        getMvpView().onClickListner();
    }

    @Override
    public void onSuccess(List<Album> users) {
        if(isViewAttached()) {
            getMvpView().hideLoading();
            getMvpView().loadData(users);
        }
    }

    @Override
    public void onError(Throwable t) {
        getMvpView().hideLoading();
        getMvpView().showMessage(t.getMessage());
    }

    @Override
    public void onFailure(Throwable failureResponse) {

    }


}
