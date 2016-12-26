package com.hardwork.fg607.relaxfinger.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.hardwork.fg607.relaxfinger.R;
import com.hardwork.fg607.relaxfinger.model.ToolInfo;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by fg607 on 15-11-26.
 */
public class ToolAdapter extends BaseAdapter {

    private ArrayList<ToolInfo> mToolList;
    private Context mContext;
    private ArrayList<String> mChoosedNameList;

    public ToolAdapter(Context context){
        this.mContext = context;
    }

    public void addList(ArrayList<ToolInfo> list){

        this.mToolList = list;
    }

    public void setToolChecked(ArrayList<String> choosedNameList){

        this.mChoosedNameList = choosedNameList;

    }

    @Override
    public int getCount() {
        return mToolList!=null?mToolList.size():0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        MyHolder holder = null;

        if(view == null){

            view = View.inflate(mContext, R.layout.choosekey_item, null);

            holder = new MyHolder(view);

            view.setTag(holder);

        }else {

            holder = (MyHolder) view.getTag();
        }


        holder.icon.setBackgroundResource(R.drawable.path_blue_oval);
        holder.icon.setImageDrawable(mToolList.get(i).getToolIcon());
        holder.name.setText(mToolList.get(i).getToolName());

        if(mChoosedNameList.contains(mToolList.get(i).getToolName())){

            holder.checkBox.setChecked(true);
        }else {

            holder.checkBox.setChecked(false);
        }

        return view;
    }

    public class MyHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.image) ImageView icon;
        @BindView(R.id.text) TextView name;
        @BindView(R.id.checkbox) CheckBox checkBox;

        public MyHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
