package bisma.rabia.gogreenantalya.activity;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.textfield.TextInputEditText;

import bisma.rabia.gogreenantalya.R;
import bisma.rabia.gogreenantalya.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding activityLoginBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_login, null, false);
        setContentView(activityLoginBinding.getRoot());

        final TextInputEditText edtLoginActivityUsername = activityLoginBinding.edtLoginActivityUsername;

        activityLoginBinding.fabLoginActivityNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edtLoginActivityUsername.getText().toString();
                if (TextUtils.isEmpty(username)) {
                    Toast.makeText(LoginActivity.this, "You have to enter a username to proceed", Toast.LENGTH_SHORT).show();
                } else {
                    PreferenceManager.getDefaultSharedPreferences(LoginActivity.this).edit().putString("username", username).apply();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    finish();
                    finishAffinity();
                }
            }
        });
    }
}
