package com.mrt.fjuteacherdispatch.main.view.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.mrt.fjuteacherdispatch.main.view.fragment.block.FJUAdminBlockFragment;
import com.mrt.fjuteacherdispatch.main.view.fragment.block.FJUStudentBlockFragment;
import com.mrt.fjuteacherdispatch.main.view.fragment.block.FJUTeacherBlockFragment;
import com.mrt.fjuteacherdispatch.main.view.listener.BaseUserTypeBlockListener;
import com.mrt.fjuteacherdispatch.main.view.listener.FJUAdminBlockListener;
import com.mrt.fjuteacherdispatch.main.view.listener.FJUStudentBlockListener;
import com.mrt.fjuteacherdispatch.main.view.listener.FJUTeacherBlockListener;

public class UserTypePageAdapter extends FragmentStateAdapter {

    private Fragment mFragment;

    private int userType;

    private String userMail;

    public UserTypePageAdapter(
            FragmentManager fragmentManager,
            Lifecycle lifecycle,
            int userType,
            String userMail
            ) {
        super(fragmentManager, lifecycle);
        this.userType = userType;
        this.userMail = userMail;
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    @Override
    public Fragment createFragment(int position) {
        switch (userType) {
            case 1:
                mFragment = FJUStudentBlockFragment.newInstance(userMail);
                break;
            case 2:
                mFragment = FJUTeacherBlockFragment.newInstance(userMail);
                break;
            case 3:
                mFragment = FJUAdminBlockFragment.newInstance();
                break;
            default:
                break;
        }
        return mFragment;
    }

    public Fragment getFragment() {
        return mFragment;
    }

    public BaseUserTypeBlockListener getListener() {
        return (BaseUserTypeBlockListener) mFragment;
    }
}