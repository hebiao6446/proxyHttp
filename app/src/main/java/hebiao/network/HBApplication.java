package hebiao.network;

import android.app.Application;

/**
 * Created by apple on 2018/3/21.
 */

public class HBApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        HttpHelper.init(new VolleyProcessor(this));

    }
}
