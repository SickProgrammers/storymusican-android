package org.sickprogrammer.storymusican.presenter;

public class BaseContract {
    public interface View {
        /**
         * 액티비티 실행 시 레이아웃 요소들 findViewById
         */
        void initFindView();

        /**
         * 액티비티 실행 시 레이아웃 요소들에 대한 클릭 리스너 설정
         */
        void initClickListener();
    }

    public interface Presenter<T> {
        /**
         * Presenter 에 뷰를 연결하는 함수
         * @param view 프레젠터와 연결할 뷰
         */
        void setView(T view);
        void releaseView();
    }
}
