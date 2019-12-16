package bisma.rabia.gogreenantalya;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import bisma.rabia.gogreenantalya.databinding.LayoutActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LayoutActivityHomeBinding layoutActivityHomeBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.layout_activity_home, null, false);
        setContentView(layoutActivityHomeBinding.getRoot());

        layoutActivityHomeBinding.bnvActivityHome.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.mni_bottom_nav_home:
                        layoutActivityHomeBinding.lyoHome.setVisibility(View.VISIBLE);
                        layoutActivityHomeBinding.lyoStoresName.setVisibility(View.GONE);
                        layoutActivityHomeBinding.lyoAboutus.setVisibility(View.GONE);
                        break;
                    case R.id.mni_bottom_nav_partners:
                        layoutActivityHomeBinding.lyoHome.setVisibility(View.GONE);
                        layoutActivityHomeBinding.lyoStoresName.setVisibility(View.VISIBLE);
                        layoutActivityHomeBinding.lyoAboutus.setVisibility(View.GONE);
                        break;
                    case R.id.mni_bottom_nav_about:
                        layoutActivityHomeBinding.lyoHome.setVisibility(View.GONE);
                        layoutActivityHomeBinding.lyoStoresName.setVisibility(View.GONE);
                        layoutActivityHomeBinding.lyoAboutus.setVisibility(View.VISIBLE);
                        break;
                }
                return true;
            }
        });
    }
}