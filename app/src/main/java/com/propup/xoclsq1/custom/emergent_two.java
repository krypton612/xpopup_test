package com.propup.xoclsq1.custom;

import android.content.Context;

import androidx.annotation.NonNull;

import com.lxj.xpopup.core.PositionPopupView;
import com.propup.xoclsq1.R;

public class emergent_two extends PositionPopupView {
    public emergent_two(@NonNull Context context, R custom_parameter) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.custom_model_popup;
    }
}

