package com.xu.headline.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.github.nukc.stateview.StateView;
import com.orhanobut.logger.Logger;
import com.xu.headline.R;

/**
 * Created by xusn10 on 2018/3/15.
 */

public class TestFragment extends Fragment {
    protected StateView stateView;
    private Button button;
    private RelativeLayout constraintLayout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_personal_center, container, false);
        button = mView.findViewById(R.id.button);
        Logger.d(mView.getClass().getName());
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stateView.showLoading();
            }
        });
        constraintLayout = mView.findViewById(R.id.linearLayout2);

//        stateView = mView.findViewById(R.id.stateView);
        stateView = StateView.inject(mView);
        stateView.setLoadingResource(R.layout.layout_loading);
        return mView;
    }
}
