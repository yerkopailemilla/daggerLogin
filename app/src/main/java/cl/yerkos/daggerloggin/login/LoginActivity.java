package cl.yerkos.daggerloggin.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import javax.inject.Inject;

import cl.yerkos.daggerloggin.R;
import cl.yerkos.daggerloggin.root.App;

public class LoginActivity extends AppCompatActivity implements LoginActivityMVP.View {

    @Inject
    LoginActivityMVP.Presenter presenter;
    EditText et_login_name, et_login_lastname;
    Button btn_login_go;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ((App) getApplication()).getApplicationComponent().inject(this);

        et_login_name = findViewById(R.id.et_login_name);
        et_login_lastname = findViewById(R.id.et_login_lastname);

        btn_login_go = findViewById(R.id.btn_login_go);

        btn_login_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.loginButtonClicked();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.setView(this);
        presenter.getCurrentUser();
    }

    @Override
    public String getName() {
        return et_login_name.getText().toString();
    }

    @Override
    public String getLastname() {
        return et_login_lastname.getText().toString();
    }

    @Override
    public void showUserNotAvailable() {
        Toast.makeText(this, "Error. El usuario no está disponible", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showInputError() {
        Toast.makeText(this, "Error. Ni el nombre ni el apellido puede estar vacío.", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void showUserSave() {
        Toast.makeText(this, "Usuario guardado correctamente.", Toast.LENGTH_SHORT).show();

    }

    @Override
    public void setName(String name) {
        this.et_login_name.setText(name);
    }

    @Override
    public void setLastname(String lastname) {
        this.et_login_lastname.setText(lastname);
    }
}
