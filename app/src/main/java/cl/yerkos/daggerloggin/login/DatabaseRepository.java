package cl.yerkos.daggerloggin.login;

public class DatabaseRepository implements LoginRepository {

    private User user;

    @Override
    public void saveUSer(User user) {
        if (user == null){
            user = getUser();
        }
        this.user = user;
    }

    @Override
    public User getUser() {
        if (user == null){
            user = new User("Antonio", "Banderas");
            user.setId(0);
            return user;
        } else {
            return user;
        }
    }
}
