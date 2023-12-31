package com.mrt.fjuteacherdispatch.main.view.fragment.block;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mrt.fjuteacherdispatch.R;
import com.mrt.fjuteacherdispatch.databinding.FjuTdAppFragmentTeacherBlockBinding;
import com.mrt.fjuteacherdispatch.main.model.FJUTeacherBlockModel;
import com.mrt.fjuteacherdispatch.main.model.data.StudentDemand;
import com.mrt.fjuteacherdispatch.main.model.data.TeacherSchedule;
import com.mrt.fjuteacherdispatch.main.presenter.FJUTeacherBlockPresenter;
import com.mrt.fjuteacherdispatch.main.view.adapter.StudentDemandListAdapter;
import com.mrt.fjuteacherdispatch.main.view.listener.FJUTeacherBlockListener;
import com.mrt.fjuteacherdispatch.main.view.listener.UserTypeBlockListener;

import java.util.ArrayList;

public class FJUTeacherBlockFragment extends Fragment implements UserTypeBlockListener {

    private FjuTdAppFragmentTeacherBlockBinding binding;

    private FJUTeacherBlockPresenter mPresenter;

    private FJUTeacherBlockModel mModel;

    private FJUTeacherBlockListener mListener;

    public static final String FIELD_USER_EMAIL = "fieldUserEmailData";

    public static FJUTeacherBlockFragment newInstance(String userMail) {
        FJUTeacherBlockFragment fragment = new FJUTeacherBlockFragment();
        Bundle bundle = new Bundle();
        bundle.putString(FIELD_USER_EMAIL, userMail);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DataBindingUtil.inflate(inflater,
                R.layout.fju_td_app_fragment_teacher_block,
                container, false);
        mModel = new FJUTeacherBlockModel();
        mPresenter = new FJUTeacherBlockPresenter(this, mModel, mListener);
        binding.setMModel(mModel);
        binding.setMPresenter(mPresenter);

        View view = binding.getRoot();

        mPresenter.setBundle(getArguments());
        mPresenter.init();

        return view;
    }

    public void setRecyclerViewMessages(
            ArrayList<StudentDemand> studentDemandList,
            String userMail
    ) {
        mModel.mAdapter = new StudentDemandListAdapter(
                getActivity(),
                mPresenter,
                studentDemandList,
                userMail
        );
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.recyclerView.setAdapter(mModel.mAdapter);
        binding.recyclerView.setVisibility(View.VISIBLE);
    }
}