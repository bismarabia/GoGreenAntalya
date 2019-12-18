package bisma.rabia.gogreenantalya.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import bisma.rabia.gogreenantalya.R;
import bisma.rabia.gogreenantalya.databinding.FragmentPartnersListBinding;

public class PartnerListFragment extends Fragment {

    private FragmentPartnersListBinding fragmentPartnersListBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentPartnersListBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.fragment_partners_list, container, false);
        return fragmentPartnersListBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<String> partners = new ArrayList<String>() {{
            add("Starbuks");
            add("H&M");
            add("LC WAIKIKI");
            add("Migros");
        }};

        fragmentPartnersListBinding.lvPartnersList.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, partners));
    }
}