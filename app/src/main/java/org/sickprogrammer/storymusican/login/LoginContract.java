package org.sickprogrammer.storymusican.login;

import android.widget.EditText;

import org.sickprogrammer.storymusican.BaseContract;

public interface LoginContract {
    interface View extends BaseContract.View {
        boolean togglePassWordVisibility(boolean isShown, EditText setTo);
    }

    interface Presenter extends BaseContract.Presenter<View> {

    }
}
