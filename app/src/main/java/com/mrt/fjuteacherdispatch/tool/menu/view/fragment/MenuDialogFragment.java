package com.mrt.fjuteacherdispatch.tool.menu.view.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mrt.fjuteacherdispatch.tool.DeviceDisplayUtil;
import com.mrt.fjuteacherdispatch.tool.menu.view.adapter.MenuAdapter;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.mrt.fjuteacherdispatch.R;
import com.mrt.fjuteacherdispatch.databinding.FjuTdAppFragmentDialogMenuBinding;
import com.mrt.fjuteacherdispatch.tool.menu.model.MenuDialogModel;
import com.mrt.fjuteacherdispatch.tool.menu.presenter.MenuDialogPresenter;
import com.mrt.fjuteacherdispatch.tool.menu.view.listener.MenuAdapterListener;
import com.mrt.fjuteacherdispatch.tool.menu.view.listener.MenuItemListener;
import com.mrt.fjuteacherdispatch.tool.menu.view.listener.MenuListener;

import java.util.Arrays;

public class MenuDialogFragment<MenuItem extends MenuItemListener> extends BaseBottomSheetDialogFragment implements
        MenuAdapterListener {

    public static final String FRAGMENT_TAG_NAME = MenuDialogFragment.class.getName();

    private final MenuListener menuListener;
    private final MenuItem[] menuItemArray;
    private FjuTdAppFragmentDialogMenuBinding binding;
    private MenuDialogModel mModel;
    private MenuDialogPresenter mPresenter;

    public static <MenuItem extends MenuItemListener> MenuDialogFragment newInstance(
            MenuListener menuListener,
            MenuItem[] menuItemArray) {
        return new MenuDialogFragment(menuListener, menuItemArray);
    }

    public MenuDialogFragment(
            MenuListener menuListener,
            MenuItem[] menuItemArray) {
        this.menuListener = menuListener;
        this.menuItemArray = menuItemArray;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NORMAL, R.style.bottom_sheet_dialog_style);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fju_td_app_fragment_dialog_menu,
                container,
                false);
        mModel = new MenuDialogModel();
        mPresenter = new MenuDialogPresenter(
                requireContext(),
                mModel,
                this,
                menuListener);
        binding.setMModel(mModel);
        binding.setMPresenter(mPresenter);

        View view = binding.getRoot();
        initView();
        mPresenter.init();

        return view;
    }

    private void initView() {
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(requireContext());
        binding.recyclerView.setLayoutManager(mLayoutManager);
        binding.recyclerView.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(requireContext())
                        .color(ContextCompat.getColor(requireContext(), R.color.fju_td_app_gray_eeeeee))
                        .size(DeviceDisplayUtil.dp2px(requireContext(), 1f))
                        .build());

        MenuAdapter mMenuAdapter = new MenuAdapter(
                requireContext(),
                this,
                menuListener);

        mMenuAdapter.submitList(Arrays.asList(menuItemArray));
        binding.recyclerView.setAdapter(mMenuAdapter);
    }

    public void onDismiss(@NonNull DialogInterface dialog) {
        super.onDismiss(dialog);
        menuListener.onCancel();
    }
}
