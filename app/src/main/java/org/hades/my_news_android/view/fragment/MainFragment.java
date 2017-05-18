package org.hades.my_news_android.view.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.hades.my_news_android.R;
import org.hades.my_news_android.base.BaseFragment;
import org.hades.my_news_android.common.DefineView;

/**
 * Created by Hades on 17/5/15.
 */

public class MainFragment extends BaseFragment implements DefineView{

    private View mView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if(mView == null){
            mView = inflater.inflate(R.layout.main_fragment,container,false);
            initView();
            initValidata();
            initListener();
            bindData();
        }
        return mView;
    }


    @Override
    public void initView() {

    }

    @Override
    public void initValidata() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void bindData() {

    }
}
