package cl.yerkos.daggerloggin.login;

import android.support.annotation.Nullable;

public class LoginActivityPresenter implements LoginActivityMVP.Presenter {

    @Nullable
    private LoginActivityMVP.View view;
    private LoginActivityMVP.Model model;

    public LoginActivityPresenter(LoginActivityMVP.Model model) {
        this.model = model;
    }

    @Override
    public void setView(LoginActivityMVP.View view) {
        this.view = view;

    }

    @Override
    public void loginButtonClicked() {
        if (view != null){
            if (view.getName().trim().equals("")||view.getLastname().trim().equals("")){
                view.showInputError();
            } else {
                model.createUser(view.getName().trim(), view.getLastname().trim());
                view.showUserSave();
            }
        }
    }

    @Override
    public void getCurrentUser() {

        User user = model.getUser();
        if (user == null){
            if (view != null){
                view.showUserNotAvailable();
            } else {
                if (view != null){
                    view.setName(user.getName());
                    view.setLastname(user.getLastname());
                }
            }
        }

    }
}
