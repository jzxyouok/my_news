package org.hades.my_news_android.view.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.hades.my_news_android.R;
import org.hades.my_news_android.base.BaseActivity;
import org.hades.my_news_android.view.widget.CustomVideoView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Hades on 17/5/15.
 */
public class WelcomeActivity extends BaseActivity {

    @BindView(R.id.welcome_videoview)
    public CustomVideoView welcome_videoview;
    @BindView(R.id.welcome_button)
    public Button welcome_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        ButterKnife.bind(this);

        welcome_videoview.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() +
                "/"+R.raw.kr36));
        welcome_videoview.start();
        welcome_videoview.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                welcome_videoview.start();
            }
        });

        welcome_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (welcome_videoview.isPlaying()) {
                    welcome_videoview.stopPlayback();
                    welcome_videoview = null;
                }
                openActivity(MainActivity.class);
                WelcomeActivity.this.finish();
            }
        });
    }
}
