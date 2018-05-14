package test.com.helper;

import java.util.List;

import test.com.helper.base.MvpView;
import test.com.helper.pojo.User;

public interface MainView extends MvpView {

    void onClickListner();
    void openDialog();
    void loadData(List<User> users);

}
