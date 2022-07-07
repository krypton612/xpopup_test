package com.propup.xoclsq1.custom;

import android.content.Context;

import androidx.annotation.NonNull;

import com.lxj.xpopup.core.PositionPopupView;
import com.propup.xoclsq1.R;

public class emergent extends PositionPopupView {
        public emergent(@NonNull Context context) {
            super(context);
        }

        @Override
        protected int getImplLayoutId() {
            return R.layout.popup_emergent;
        }
}
