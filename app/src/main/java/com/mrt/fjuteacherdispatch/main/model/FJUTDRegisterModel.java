package com.mrt.fjuteacherdispatch.main.model;

import androidx.databinding.ObservableField;

public class FJUTDRegisterModel {

    /**
     * 國籍.
     */
    public final ObservableField<String> userInfoCountryText = new ObservableField<>();

    /**
     * 國籍檢核錯誤訊息.
     */
    public final ObservableField<String> userInfoCountryWrong = new ObservableField<>();

    /**
     * 真實姓名.
     */
    public final ObservableField<String> userInfoNameText = new ObservableField<>();

    /**
     * 真實姓名檢核錯誤訊息.
     */
    public final ObservableField<String> userInfoNameWrong = new ObservableField<>();

    /**
     * 身分證字號.
     * 居留證統一編號.
     */
    public final ObservableField<String> userInfoIDNoText = new ObservableField<>();

    /**
     * 身分證字號檢核錯誤訊息.
     * 居留證統一編號檢核錯誤訊息.
     */
    public final ObservableField<String> userInfoIDNoWrong = new ObservableField<>();

    /**
     * 出生日期.
     */
    public final ObservableField<String> userInfoBirthDateText = new ObservableField<>("");

    /**
     * 出生日期檢核錯誤訊息.
     */
    public final ObservableField<String> userInfoBirthDateWrong = new ObservableField<>();
}
