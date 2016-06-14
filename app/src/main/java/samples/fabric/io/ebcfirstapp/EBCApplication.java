package samples.fabric.io.ebcfirstapp;

import android.app.Application;
import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import io.fabric.sdk.android.Fabric;

/**
 * Created by bdouglas on 6/13/16.
 */
public class EBCApplication extends Application {

    // Note: Your consumer key and secret should be obfuscated in your source code before shipping.
    private static final String TWITTER_KEY = "wt9SwLJpewOSOlWpNaQKcJmYz";
    private static final String TWITTER_SECRET = "VAoCzRM4l2Jgl9sn9ZIAefciUZibjzHuiWapUmOhE0lAMhMzbu";


    int currentVal;

    @Override
    public void onCreate() {
        super.onCreate();
        TwitterAuthConfig authConfig = new TwitterAuthConfig(TWITTER_KEY, TWITTER_SECRET);
        Fabric.with(this, new Twitter(authConfig));
        currentVal = 0;
    }

    public int getCurrentVal() {
        return currentVal;
    }

    public void setCurrentVal(int val) {
        currentVal = val;
    }
}
