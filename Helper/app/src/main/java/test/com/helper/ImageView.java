package test.com.helper;

import java.util.List;

import test.com.helper.base.MvpView;
import test.com.helper.pojo.Album;

public interface ImageView extends MvpView {

    void onClickListner();
    void loadData(List<Album> users);

}
