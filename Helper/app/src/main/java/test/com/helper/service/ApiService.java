package test.com.helper.service;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import test.com.helper.pojo.Album;
import test.com.helper.pojo.User;

public interface ApiService {
    @GET("posts")
    Observable<List<User>> getUsers();
    @GET("photos")
    Observable<List<Album>> getPhotos();

}
