package jp.techacademy.yumie.minakami.recyclerview_copyrecyclerview.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
//import android.util.Log;

import jp.techacademy.yumie.minakami.recyclerview_copyrecyclerview.logger.Log;
import jp.techacademy.yumie.minakami.recyclerview_copyrecyclerview.logger.LogWrapper;

/**
 * Try to copy RecyclerView Sample from Developper's
 */

public class SampleActivityBase extends FragmentActivity {

    public static final String TAG = "SampleActivityBase";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d("cprv", "onCreate @ SampleActivityBase");
    }

    @Override
    protected void onStart(){
        super.onStart();
        initializeLoging();

        Log.d("cprv", "onStart @ SampleActivityBase");
    }

    // Set up targets to receive log data
    public void initializeLoging() {
        // Using Log, front-end to the logging chain,
        // emulates android.util.log method signetures.
        // Wraps Android's native log framework
        LogWrapper logWrapper = new LogWrapper();
        Log.setLogNode(logWrapper);

        Log.i(TAG, "Ready");

        Log.d("cprv", "initializeLoging @ SampleActivityBase");
    }
}
