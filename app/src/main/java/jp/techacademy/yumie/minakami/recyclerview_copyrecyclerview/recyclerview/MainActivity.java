package jp.techacademy.yumie.minakami.recyclerview_copyrecyclerview.recyclerview;

import android.support.v4.app.FragmentTransaction;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ViewAnimator;

import jp.techacademy.yumie.minakami.recyclerview_copyrecyclerview.R;
import jp.techacademy.yumie.minakami.recyclerview_copyrecyclerview.activities.SampleActivityBase;
import jp.techacademy.yumie.minakami.recyclerview_copyrecyclerview.logger.Log;
import jp.techacademy.yumie.minakami.recyclerview_copyrecyclerview.logger.LogFragment;
import jp.techacademy.yumie.minakami.recyclerview_copyrecyclerview.logger.LogWrapper;
import jp.techacademy.yumie.minakami.recyclerview_copyrecyclerview.logger.MessageOnlyLogFilter;

public class MainActivity extends SampleActivityBase {

    public static final String TAG = "MainActivity";

    // whether the Log Fragment is currently shown
    private boolean mLogShown;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("cprv", "onCreate @ MainActivity");


        if(savedInstanceState == null){
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            RecyclerViewFragment fragment = new RecyclerViewFragment();
            transaction.replace(R.id.sample_content_fragment, fragment);
            transaction.commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Log.d("cprv", "onCreateOptionsMenu @ MainActivity");

        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu){
        MenuItem logToggle = menu.findItem(R.id.menu_toggle_log);
        logToggle.setVisible(findViewById(R.id.sample_output) instanceof ViewAnimator);
        logToggle.setTitle(mLogShown ? "HideLog" : "ShowLog");

        Log.d("cprv", "onPrepareOptionsMenu @ MainActivity");


        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.menu_toggle_log:
                mLogShown = !mLogShown;
                ViewAnimator output = (ViewAnimator) findViewById(R.id.sample_output);
                if(mLogShown){
                    output.setDisplayedChild(1);
                } else {
                    output.setDisplayedChild(0);
                }
                supportInvalidateOptionsMenu();
                return true;
        }

        Log.d("cprv", "onOptionsItemSelected @ MainActivity");


        return super.onOptionsItemSelected(item);

    }

//    // create a chain of targets that will receive log data
//    @Override
//    public void initializeLogging(){
//        // Wrap Android's ntive log framework
//        LogWrapper logWrapper = new LogWrapper();
//        // Using log front end to the loging chain
//        Log.setLogNode(logWrapper);
//
//        // filter strips out everything except the messge txt
//        MessageOnlyLogFilter msgFilter = new MessageOnlyLogFilter();
//        logWrapper.setNext(msgFilter);
//
//        // on screen logging via fragment with textview
//        LogFragment logFragment = (LogFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.log_fragment);
//        msgFilter.setNext(logFragment.getLogView());
//
//        Log.i(TAG, "Ready");
//    }
}
