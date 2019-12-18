package bisma.rabia.gogreenantalya.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import bisma.rabia.gogreenantalya.R;
import bisma.rabia.gogreenantalya.databinding.LayoutActivityHomeBinding;
import bisma.rabia.gogreenantalya.fragment.AboutUsFragment;
import bisma.rabia.gogreenantalya.fragment.HomeFragment;
import bisma.rabia.gogreenantalya.fragment.PartnersFragment;
import bisma.rabia.gogreenantalya.fragment.RecycleFragment;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final LayoutActivityHomeBinding layoutActivityHomeBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.layout_activity_home, null, false);
        setContentView(layoutActivityHomeBinding.getRoot());

        layoutActivityHomeBinding.vpHomeActivity.setAdapter(new MyAdapter(getSupportFragmentManager()));
        layoutActivityHomeBinding.bnvActivityHome.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.mni_bottom_nav_home:
                        layoutActivityHomeBinding.vpHomeActivity.setCurrentItem(0);
                        break;
                    case R.id.mni_bottom_nav_recycle:
                        layoutActivityHomeBinding.vpHomeActivity.setCurrentItem(1);
                        break;
                    case R.id.mni_bottom_nav_partners:
                        layoutActivityHomeBinding.vpHomeActivity.setCurrentItem(2);
                        break;
                    case R.id.mni_bottom_nav_about:
                        layoutActivityHomeBinding.vpHomeActivity.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });

        layoutActivityHomeBinding.vpHomeActivity.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        layoutActivityHomeBinding.bnvActivityHome.setSelectedItemId(R.id.mni_bottom_nav_home);
                        break;
                    case 1:
                        layoutActivityHomeBinding.bnvActivityHome.setSelectedItemId(R.id.mni_bottom_nav_recycle);
                        break;
                    case 2:
                        layoutActivityHomeBinding.bnvActivityHome.setSelectedItemId(R.id.mni_bottom_nav_partners);
                        break;
                    case 3:
                        layoutActivityHomeBinding.bnvActivityHome.setSelectedItemId(R.id.mni_bottom_nav_about);
                        break;
                }
            }
        });

        layoutActivityHomeBinding.fabHomeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, QrCodeActivity.class));
            }
        });
    }

    class MyAdapter extends FragmentStatePagerAdapter {

        MyAdapter(@NonNull FragmentManager fm) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new HomeFragment();
                case 1:
                    return new RecycleFragment();
                case 2:
                    return new PartnersFragment();
                case 3:
                    return new AboutUsFragment();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 4;
        }
    }
}