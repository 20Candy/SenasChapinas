package com.components.buttons;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.Button;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.components.R;

public class SmallTransparentButton extends ConstraintLayout implements IButtons {

    //Atributos del componente ---------------------------------------------------------------------
    private Button tButton;
    private Drawable backgroundEnable, backgroundDisable;
    private int colorEnable, colorDisable;

    // Metodos de ContraintLayout ------------------------------------------------------------------
    public SmallTransparentButton(Context context) {
        super(context);
        initView();
    }

    public SmallTransparentButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
        declareAttr(context, attrs);
    }

    public SmallTransparentButton(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView();
        declareAttr(context, attrs);
    }

    private void initView() {
        inflate(getContext(), R.layout.small_transparent_button, this);
        tButton = findViewById(R.id.btn_transparent);
    }


    private void declareAttr(Context context, AttributeSet attrs) {
        TypedArray array = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.button, 0, 0
        );

        String text = array.getString(R.styleable.button_text);
        int textSize = array.getInt(R.styleable.button_textSize, 18);
        boolean enabled = array.getBoolean(R.styleable.button_enabled, true);
        int textColor = array.getInt(R.styleable.button_textColor, 0);
        Drawable background = array.getDrawable(R.styleable.button_background);

        if (text != null && !text.isEmpty()) {
            setText(text);
        }

        setTextSize(textSize);
        setEnabled(enabled);

        if (textColor != 0) {
            setTextColor(textColor);
        }

        if (background != null) {
            setBackground(background);
        }

    }

    // Metodos de IButtons -------------------------------------------------------------------------
    @Override
    public void setText(String value) {
        tButton.setText(value);
    }

    @Override
    public void setTextSize(int value) {
        tButton.setTextSize(value);
    }

    @Override
    public void setEnabled(boolean value) {
        Drawable background = value ? backgroundEnable : backgroundDisable;
        int textColor = value ? colorEnable : colorDisable;

        if (background == null) { // Si no se ha definido un fondo personalizado, utiliza el predeterminado.
            background = ContextCompat.getDrawable(getContext(), value ? R.drawable.transparent_green_button : R.drawable.transparent_light_green_button);
        }

        if (textColor == 0) { // Si no se ha definido un color de texto personalizado, utiliza el predeterminado.
            textColor = ContextCompat.getColor(getContext(), value ? R.color.base_green : R.color.desable_text_green);
        }

        tButton.setBackground(background);
        tButton.setTextColor(textColor);
        tButton.setEnabled(value);
        tButton.setClickable(value);
    }


    @Override
    public void setTextColor(int color) {
        tButton.setTextColor(color);
    }

    @Override
    public void setBackground(Drawable value) {
        tButton.setBackground(value);
    }

    public void setTextColorEnable(int color) {
        this.colorEnable = color;
    }

    public void setBackgroundEnable(Drawable value) {
        this.backgroundEnable = value;
    }

    public void setTextColorDisable(int color) {
        this.colorDisable = color;
    }

    public void setBackgroundDisable(Drawable value) {
        this.backgroundDisable = value;
    }

    // Listener ------------------------------------------------------------------------------------
    public void setOnClickListener(OnClickListener listener) {
        tButton.setOnClickListener(new DebounceClickListener(listener));
    }


}