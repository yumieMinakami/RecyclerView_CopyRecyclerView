package jp.techacademy.yumie.minakami.recyclerview_copyrecyclerview.logger;

/**
 * Try to copy RecyclerView Sample from Developper's
 */

// Simple {@Link LogNode} filter, removes everything except the msg
// useful for situations like on-screen log output where you don't want alot of metaaata displayed,
// just easy2read msg updates as they're happening

public class MessageOnlyLogFilter implements LogNode {

    LogNode mNext;

    // Takes the "next" LogNode as a param, to simplify chaining
    public MessageOnlyLogFilter(LogNode next){
        mNext = next;
    }

    public MessageOnlyLogFilter(){}

    @Override
    public void println(int priority, String tag, String msg, Throwable tr){
        if(mNext != null){
            getNext().println(Log.NONE, null, msg, null);
        }
    }

    // return the next LogNode in the chain
    public LogNode getNext(){
        return mNext;
    }

    // Set the LogNode data will be sent to
    public void setNext(LogNode node) {
        mNext = node;
    }
}
