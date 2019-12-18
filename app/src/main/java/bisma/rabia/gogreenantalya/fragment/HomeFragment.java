package bisma.rabia.gogreenantalya.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import bisma.rabia.gogreenantalya.R;
import bisma.rabia.gogreenantalya.databinding.FragmentHomeBinding;
import bisma.rabia.gogreenantalya.utils.CheckBalanceTask;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding fragmentHomeBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentHomeBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.fragment_home, container, false);
        return fragmentHomeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String nodeUrl = getString(R.string.node_url);
        new CheckBalanceTask(new CheckBalanceTask.CheckBalanceTaskCallback() {
            @Override
            public void update(String updateContent) {

            }

            @Override
            public void finish(boolean success, String updateContent, String balance) {
                if (balance.contains("EOS")) {
                    balance = balance.replace("EOS", "").trim();
                }
                fragmentHomeBinding.txvHomeBalance.setText("Point \n" + balance);
            }
        }).execute(nodeUrl, "rabia");
    }
}