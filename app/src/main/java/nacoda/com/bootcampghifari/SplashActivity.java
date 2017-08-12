package nacoda.com.bootcampghifari;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import nacoda.com.bootcampghifari.fonts.Fonts;

public class SplashActivity extends Activity {

    @InjectView(R.id.tvSplash)
    TextView tvSplash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.inject(this);

        Fonts.Montez(this, tvSplash);

        int SPLASH_TIME_OUT = 3000;
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent i = new Intent(SplashActivity.this, PariwisataActivity.class);
                startActivity(i);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

}