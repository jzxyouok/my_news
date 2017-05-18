package org.hades.my_news_android.view.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.nineoldandroids.view.ViewHelper;

import org.hades.my_news_android.R;
import org.hades.my_news_android.base.BaseActivity;
import org.hades.my_news_android.common.DefineView;
import org.hades.my_news_android.view.adpater.LeftItemAdapter;
import org.hades.my_news_android.view.widget.DragLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends BaseActivity implements DefineView {

    public DragLayout getDrag_layout() {
        return drag_layout;
    }

    @BindView(R.id.drag_layout)
    public DragLayout drag_layout;
    @BindView(R.id.top_bar_icon)
    public ImageView top_bar_icon;
    @BindView(R.id.lv_left_main)
    public ListView lv_left_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setStatusBar();
        initView();
        initValidata();
        initListener();
        bindData();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initValidata() {
        lv_left_main.setAdapter(new LeftItemAdapter());
    }

    @Override
    public void initListener() {
        drag_layout.setDragListener(new CustomDragListener());
        top_bar_icon.setOnClickListener(new CustomOnClickListener());
    }

    @Override
    public void bindData() {

    }

    class CustomDragListener implements DragLayout.DragListener{

        /**
         * 界面打开
         */
        @Override
        public void onOpen() {

        }

        /**
         * 界面关闭
         */
        @Override
        public void onClose() {

        }

        /**
         * 界面进行滑动
         * @param percent
         */
        @Override
        public void onDrag(float percent) {
            ViewHelper.setAlpha(top_bar_icon,1-percent);
        }
    }
    class CustomOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View arg0) {
            drag_layout.open();
        }
    }
}
