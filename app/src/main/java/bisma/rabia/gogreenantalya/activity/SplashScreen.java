package bisma.rabia.gogreenantalya.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import bisma.rabia.gogreenantalya.R;
import bisma.rabia.gogreenantalya.databinding.ActivitySplashScreenBinding;

public class SplashScreen extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivitySplashScreenBinding activitySplashScreenBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_splash_screen, null, false);
        setContentView(activitySplashScreenBinding.getRoot());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                String username = PreferenceManager.getDefaultSharedPreferences(SplashScreen.this).getString("username", "");
                if (TextUtils.isEmpty(username)) {
                    startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                }
                else {
                    startActivity(new Intent(SplashScreen.this, HomeActivity.class));
                }
                finish();
                finishAffinity();
            }
        }, 3000);
    }
}