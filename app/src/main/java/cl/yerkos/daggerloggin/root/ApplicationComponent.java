package cl.yerkos.daggerloggin.root;

import javax.inject.Singleton;

import cl.yerkos.daggerloggin.login.LoginActivity;
import cl.yerkos.daggerloggin.login.LoginModule;
import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, LoginModule.class})
public interface ApplicationComponent {

    void inject(LoginActivity loginActivity);
}
