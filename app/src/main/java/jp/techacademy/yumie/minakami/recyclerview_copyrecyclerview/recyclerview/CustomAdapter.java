package jp.techacademy.yumie.minakami.recyclerview_copyrecyclerview.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import jp.techacademy.yumie.minakami.recyclerview_copyrecyclerview.R;
import jp.techacademy.yumie.minakami.recyclerview_copyrecyclerview.logger.Log;

/**
 * Try to copy RecyclerView Sample from Developper's
 */

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private static final String TAG  ="CustomAdapter";
    private String[] mDataset;

    // BEGIN_INCLUDE {recyclerViewSampleViewHolder]
    // Provide a reference to the type of views that you are using
    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView textView;

        public ViewHolder(View v){
            super(v);

            Log.d("cprv", "ViewHolder of ViewHolder @ CustomAdapter");


            // Deine click listener for the ViewHolder's view
            v.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v){
                    Log.d(TAG, "Element " + getPosition() + " clicked");
                }
            });
            textView = (TextView) v.findViewById(R.id.textView);
        }

        public TextView getTextView(){

            Log.d("cprv", "getTextView of ViewHolder @ CustomAdapter");

            return textView;
        }
    }
    // END_INCLUDE

    // Initialize the dataset of the Adapter
    public CustomAdapter(String[] dataSet){
        mDataset = dataSet;

        Log.d("cprv", "CustomAdapter @ CustomAdapter");

    }

    // BEGIN_INCLUDE
    // Create new views
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewTyep){
        // create a new view
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);


        Log.d("cprv", "onCreateViewHolder @ CustomAdapter");

        return new ViewHolder(v);
    }
    // END_INCLUDE

    // BEGIN_INCLUDE
    // replace the content of a view
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position){
        Log.d(TAG, "Element " + position + " set.");


        Log.d("cprv", "onBindViewHolder @ CustomAdapter");

        // get element form your dataset at this positon & replace the contents of the view
        viewHolder.getTextView().setText(mDataset[position]);
    }
    // END_INCLUDE

    // return the size of your dataset
    @Override
    public int getItemCount(){

        Log.d("cprv", "getItemCount @ CustomAdapter");

        return mDataset.length;
    }
}
