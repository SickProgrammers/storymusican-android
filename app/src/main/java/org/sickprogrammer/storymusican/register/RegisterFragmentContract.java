package org.sickprogrammer.storymusican.register;

import org.sickprogrammer.storymusican.BaseContract;

public interface RegisterFragmentContract {

    interface View extends BaseContract.FragmentView{
        void setTitleAndEditTextWithType(REGISTERINFO type);
    }

    interface Presenter extends BaseContract.Presenter<View>{

    }

}
