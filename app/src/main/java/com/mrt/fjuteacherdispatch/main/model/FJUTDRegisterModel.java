package com.mrt.fjuteacherdispatch.main.model;

import androidx.databinding.ObservableField;

import com.mrt.fjuteacherdispatch.tool.ClickLock;
import com.mrt.fjuteacherdispatch.tool.menu.model.data.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class FJUTDRegisterModel {

    public FJUTDRegisterModel() {
        clickLock = new ClickLock();
    }

    private ClickLock clickLock;

    public ClickLock getClickLock() {
        return clickLock;
    }

    public List<MenuItem> userInfoGenderlist = new ArrayList<>();

    public List<MenuItem> userInfoCountrylist = new ArrayList<>();

    public List<MenuItem> userInfoSubjectlist = new ArrayList<>();

    public List<MenuItem> userInfoLanguagelist = new ArrayList<>();

    /**
     * 真實姓名.
     */
    public final ObservableField<String> userInfoNameText = new ObservableField<>();

    /**
     * 真實姓名檢核錯誤訊息.
     */
    public final ObservableField<String> userInfoNameWrong = new ObservableField<>();

    /**
     * 出生日期.
     */
    public final ObservableField<String> userInfoBirthDateText = new ObservableField<>("");

    /**
     * 出生日期檢核錯誤訊息.
     */
    public final ObservableField<String> userInfoBirthDateWrong = new ObservableField<>();

    /**
     * 性別.
     */
    public final ObservableField<String> userInfoGenderText = new ObservableField<>();

    /**
     * 性別檢核錯誤訊息.
     */
    public final ObservableField<String> userInfoGenderWrong = new ObservableField<>();

    /**
     * 國籍.
     */
    public final ObservableField<String> userInfoCountryText = new ObservableField<>();

    /**
     * 國籍檢核錯誤訊息.
     */
    public final ObservableField<String> userInfoCountryWrong = new ObservableField<>();

    /**
     * 科目.
     */
    public final ObservableField<String> userInfoSubjectText = new ObservableField<>();

    /**
     * 科目錯誤訊息.
     */
    public final ObservableField<String> userInfoSubjectWrong = new ObservableField<>();

    /**
     * 語言.
     */
    public final ObservableField<String> userInfoLanguageText = new ObservableField<>();

    /**
     * 語言檢核錯誤訊息.
     */
    public final ObservableField<String> userInfoLanguageWrong = new ObservableField<>();

    public final ObservableField<String> userMail = new ObservableField<>();

    public final ObservableField<String> userIdentityID = new ObservableField<>();
}
