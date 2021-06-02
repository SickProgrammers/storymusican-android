package org.sickprogrammer.storymusican.register;

import android.widget.EditText;

import org.sickprogrammer.storymusican.BaseContract;

public interface RegisterFragmentContract {

    interface View extends BaseContract.FragmentView {
        void setTitleAndEditTextWithType(REGISTERINFO type);

        boolean togglePassWordVisibility(boolean isShown, EditText setTo);
    }

    interface Presenter extends BaseContract.Presenter<View> {

    }

}
