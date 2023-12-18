package com.mrt.fjuteacherdispatch.main.view.fragment.block;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mrt.fjuteacherdispatch.R;
import com.mrt.fjuteacherdispatch.databinding.FjuTdAppFragmentStudentBlockBinding;
import com.mrt.fjuteacherdispatch.main.model.FJUStudentBlockModel;
import com.mrt.fjuteacherdispatch.main.model.data.TeacherSchedule;
import com.mrt.fjuteacherdispatch.main.presenter.FJUStudentBlockPresenter;
import com.mrt.fjuteacherdispatch.main.view.adapter.TeacherScheduleListAdapter;
import com.mrt.fjuteacherdispatch.main.view.listener.FJUStudentBlockListener;
import com.mrt.fjuteacherdispatch.main.view.listener.UserTypeBlockListener;

import java.util.ArrayList;

public class FJUStudentBlockFragment extends Fragment implements UserTypeBlockListener {

    private FjuTdAppFragmentStudentBlockBinding binding;

    private FJUStudentBlockPresenter mPresenter;

    private FJUStudentBlockModel mModel;

    private FJUStudentBlockListener mListener;

    public static final String FIELD_USER_EMAIL = "fieldUserEmailData";

    public static FJUStudentBlockFragment newInstance(String userMail) {
        FJUStudentBlockFragment fragment = new FJUStudentBlockFragment();
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
            ArrayList<TeacherSchedule> scheduleList,
            String userMail
    ) {
        mModel.mAdapter = new TeacherScheduleListAdapter(
                getActivity(),
                mPresenter,
                scheduleList,
                userMail
        );
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        binding.recyclerView.setAdapter(mModel.mAdapter);
        binding.recyclerView.setVisibility(View.VISIBLE);
    }
}
