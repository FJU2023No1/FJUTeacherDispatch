package com.mrt.fjuteacherdispatch.main.view.fragment.block;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.mrt.fjuteacherdispatch.R;
import com.mrt.fjuteacherdispatch.databinding.FjuTdAppFragmentStudentBlockBinding;
import com.mrt.fjuteacherdispatch.main.model.FJUStudentBlockModel;
import com.mrt.fjuteacherdispatch.main.presenter.FJUStudentBlockPresenter;
import com.mrt.fjuteacherdispatch.main.view.listener.FJUStudentBlockListener;
import com.mrt.fjuteacherdispatch.main.view.listener.UserTypeBlockListener;

public class FJUStudentBlockFragment extends Fragment implements UserTypeBlockListener {

    private FjuTdAppFragmentStudentBlockBinding binding;

    private FJUStudentBlockPresenter mPresenter;

    private FJUStudentBlockModel mModel;

    private FJUStudentBlockListener mListener;

    public static FJUStudentBlockFragment newInstance() {
        FJUStudentBlockFragment fragment = new FJUStudentBlockFragment();
        Bundle bundle = new Bundle();
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fju_td_app_fragment_student_block,
                container, false);
        mModel = new FJUStudentBlockModel();
        mPresenter = new FJUStudentBlockPresenter(this, mModel, mListener);
        binding.setMModel(mModel);
        binding.setMPresenter(mPresenter);

        View view = binding.getRoot();

        mPresenter.setBundle(getArguments());
        mPresenter.init();

        return view;
    }

    public void setRecyclerViewMessages(

    ) {
//        mModel.mAdapter = new RegularTaxProductListAdapter(
//                getActivity(),
//                mModel,
//                mParentModel,
//                mListener,
//                itemsList,
//                itemsCheckList
//        );
//        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        binding.recyclerView.setAdapter(mModel.mAdapter);
//        binding.recyclerView.setVisibility(View.VISIBLE);
    }
}
