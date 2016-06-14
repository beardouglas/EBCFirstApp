package samples.fabric.io.ebcfirstapp;

import android.app.Application;

/**
 * Created by bdouglas on 6/13/16.
 */
public class EBCApplication extends Application {

    int currentVal;

    @Override
    public void onCreate() {
        super.onCreate();
        currentVal = 0;
    }

    public int getCurrentVal() {
        return currentVal;
    }

    public void setCurrentVal(int val) {
        currentVal = val;
    }
}
