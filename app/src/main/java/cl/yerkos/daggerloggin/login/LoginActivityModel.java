package cl.yerkos.daggerloggin.login;

public class LoginActivityModel implements LoginActivityMVP.Model {

    private LoginRepository loginRepository;
    LoginActivityMVP.Presenter presenter;

    public LoginActivityModel(LoginRepository loginRepository) {
        this.loginRepository = loginRepository;
    }

    @Override
    public void createUser(String name, String lastname) {
        //lógica de negocio
        loginRepository.saveUSer(new User(name, lastname));

    }

    @Override
    public User getUser() {
        //lógica de negocio
        return loginRepository.getUser();
    }
}
