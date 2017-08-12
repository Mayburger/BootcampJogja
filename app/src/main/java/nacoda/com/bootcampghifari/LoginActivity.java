package nacoda.com.bootcampghifari;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nacoda.com.bootcampghifari.fonts.Fonts;

public class LoginActivity extends AppCompatActivity {


    @InjectView(R.id.tvTitleLogin)
    TextView tvTitleLogin;
    @InjectView(R.id.etUsername)
    EditText etUsername;
    @InjectView(R.id.etPassword)
    EditText etPassword;
    @InjectView(R.id.tilUsername)
    TextInputLayout tilUsername;
    @InjectView(R.id.tilPassword)
    TextInputLayout tilPassword;
    @InjectView(R.id.btnSubmit)
    Button btnSubmit;
    @InjectView(R.id.clLogin)
    CoordinatorLayout clLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.inject(this);

        setFonts();

    }

    public void setFonts() {
        Fonts.Montez(this, tvTitleLogin);
        Fonts.RobotoLight(this, etUsername);
        Fonts.RobotoLight(this, etPassword);
        Fonts.RobotoRegularInputLayout(this, tilUsername);
        Fonts.RobotoRegularInputLayout(this, tilPassword);
        Fonts.RobotoRegularButton(this, btnSubmit);

    }

    public void btnSubmitOnClick(View view) {

        String username = etUsername.getText().toString();
        String password = etPassword.getText().toString();

        if (password.isEmpty() && username.isEmpty()) {
            Snackbar.make(clLogin, "Fields cannot be empty", Snackbar.LENGTH_SHORT).show();
        } else if (username.isEmpty()) {
            Snackbar.make(clLogin, "Username field cannot be empty", Snackbar.LENGTH_SHORT).show();
        } else if (password.isEmpty()) {
            Snackbar.make(clLogin, "Password field cannot be empty", Snackbar.LENGTH_SHORT).show();
        } else if (!username.equals("admin")) {
            Snackbar.make(clLogin, "Wrong Username", Snackbar.LENGTH_SHORT).show();
        } else if (!password.equals("admin")) {
            Snackbar.make(clLogin, "Wrong Password", Snackbar.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(getApplicationContext(), SplashActivity.class));
            finish();
        }


    }
}
