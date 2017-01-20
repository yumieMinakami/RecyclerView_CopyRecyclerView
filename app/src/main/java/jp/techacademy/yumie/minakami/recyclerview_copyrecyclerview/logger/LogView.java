package jp.techacademy.yumie.minakami.recyclerview_copyrecyclerview.logger;

import android.app.Activity;
import android.content.Context;
import android.support.v4.media.MediaMetadataCompat;
import android.util.*;
import android.util.Log;
import android.widget.TextView;

/**
 * Try to copy RecyclerView Sample from Developper's
 */

// Simple TextVeiw which is used to output log data received through the LogNode interface
public class LogView extends TextView implements LogNode {

    public LogView(Context context){
        super(context);
    }

    public LogView(Context context, AttributeSet attrs){
        super(context, attrs);
    }

    public LogView(Context context, AttributeSet attrs, int defStyle){
        super(context, attrs, defStyle);
    }

    // Format the log data & prints it out to the LogView
    @Override
    public void println(int priority, String tag, String msg, Throwable tr){

        String priorityStr = null;

        // For the purpose of this view,
        // we want to print the priority as readable txt
        switch (priority){
            case android.util.Log.VERBOSE:
                priorityStr = "VERBOSE";
                break;
            case Log.DEBUG:
                priorityStr = "DEBUG";
                break;
            case Log.INFO:
                priorityStr = "INFO";
                break;
            case Log.WARN:
                priorityStr = "WARN";
                break;
            case Log.ERROR:
                priorityStr = "ERROR";
                break;
            case Log.ASSERT:
                priorityStr = "ASSERT";
                break;
            default:
                break;
        }

        // Handly, the Log class has a facility for converting a sta trace into an usable string
        String exceptionStr = null;
        if(tr != null){
            exceptionStr = android.util.Log.getStackTraceString(tr);
        }

        // Take the priority, tag, msg, exception and concatenate as necessary
        // into one usable line of text
        final StringBuilder outputBuilder = new StringBuilder();

        String delimiter = "\t";
        appendIfNotNull(outputBuilder, priorityStr, delimiter);
        appendIfNotNull(outputBuilder, tag, delimiter);
        appendIfNotNull(outputBuilder, msg, delimiter);
        appendIfNotNull(outputBuilder, exceptionStr, delimiter);

        // In case this was originally calld from an AsycnTask or some other off-UI thread,
        // make sure the update occurs within the UI thread
        ((Activity) getContext()).runOnUiThread((new Thread(new Runnable(){
            @Override
            public void run(){
                // Display the text we just generated within the LogView
                appendToLog(outputBuilder.toString());
            }
        })));

        if(mNext != null){
            mNext.println(priority, tag, msg, tr);
        }
    }

    public LogNode getNext(){
        return mNext;
    }

    public void setNext(LogNode node){
        mNext = node;
    }

    private StringBuilder appendIfNotNull(StringBuilder src, String addStr, String delimiter){
        if(addStr != null){
            if(addStr.length() == 0){
                delimiter = "";
            }
            return src.append(addStr).append(delimiter);
        }
        return src;
    }

    // The next NLogNode in the chain
    LogNode mNext;

    // Output the string as a new line of log data in the LogView
    public void appendToLog(String s){
        append("\n" + s);
    }
}
