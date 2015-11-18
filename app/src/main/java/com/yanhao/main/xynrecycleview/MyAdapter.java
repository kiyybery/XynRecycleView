package com.yanhao.main.xynrecycleview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2015/11/18 0018.
 */
public class MyAdapter extends RecyclerView.Adapter<MyViewHolder> implements View.OnClickListener{

    private LayoutInflater mInflater;
    private Context mContext;
    private List<String> mDatas;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;

    public MyAdapter(Context context, List<String> list) {

        this.mContext = context;
        this.mDatas = list;
        mInflater = LayoutInflater.from(context);
    }

    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , String data);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int i) {

        myViewHolder.tv.setText(mDatas.get(i));
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = mInflater.inflate(R.layout.item_recy_tv, viewGroup, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(this);
        return myViewHolder;
    }

    public OnRecyclerViewItemClickListener getmOnItemClickListener() {
        return mOnItemClickListener;
    }

    @Override
    public void onClick(View view) {

        if(mOnItemClickListener != null){
            mOnItemClickListener.onItemClick(view,(String)view.getTag());
        }
    }
}

class MyViewHolder extends RecyclerView.ViewHolder{

    TextView tv;
    //ImageView iv;
    private MyItemClickListener mListener;

    public MyViewHolder(View itemView) {
        super(itemView);
        tv = (TextView) itemView.findViewById(R.id.id_item_tv);
        //iv = (ImageView) itemView.findViewById(R.id.id_item_iv);
    }
}
