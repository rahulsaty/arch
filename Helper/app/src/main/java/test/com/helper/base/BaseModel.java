package test.com.helper.base;

/**
 * Created by pranav.dixit on 03/04/17.
 */

public abstract class BaseModel<T extends BaseModelListener> {
    private T lisenter;




    public void attachListener(T lisenter) {
        this.lisenter = lisenter;
    }

    public T getListner() {
        return lisenter;
    }

    public void detachListener() {
        lisenter = null;
    }





}
