package jp.techacademy.yumie.minakami.recyclerview_copyrecyclerview.logger;

import android.util.Log;
/**
 * Try to copy RecyclerView Sample from Developper's
 */

// Helper class which wraps Android's native Log utility in the Logger interface
// This way normal DDMS output can be one of the many targets receiving & outputting logs simultaneously
public class LogWrapper implements LogNode {

    // For piping:
    //      The next node to receive Log data after this one has done its work
    private LogNode mNext;

    // Return the next LogNode in the linked list
    public LogNode getNext(){
        return mNext;
    }

    // Set the LogNode data will be sent to
    public void setNext(LogNode node){
        mNext = node;
    }

    // Print data out to the console using Android's native log mechanism
    @Override
    public void println(int priority, String tag, String msg, Throwable tr){
        // There actually are log methods that don't take a msg param.
        // for now, if that(s the case, just conver null to the empty string & mode on
        String useMsg = msg;
        if(useMsg == null){
            useMsg = "";
        }

        // If an exception was provided, convert that exception to an usable string &
        // attach it to the end of the msg method
        if(tr != null){
            msg += "\n" + Log.getStackTraceString(tr);
        }

        // This is functionally identical to Log.x(tag, useMsg);
        // For instance, if priority were Log.VERBOSE, this toul be the same as Log.v(tag, useMsg)
        Log.println(priority, tag, useMsg);

        // If this isn't the last node in the chain, move things along
        if(mNext != null){
            mNext.println(priority, tag, msg, tr);
        }
    }
}
