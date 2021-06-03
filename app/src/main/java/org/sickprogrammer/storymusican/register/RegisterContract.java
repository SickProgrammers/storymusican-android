package org.sickprogrammer.storymusican.register;

import org.sickprogrammer.storymusican.BaseContract;

public interface RegisterContract {

    interface View extends BaseContract.View{
        void createFragment();
        void moveToNextFragment();
        void moveToPreviousFragment();
        void getRegisterInfoFromFragment();
        void initFragment();
    }
    interface Presenter extends BaseContract.Presenter<View>{

    }
}
