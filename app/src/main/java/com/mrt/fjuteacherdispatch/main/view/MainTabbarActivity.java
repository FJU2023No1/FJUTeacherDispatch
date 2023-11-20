package com.mrt.fjuteacherdispatch.main.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.activity.result.ActivityResultLauncher;
import androidx.annotation.DrawableRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentManager;

import com.mrt.fjuteacherdispatch.R;
import com.mrt.fjuteacherdispatch.databinding.FjuTdAppActivityMainTabbarBinding;
import com.mrt.fjuteacherdispatch.main.model.MainTabbarModel;
import com.mrt.fjuteacherdispatch.main.presenter.MainTabbarPresenter;
import com.mrt.fjuteacherdispatch.main.view.adapter.BaseFragmentPagerAdapter;
import com.mrt.fjuteacherdispatch.main.view.fragment.HomePageFragment;
import com.mrt.fjuteacherdispatch.main.view.listener.MainTabbarListener;
import com.mrt.fjuteacherdispatch.tool.SpecialTabDefault;
import com.mrt.fjuteacherdispatch.tool.SpecialTabNot;
import com.mrt.fjuteacherdispatch.tool.SpecialTabRound;

import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.listener.SimpleTabItemSelectedListener;

public class MainTabbarActivity extends AppCompatActivity implements MainTabbarListener {

    private FjuTdAppActivityMainTabbarBinding binding;

    private MainTabbarPresenter mPresenter;

    private MainTabbarModel mModel;

    private BaseFragmentPagerAdapter mAdapter;

    public static void startActivity(
            Activity activity,
            boolean isFinish) {
        Intent intent = createIntent(activity);
        activity.startActivity(intent);

        if (isFinish) {
            activity.finish();
        }
    }

    public static void startActivityForResultLauncher(
            Context context,
            ActivityResultLauncher<Intent> activityResultLauncher) {
        Intent intent = createIntent(context);
        activityResultLauncher.launch(intent);
    }

    public static Intent createIntent(Context context) {
        return new Intent(context, MainTabbarActivity.class);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(
                this,
                R.layout.fju_td_app_activity_main_tabbar
        );
        mModel = new MainTabbarModel();
        mPresenter = new MainTabbarPresenter(this, mModel, this);

        initView();
        mPresenter.init();
    }

    private void initView() {
        mAdapter = new BaseFragmentPagerAdapter(getSupportFragmentManager());

        mAdapter.addFragment(HomePageFragment.newInstance(),
                HomePageFragment.FRAGMENT_TAG_NAME);
        binding.viewPager.setAdapter(mAdapter);

        mModel.setNavigationController(binding.tabBar
                .custom()
                .addItem(newNotItem(R.drawable.fju_td_app_tabbar_default_left_white))
                .addItem(newDefaultItem(
                        R.drawable.icon_notification1,
                        R.drawable.icon_notification1,
                        R.drawable.fju_td_app_tabbar_default_white,
                        "訊息中心")
                )
                .addItem(newNotItem(R.drawable.fju_td_app_tabbar_default_white))
                .addItem(newRoundItem(
                        R.drawable.icon_add1,
                        R.drawable.icon_add1,
                        "Add")
                )
                .addItem(newNotItem(R.drawable.fju_td_app_tabbar_default_white))
                .addItem(newDefaultItem(
                        R.drawable.icon_setting1,
                        R.drawable.icon_setting1,
                        R.drawable.fju_td_app_tabbar_default_white,
                        "我的設定")
                )
                .addItem(newNotItem(R.drawable.fju_td_app_tabbar_default_right_white))
                .build());

        mModel.getNavigationController().addSimpleTabItemSelectedListener(new SimpleTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                mPresenter.tabbarItemOnClick(index, old);
            }
        });
    }

    protected BaseTabItem newNotItem(@DrawableRes int backgroundDrawable) {
        SpecialTabNot mainTab = new SpecialTabNot(this);
        mainTab.setTabBackground(ContextCompat.getDrawable(this, backgroundDrawable));
        return mainTab;
    }

    protected BaseTabItem newDefaultItem(
            @DrawableRes int drawable,
            @DrawableRes int checkedDrawable,
            @DrawableRes int backgroundDrawable,
            String text) {
        SpecialTabDefault mainTab = new SpecialTabDefault(this);
        mainTab.initialize(drawable, checkedDrawable, text);
        mainTab.setTextDefaultColor(ContextCompat.getColor(this, R.color.fju_td_app_gray_a5a5a5));
        mainTab.setTabBackground(ContextCompat.getDrawable(this, backgroundDrawable));
        return mainTab;
    }

    protected BaseTabItem newRoundItem(
            @DrawableRes int drawable,
            @DrawableRes int checkedDrawable,
            String text) {
        SpecialTabRound mainTab = new SpecialTabRound(this);
        mainTab.initialize(drawable, checkedDrawable, text);
        mainTab.setTextDefaultColor(ContextCompat.getColor(this, R.color.fju_td_app_gray_a5a5a5 ));
        return mainTab;
    }
}