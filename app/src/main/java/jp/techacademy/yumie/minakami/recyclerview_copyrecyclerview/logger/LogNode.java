package jp.techacademy.yumie.minakami.recyclerview_copyrecyclerview.logger;

/**
 * Try to copy RecyclerView Sample from Developper's
 */

public interface LogNode {

    // Instructs first LogNode in the list to print the log data provided

    public void println(int priority, String tag, String msg, Throwable tr);
}
