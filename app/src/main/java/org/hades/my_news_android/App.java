package org.hades.my_news_android;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by Hades on 17/5/15.
 */

public class App extends Application {

    public String url = "http://36kr.com/napi/newsflash";

    private static App instance=null;
    private static Toast toast;
    private static Handler mUIHandler = new Handler(Looper.getMainLooper());
    @Override
    public void onCreate() {
        super.onCreate();
        this.instance=this;
        toast = Toast.makeText(this, "", Toast.LENGTH_SHORT);
    }
    public static App getInstance(){
        return instance;
    }

    public static void showToastShort(final String msg){
        Log.e("App", msg);
        if (isMainLooper()){
            showToast(msg);
        }else {
            mUIHandler.post(new Runnable() {
                @Override
                public void run() {
                    showToast(msg);
                }
            });
        }
    }

    private static void showToast(String msg){
        if (toast != null) {
            toast.setText(msg);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.show();
        }
    }

    private static boolean isMainLooper(){
        return Looper.myLooper() == Looper.getMainLooper();
    }
}
