package com.example.vladislavsvasiljevs.pchub;

import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import top.defaults.colorpicker.ColorPickerView;

public class lightControlActivity extends AppCompatActivity {

    private static final String SAVED_STATE_KEY_COLOR = "saved_state_key_color";
    private static final int INITIAL_COLOR = 0xFF003b8c;

    @BindView(R.id.colorPicker) ColorPickerView colorPickerView;
    //@BindView(R.id.pickedColor) View pickedColor;
    //@BindView(R.id.colorHex) TextView colorHex;

//    @OnClick(R.id.resetColor)
//    void resetColor() {
//        colorPickerView.reset();
//    }

//    @OnClick({R.id.pickedColor, R.id.colorHex})
//    void popup(View v) {
//        new ColorPickerPopup.Builder(this)
//                .initialColor(colorPickerView.getColor())
//                .enableAlpha(false)
//                .okTitle("Choose")
//                .cancelTitle("Cancel")
//                .showIndicator(false)
//                .showValue(false)
//                .build()
//                .show(new ColorPickerPopup.ColorPickerObserver() {
//                    @Override
//                    public void onColorPicked(int color) {
//                        v.setBackgroundColor(color);
//                        colorPickerView.setInitialColor(color);
//                    }
//
//                    @Override
//                    public void onColor(int color, boolean fromUser) {
//
//                    }
//                });
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_control);
        ButterKnife.bind(this);

        colorPickerView.subscribe((color, fromUser) -> {
            //pickedColor.setBackgroundColor(color);
           // colorHex.setText(colorHex(color));

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().setStatusBarColor(color);
            }
            ActionBar actionBar = getSupportActionBar();
            if (actionBar != null) {
                actionBar.setBackgroundDrawable(new ColorDrawable(color));
            }
        });

        int color = INITIAL_COLOR;
        if (savedInstanceState != null) {
            color = savedInstanceState.getInt(SAVED_STATE_KEY_COLOR, INITIAL_COLOR);
        }
        colorPickerView.setInitialColor(color);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(SAVED_STATE_KEY_COLOR, colorPickerView.getColor());
    }

//    private String colorHex(int color) {
//        int a = Color.alpha(color);
//        int r = Color.red(color);
//        int g = Color.green(color);
//        int b = Color.blue(color);
//        return String.format(Locale.getDefault(), "0x%02X%02X%02X%02X", a, r, g, b);
//    }
}
