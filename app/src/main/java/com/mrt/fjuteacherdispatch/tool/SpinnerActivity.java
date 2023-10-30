package com.mrt.fjuteacherdispatch.tool;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.mrt.fjuteacherdispatch.R;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

public class SpinnerActivity extends AppCompatActivity {
    public static final String Extra_Resource = "SpinnerActivity.Extra_Resource";
    public static final String Result_Data = "SpinnerActivity.Result_Data";

    private Context mContext;
    private AppCompatCustomSpinner mSpinner;
    private ArrayAdapter<String> mArrayAdapter;
    private ArrayList<Map.Entry<String,String>> mArrayList_resource;
    private ArrayList<String> mArrayList_value;
    private ArrayList<String> mArrayList_key;

    public static void startActivityForResultLauncher(Context context, ActivityResultLauncher<Intent> activityResultLauncher, ArrayList<Map.Entry<String,String>> data) {
        Intent intent = new Intent(context,
                SpinnerActivity.class);
        intent.putExtra(SpinnerActivity.Extra_Resource, data);
        activityResultLauncher.launch(intent);
    }

    public static void onStartActivity(Activity activity, int requestCode, ArrayList<Map.Entry<String,String>> data) {
        Intent intent = new Intent(activity,
                SpinnerActivity.class);
        intent.putExtra(SpinnerActivity.Extra_Resource, data);
        activity.startActivityForResult(intent, requestCode);
//        UIUtil.closeActivityAnim(activity);
    }

    public static void onStartActivity(Fragment mFragment, int requestCode, ArrayList<Map.Entry<String,String>> data) {
        Intent intent = new Intent(mFragment.getContext(),
                SpinnerActivity.class);
        intent.putExtra(SpinnerActivity.Extra_Resource, data);
        mFragment.startActivityForResult(intent, requestCode);
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.fjutd_app_activity_spinner);

        mSpinner = findViewById(R.id.spinner_activity_spinner);
        mContext = SpinnerActivity.this;

        mArrayList_resource = (ArrayList<Map.Entry<String,String>>) getIntent().getSerializableExtra(Extra_Resource);
        if(mArrayList_resource == null){
            finish();
        }

        mArrayList_value = new ArrayList<>();
        mArrayList_key = new ArrayList<>();

        mArrayList_key.add("0");
        mArrayList_value.add("請選擇");

        for (int i = 0; i < mArrayList_resource.size(); i++){
            Map.Entry<String, String> entry = mArrayList_resource.get(i);
//            Utility.log(String.format("SpinnerActivity -> entry: %d , %s", entry.getKey(), entry.getValue()));
            mArrayList_key.add(entry.getKey());
            mArrayList_value.add(entry.getValue());
        }

        mArrayAdapter = new ArrayAdapter<String>(SpinnerActivity.this, R.layout.fjutd_app_adapter_choose, mArrayList_value){
            @Override
            public boolean isEnabled(int position) {
                if (position == 0) {
                    return false;
                }
                return true;
            }

            @Override
            public View getDropDownView(int position, View convertView, ViewGroup parent) {
                View view = super.getDropDownView(position, convertView, parent);

                TextView tv = (TextView) view;
                if(tv.getText().toString().equalsIgnoreCase("請選擇")){
                    tv.setTextColor(Color.GRAY);

                    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                        Drawable drawable = mContext.getDrawable(R.drawable.fjutd_app_background_spinner_borderbottom);
                        tv.setBackground(drawable);
                    }

                } else {
                    tv.setTextColor(Color.BLACK);
                    if (Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
                        tv.setBackground(null);
                    } else {
                        tv.setBackgroundDrawable(null);
                    }
                }

                return view;
            }
        };

        mSpinner.setAdapter(mArrayAdapter);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(position != 0) {
                    String key = mArrayList_key.get(position);
                    String value = mArrayList_value.get(position);

                    Intent intent = new Intent();
                    intent.putExtra(Result_Data, new AbstractMap.SimpleEntry<>(key, value));
                    setResult(RESULT_OK, intent);
                    finish();
                    AnimationUtil.closeActivityAnim(SpinnerActivity.this);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        mSpinner.setSpinnerEventsListener(new AppCompatCustomSpinner.OnSpinnerEventsListener() {
            @Override
            public void onSpinnerOpened() {


            }

            @Override
            public void onSpinnerClosed() {
                if(mSpinner.getSelectedItemPosition() == 0) {
                    finish();
                }
            }
        });

        mSpinner.performClick();
    }
}

