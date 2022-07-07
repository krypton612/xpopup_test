package com.propup.xoclsq1.custom;


import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.propup.xoclsq1.R;
import com.propup.xoclsq1.fragment.BaseFragment;


public class TestFragment extends BaseFragment {

    public static TestFragment create(String text){
        TestFragment testFragment = new TestFragment();
        Bundle bundle = new Bundle();
        bundle.putString("text", text);
        testFragment.setArguments(bundle);
        return testFragment;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.test_fragment;
    }

    @Override
    public void init(View view) {
        String text = getArguments().getString("text", "XPopup");
        view.<TextView>findViewById(R.id.tv).setText(text);
    }
}
