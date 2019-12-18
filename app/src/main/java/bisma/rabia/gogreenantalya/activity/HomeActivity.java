package bisma.rabia.gogreenantalya.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
import bisma.rabia.gogreenantalya.fragment.PartnerListFragment;
import bisma.rabia.gogreenantalya.fragment.CouponListFragment;

public class HomeActivity extends AppCompatActivity {

    LayoutActivityHomeBinding layoutActivityHomeBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layoutActivityHomeBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.layout_activity_home, null, false);
        setContentView(layoutActivityHomeBinding.getRoot());

        layoutActivityHomeBinding.vpHomeActivity.setAdapter(new MyAdapter(getSupportFragmentManager()));
        layoutActivityHomeBinding.bnvActivityHome.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.mni_bottom_nav_home:
                        layoutActivityHomeBinding.vpHomeActivity.setCurrentItem(0);
                        break;
                    case R.id.mni_bottom_nav_coupons:
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
                        layoutActivityHomeBinding.bnvActivityHome.setSelectedItemId(R.id.mni_bottom_nav_coupons);
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
                startActivityForResult(new Intent(HomeActivity.this, QrCodeActivity.class), 4321);
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
                    return new CouponListFragment();
                case 2:
                    return new PartnerListFragment();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4321) {
            layoutActivityHomeBinding.vpHomeActivity.setAdapter(new MyAdapter(getSupportFragmentManager()));
        }
    }
}