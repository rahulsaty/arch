package test.com.helper;

import android.view.View;

import java.util.List;

import javax.inject.Inject;

import test.com.helper.base.BasePresenter;
import test.com.helper.pojo.User;

public class MainPresenter<V extends MainView> extends BasePresenter<V> implements MainModel.Callback {


    MainModel model;
    @Inject
    public MainPresenter(MainModel mainModel){
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
    void openDialog(){
        getMvpView().openDialog();
    }

    @Override
    public void onSuccess(List<User> users) {
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
