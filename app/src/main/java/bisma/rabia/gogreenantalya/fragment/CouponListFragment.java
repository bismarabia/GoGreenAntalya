package bisma.rabia.gogreenantalya.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;

import bisma.rabia.gogreenantalya.R;
import bisma.rabia.gogreenantalya.databinding.FragmentCouponListBinding;
import bisma.rabia.gogreenantalya.databinding.LayoutCouponListItemBinding;

public class CouponListFragment extends Fragment {

    FragmentCouponListBinding fragmentCouponListBinding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentCouponListBinding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), R.layout.fragment_coupon_list, container, false);
        return fragmentCouponListBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentCouponListBinding.lvCouponsList.setAdapter(new CouponAdapter(getActivity(), new ArrayList<Coupon>() {{
            add(new Coupon("Get 5% discount", "Migros", "100"));
            add(new Coupon("Get 10% discount", "Şok", "80"));
            add(new Coupon("Get 1 free Ice Cream", "McDonald's", "30"));
        }}));
    }

    private class CouponAdapter extends ArrayAdapter<Coupon> {

        private Context mContext;

        CouponAdapter(@NonNull Context context, List<Coupon> coupons) {
            super(context, R.layout.layout_coupon_list_item, coupons);
            mContext = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) {
                LayoutCouponListItemBinding layoutCouponListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(mContext), R.layout.layout_coupon_list_item, parent, false);
                Coupon item = getItem(position);
                if (layoutCouponListItemBinding != null && item != null) {
                    layoutCouponListItemBinding.txvCouponListPoint.setText(String.format("%s\nPoints", item.getPoint()));
                    layoutCouponListItemBinding.txvCouponListTitleStore.setText(String.format("%s in %s", item.getDiscountTitle(), item.getStore()));
                    return layoutCouponListItemBinding.getRoot();
                }
            }
            return convertView;
        }
    }

    class Coupon {
        String store;
        String discountTitle;
        String point;

        public Coupon(String discountTitle, String store, String point) {
            this.store = store;
            this.discountTitle = discountTitle;
            this.point = point;
        }

        public String getStore() {
            return store;
        }

        public void setStore(String store) {
            this.store = store;
        }

        public String getDiscountTitle() {
            return discountTitle;
        }

        public void setDiscountTitle(String discountTitle) {
            this.discountTitle = discountTitle;
        }

        public String getPoint() {
            return point;
        }

        public void setPoint(String point) {
            this.point = point;
        }
    }
}