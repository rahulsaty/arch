package test.com.helper.base;

/**
 * Created by pranav.dixit on 03/04/17.
 */

public interface BaseModelListener {
    /**
     * This method is called when model is not able to fetch data
     * @param failureResponse
     */
    void onFailure(Throwable failureResponse);

}
