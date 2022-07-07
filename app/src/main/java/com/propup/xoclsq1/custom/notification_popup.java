package com.propup.xoclsq1.custom;

import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import com.blankj.utilcode.util.ScreenUtils;
import com.lxj.xpopup.core.PositionPopupView;
import com.propup.xoclsq1.R;


/**
 * Description: 自定义自由定位Position弹窗
 * Create by dance, at 2019/6/14
 */
public class notification_popup extends PositionPopupView {
    public notification_popup(@NonNull Context context) {
        super(context);
    }

    @Override
    protected int getImplLayoutId() {
        return R.layout.notification_pop;
    }

    @Override
    protected void onCreate() {
        super.onCreate();
        findViewById(R.id.tvClose).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
    }

    @Override
    protected int getPopupWidth() {
        return ScreenUtils.getScreenWidth();
    }
}
