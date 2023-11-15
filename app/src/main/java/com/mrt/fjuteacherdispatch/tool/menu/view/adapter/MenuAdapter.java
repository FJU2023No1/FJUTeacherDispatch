package com.mrt.fjuteacherdispatch.tool.menu.view.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.mrt.fjuteacherdispatch.R;
import com.mrt.fjuteacherdispatch.databinding.FjuTdAppAdapterMenuBinding;
import com.mrt.fjuteacherdispatch.tool.menu.model.MenuAdapterModel;
import com.mrt.fjuteacherdispatch.tool.menu.presenter.MenuAdapterPresenter;
import com.mrt.fjuteacherdispatch.tool.menu.view.listener.MenuAdapterListener;
import com.mrt.fjuteacherdispatch.tool.menu.view.listener.MenuItemListener;
import com.mrt.fjuteacherdispatch.tool.menu.view.listener.MenuListener;

public class MenuAdapter<MenuItem extends MenuItemListener> extends ListAdapter<MenuItem, MenuAdapter.MenuViewHolder> {
    private final Context mContext;
    private final MenuAdapterListener menuAdapterListener;
    private final MenuListener menuListener;

    public MenuAdapter(Context mContext, MenuAdapterListener menuAdapterListener, MenuListener menuListener) {
        super(new MenuAdapter.DiffCallback());
        this.mContext = mContext;
        this.menuAdapterListener = menuAdapterListener;
        this.menuListener = menuListener;
    }

    @NonNull
    @Override
    public MenuAdapter.MenuViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        return new MenuAdapter.MenuViewHolder(
                DataBindingUtil.inflate(
                        LayoutInflater.from(viewGroup.getContext()),
                        R.layout.fju_td_app_adapter_menu,
                        viewGroup,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.MenuViewHolder holder, int position) {
        MenuItem menuItem = getItem(position);
        MenuAdapterModel mAdapterModel = new MenuAdapterModel();
        MenuAdapterPresenter mAdapterPresenter = new MenuAdapterPresenter(
                mContext,
                mAdapterModel,
                menuAdapterListener,
                menuItem,
                menuListener
        );
        holder.binding.setMModel(mAdapterModel);
        holder.binding.setMPresenter(mAdapterPresenter);
        mAdapterPresenter.init();
    }

    static class DiffCallback<MenuItem extends MenuItemListener> extends DiffUtil.ItemCallback<MenuItem> {
        @Override
        public boolean areItemsTheSame(@NonNull MenuItem oldItem, @NonNull MenuItem newItem) {
            return oldItem.getItemId() == newItem.getItemId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull MenuItem oldItem, @NonNull MenuItem newItem) {
            return oldItem.getItemId() == newItem.getItemId();
        }
    }

    static class MenuViewHolder extends RecyclerView.ViewHolder {
        FjuTdAppAdapterMenuBinding binding;

        MenuViewHolder(FjuTdAppAdapterMenuBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
