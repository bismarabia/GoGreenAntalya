package bisma.rabia.gogreenantalya.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;

import bisma.rabia.gogreenantalya.R;
import bisma.rabia.gogreenantalya.activity.LoginActivity;
import bisma.rabia.gogreenantalya.databinding.FragmentAboutUsBinding;

public class AboutUsFragment extends Fragment {

    FragmentAboutUsBinding fragmentAboutUsBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentAboutUsBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.fragment_about_us, container, false);
        return fragmentAboutUsBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentAboutUsBinding.btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getActivity() != null) {
                    PreferenceManager.getDefaultSharedPreferences(getActivity()).edit().remove("username").apply();
                    startActivity(new Intent(getActivity(), LoginActivity.class));
                    getActivity().finish();
                    getActivity().finishAffinity();
                    getActivity().finishAndRemoveTask();
                }
            }
        });
    }
}