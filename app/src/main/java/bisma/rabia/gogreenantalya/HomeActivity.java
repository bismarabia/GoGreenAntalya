package bisma.rabia.gogreenantalya;

import android.os.Bundle;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import bisma.rabia.gogreenantalya.databinding.LayoutActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LayoutActivityHomeBinding layoutActivityHomeBinding = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.layout_activity_home, null, false);
        setContentView(layoutActivityHomeBinding.getRoot());
    }
}