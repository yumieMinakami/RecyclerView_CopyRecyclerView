package jp.techacademy.yumie.minakami.recyclerview_copyrecyclerview.logger;

/**
 * Try to copy RecyclerView Sample from Developper's
 */

public class Log {
    // Grabbing the native values form Android's native logging facilities,
    // to make for easy migration and interop.

    public static final int NONE    = -1;
    public static final int VERBOSE = android.util.Log.VERBOSE;
    public static final int DEBUG   = android.util.Log.DEBUG;
    public static final int INFO    = android.util.Log.INFO;
    public static final int WARN    = android.util.Log.WARN;
    public static final int ERROR   = android.util.Log.ERROR;
    public static final int ASSERT  = android.util.Log.ASSERT;

    // Stres the beggining of the LogNode topology
    private static LogNode mLogNode;

    // Returns the next LogNode in the linked list.
    public static LogNode getLogNode(){
        return mLogNode;
    }

    // Set the LogNode date will be sent to
    public static void setLogNode(LogNode node){
        mLogNode = node;
    }

    // Instruct the LogNode to print the log data provided.
    // Other LogNodes can be chained to the end of the LogNode as desired.
    //
    // @param priority  : Log level of the data being logged. Verbose, Error, etc.
    // @param tag       : Tag for the log data. can be used to organize log statements
    // @param msg       : The actual message to be logged.
    // @param tr        : If an exception was thrown, this can be sent along for the logging facilities
    //                    to extract and print useful info.

    public static void println(int priority, String tag, String msg, Throwable tr){
        if(mLogNode != null){
            mLogNode.println(priority, tag, msg, tr);
        }
    }

    // same as above but no tr
    public static void println(int priority, String tag, String msg){
        println(priority, tag, msg, null);
    }

    // Print a message at VERBOSE priority
    //
    // @param tag   : Tag for the log data
    // @param msg   : The actual message to be logged
    // @param tr    : If an exception was thrown, this can be sent along for the logging facilities to extract and print useful info
    public static void v(String tag, String msg, Throwable tr){
        println(VERBOSE, tag, msg, tr);
    }

    public static void v(String tag, String msg){
        v(tag, msg, null);
    }

    // Print a message at DEBUG priority
    //
    // @param tag   : Tag for the log data
    // @param msg   : The actual message to be logged
    // @param tr    : If an exception was thrown, this can be sent along for the logging facilities to extract and print useful info
    public static void d(String tag, String msg, Throwable tr){
        println(DEBUG, tag, msg, tr);
    }

    public static void d(String tag, String msg){
        d(tag, msg, null);
    }

    // Print a message at INFO priority
    //
    // @param tag   : Tag for the log data
    // @param msg   : The actual message to be logged
    // @param tr    : If an exception was thrown, this can be sent along for the logging facilities to extract and print useful info
    public static void i(String tag, String msg, Throwable tr){
        println(INFO, tag, msg, tr);
    }

    public static void i(String tag, String msg){
        i(tag, msg, null);
    }

    // Print a message at WARN priority
    //
    // @param tag   : Tag for the log data
    // @param msg   : The actual message to be logged
    // @param tr    : If an exception was thrown, this can be sent along for the logging facilities to extract and print useful info
    public static void w(String tag, String msg, Throwable tr){
        println(WARN, tag, msg, tr);
    }

    public static void w(String tag, String msg){
        w(tag, msg, null);
    }

    // Print a message at ERROR priority
    //
    // @param tag   : Tag for the log data
    // @param msg   : The actual message to be logged
    // @param tr    : If an exception was thrown, this can be sent along for the logging facilities to extract and print useful info
    public static void e(String tag, String msg, Throwable tr){
        println(ERROR, tag, msg, tr);
    }

    public static void e(String tag, String msg){
        e(tag, msg, null);
    }

    // Print a message at ASSERT priority
    //
    // @param tag   : Tag for the log data
    // @param msg   : The actual message to be logged
    // @param tr    : If an exception was thrown, this can be sent along for the logging facilities to extract and print useful info
    public static void wtf(String tag, String msg, Throwable tr){
        println(ASSERT, tag, msg, tr);
    }

    public static void wtf(String tag, String msg){
        wtf(tag, msg, null);
    }

    public static void wtf(String tag, Throwable tr){
        wtf(tag, null, tr);
    }
}
