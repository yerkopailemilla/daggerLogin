package cl.yerkos.daggerloggin.login;

import dagger.Module;
import dagger.Provides;

@Module
public class LoginModule {

    @Provides
    public LoginActivityPresenter providerLoginActivityPresenter(LoginActivityMVP.Model model){
        return new LoginActivityPresenter(model);
    }

    @Provides
    public LoginActivityMVP.Model providerLoginActivityModel(LoginRepository repository){
        return new LoginActivityModel(repository);
    }

    @Provides LoginRepository providerLoginRepository(){
        return new DatabaseRepository();
    }

}

