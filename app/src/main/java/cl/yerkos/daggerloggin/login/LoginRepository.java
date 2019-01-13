package cl.yerkos.daggerloggin.login;

public interface LoginRepository {

    void saveUSer(User user);
    User getUser();
}
