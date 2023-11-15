package com.mrt.fjuteacherdispatch.tool;

import android.text.Editable;
import android.util.Log;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateTextWatcher implements TextWatcher {
    protected static final String TAG = "DateTextWatcher";

    public static final int TAG_DATE_TYPE_AD = 1;//西元

    public static final int TAG_DATE_TYPE_ROC = 2;//民國 MMM 三位年

    public static final int TAG_DATE_TYPE_CREDIT_CARD = 3;//信用卡到期日 分隔 -

    public static final int TAG_DATE_TYPE_CREDIT_CARD_V2 = 4;//信用卡到期日 分隔 /

    public static final int TAG_DATE_TYPE_CREDIT_CARD_NUMBER = 5;//信用卡卡號 分隔 -

    private int dateType;

    private EditText dateEditText;

    private View nextEditText;

    int oldLength = 0;

    //==================

    int oneMaxLen = 0;

    int twoMaxLen = 0;

    int threeMaxLen = 0;

    int fourMaxLen = 0;

    //==================

    private String patternStr = "";

    private String patternStrA = "";

    private String patternStrB = "";

    private String patternStrC = "";

    protected String checkCodeRegexs[];
    protected boolean isBlank = true;

    public DateTextWatcher(int dateType, EditText dateEditText, View nextEditText) {
        this.dateType = dateType;
        this.dateEditText = dateEditText;
        this.nextEditText = nextEditText;
        init();
    }

    private void init() {
        Log.e(TAG, "init(): " + "dateType-> " + dateType);
        //
        switch (dateType) {
            case TAG_DATE_TYPE_AD:
                oneMaxLen = 4;
                twoMaxLen = 7;
                threeMaxLen = 10;
                fourMaxLen = threeMaxLen;

                patternStr = "\\d{4}-\\d{2}-\\d{2}";
                patternStrA = "\\d{4}";
                patternStrB = "\\d{4}-\\d{2}";
                patternStrC = "\\d{4}-\\d{2}-\\d{2}";

                break;
            case TAG_DATE_TYPE_ROC:
                oneMaxLen = 3;
                twoMaxLen = 6;
                threeMaxLen = 9;
                fourMaxLen = threeMaxLen;

                patternStr = "\\d{3}-\\d{2}-\\d{2}";
                patternStrA = "\\d{3}";
                patternStrB = "\\d{3}-\\d{2}";
                patternStrC = "\\d{3}-\\d{2}-\\d{2}";

                break;
            case TAG_DATE_TYPE_CREDIT_CARD:

                oneMaxLen = 2;
                twoMaxLen = 2;
                threeMaxLen = 5;
                fourMaxLen = threeMaxLen;

                patternStr = "\\d{2}-\\d{2}";
                patternStrA = "\\d{2}";
                patternStrB = "\\d{2}-\\d{2}";
                patternStrC = "\\d{2}-\\d{2}";

                break;
            case TAG_DATE_TYPE_CREDIT_CARD_V2:

                oneMaxLen = 2;
                twoMaxLen = 2;
                threeMaxLen = 5;
                fourMaxLen = threeMaxLen;

                patternStr = "\\d{2}/\\d{2}";
                patternStrA = "\\d{2}";
                patternStrB = "\\d{2}/\\d{2}";
                patternStrC = "\\d{2}/\\d{2}";

                break;
            case TAG_DATE_TYPE_CREDIT_CARD_NUMBER:

                oneMaxLen = 4;
                twoMaxLen = 9;
                threeMaxLen = 14;
                fourMaxLen = 19;

                patternStr = "\\d{4}-\\d{4}-\\d{4}-\\d{4}";
                patternStrA = "\\d{4}";
                patternStrB = "\\d{4}-\\d{4}";
                patternStrC = "\\d{4}-\\d{4}-\\d{4}";

                break;
            default:
                break;
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        String date = s.toString();
        Log.e(TAG, "onTextChanged(): " + "data-> " + date);
        onCheckIn();
        // 檢查新增
        if (date.length() > oldLength) {
            oldLength = date.length();
        } else {
            oldLength = date.length();
            //
            return;
        }
        // 輸入是否空白?
        if (date.length() == 0) {
            isBlank = true;
        } else {
            isBlank = false;
        }
        //
        onTextChangedVerification(checkCodeRegexs);

        // 輸入是否空白?
        if (date.length() == 0) {
            return;
        }

//        // 可否更新?
//        if (!canUpdated) {
//            return;
//        }

        Pattern pattern = Pattern.compile(patternStr);
        Pattern patternA = Pattern.compile(patternStrA);
        Pattern patternB = Pattern.compile(patternStrB);
        Pattern patternC = Pattern.compile(patternStrC);

        Matcher matcher = pattern.matcher(date);
        Matcher matcherA = patternA.matcher(date);
        Matcher matcherB = patternB.matcher(date);
        Matcher matcherC = patternC.matcher(date);

        boolean matcherBoolean = matcher.find();
        boolean matcherBooleanA = matcherA.find();
        boolean matcherBooleanB = matcherB.find();
        boolean matcherBooleanC = matcherC.find();

        Log.e(TAG, date + " " + matcherBoolean + " " + matcherBooleanA + " " + matcherBooleanB + " " + matcherBooleanC);

        //xx0
        //x00
        //000

        if ((!matcherBoolean) && (!matcherBooleanC) && (!matcherBooleanB) && (matcherBooleanA) && (date.length() == oneMaxLen)) {
            if (dateType == TAG_DATE_TYPE_CREDIT_CARD_V2) {
                dateEditText.setText(date + "/");
            } else {
                dateEditText.setText(date + "-");
            }
            dateEditText.setSelection(dateEditText.getText().toString().length());
        } else if ((!matcherBoolean) && (!matcherBooleanC) && (matcherBooleanB) && (matcherBooleanA) && (date.length() == twoMaxLen)) {
            if (dateType == TAG_DATE_TYPE_CREDIT_CARD_V2) {
                dateEditText.setText(date + "/");
            } else {
                dateEditText.setText(date + "-");
            }
            dateEditText.setSelection(dateEditText.getText().toString().length());
            cardNumber8(date);
        } else if ((!matcherBoolean) && (matcherBooleanC) && (matcherBooleanB) && (matcherBooleanA) && (date.length() == threeMaxLen)) {
            if (dateType == TAG_DATE_TYPE_CREDIT_CARD_V2) {
                dateEditText.setText(date + "/");
            } else {
                dateEditText.setText(date + "-");
            }
            dateEditText.setSelection(dateEditText.getText().toString().length());
        } else if ((matcherBoolean) && (matcherBooleanC) && (matcherBooleanB) && (matcherBooleanA) && (date.length() == fourMaxLen)) {
            if (nextEditText != null)
                nextEditText.requestFocus();
            cardNumber16(date);
        } else if (date.length() > fourMaxLen) {
            dateEditText.setText(date.substring(0, fourMaxLen));
            dateEditText.setSelection(dateEditText.getText().toString().length());
        } else {
            specialCase(date);
        }
    }

    public void onTextChangedVerification(String[] checkCodeRegexs) {

    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    private void specialCase(String date) {
        if (dateType == TAG_DATE_TYPE_ROC) {
            //第一位 補0
            if (date.length() == 1 && (!date.equals("1") && !date.equals("0"))) {
                Log.e(TAG, "specialCase ");
                dateEditText.setText("0" + date);
                dateEditText.setSelection(dateEditText.getText().toString().length());
            }
        }
    }

    /**
     * 輸入八位卡號
     */
    public void cardNumber8(String number) {

    }

    /**
     * 輸入十六位卡號
     */
    public void cardNumber16(String number) {

    }

    /**
     * 輸入
     */
    public void onCheckIn() {

    }
}