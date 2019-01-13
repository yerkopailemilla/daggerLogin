package cl.yerkos.daggerloggin.login;

public interface LoginActivityMVP {


    interface View {

        String getName();
        String getLastname();

        void showUserNotAvailable();
        void showInputError();
        void showUserSave();

        void setName(String name);
        void setLastname(String lastname);

    }

    interface Presenter {

        void setView(LoginActivityMVP.View view);
        void loginButtonClicked();
        void getCurrentUser();

    }

    interface Model {

        void createUser(String name, String lastname);
        User getUser();

    }

}
