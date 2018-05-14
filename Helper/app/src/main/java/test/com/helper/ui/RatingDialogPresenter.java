/*
 * Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://mindorks.com/license/apache-v2
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package test.com.helper.ui;


import test.com.helper.base.BasePresenter;



public class RatingDialogPresenter<V extends RatingDialogMvpView> extends BasePresenter<V>
    {

    public static final String TAG = "RatingDialogPresenter";

    private boolean isRatingSecondaryActionShown = false;



    public void onRatingSubmitted(final float rating, String message) {

        if (rating == 0) {
            getMvpView().showMessage("jjhksf");
            return;
        }

        if (!isRatingSecondaryActionShown) {
            if (rating == 5) {
                getMvpView().showPlayStoreRatingView();
                getMvpView().hideSubmitButton();
                getMvpView().disableRatingStars();
            } else {
                getMvpView().showRatingMessageView();
            }
            isRatingSecondaryActionShown = true;
            return;
        }

        getMvpView().showLoading();

        //for demo
        getMvpView().hideLoading();
        getMvpView().showMessage("kdsjkjhdksj");
        getMvpView().dismissDialog();

    }

    private void sendRatingDataToServerInBackground(float rating) {

    }

    public void onCancelClicked() {
        getMvpView().dismissDialog();
    }

    public void onLaterClicked() {
        getMvpView().dismissDialog();
    }

    public void onPlayStoreRatingClicked() {
        getMvpView().openPlayStoreForRating();
        sendRatingDataToServerInBackground(5);
        getMvpView().dismissDialog();
    }
}
