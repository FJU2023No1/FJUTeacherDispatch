package com.mrt.fjuteacherdispatch.main.view.fragment;

import static android.content.Intent.getIntent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.mrt.fjuteacherdispatch.R;
import com.mrt.fjuteacherdispatch.databinding.FjuTdAppEinvoiceFragmentHomePageBinding;
import com.mrt.fjuteacherdispatch.main.model.HomePageModel;
import com.mrt.fjuteacherdispatch.main.presenter.HomePagePresenter;

public class HomePageFragment extends Fragment {

    public static final String FRAGMENT_TAG_NAME = HomePageFragment.class.getName();
    private FjuTdAppEinvoiceFragmentHomePageBinding binding;
    private HomePageModel mModel;
    private HomePagePresenter mPresenter;

    public static final String FIELD_USER_TYPE = "fieldUserTypeData";

    public static HomePageFragment newInstance(
            int userType
    ) {
        HomePageFragment fragment = new HomePageFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(FIELD_USER_TYPE, userType);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fju_td_app_einvoice_fragment_home_page,
                container, false);
        mModel = new HomePageModel();
        mPresenter = new HomePagePresenter(requireContext(), mModel, this);
        binding.setMModel(mModel);
        binding.setMPresenter(mPresenter);

        View view = binding.getRoot();

        initView();

        mPresenter.setBundle(getActivity().getIntent().getExtras());
        mPresenter.init();

        return view;
    }

    private void initView() {
        setToolbarLayout();
    }

    private void setToolbarLayout() {
        binding.toolbarLayout.setTitle("華語教師媒合系統");
    }

}