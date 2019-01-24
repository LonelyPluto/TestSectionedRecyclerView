package com.lonelypluto.testsectionedrecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lonelypluto.testsectionedrecyclerview.GlideApp;
import com.lonelypluto.testsectionedrecyclerview.R;
import com.lonelypluto.testsectionedrecyclerview.bean.MyBean;
import com.truizlop.sectionedrecyclerview.SimpleSectionedAdapter;

import java.util.List;

/**
 * @Description: 简单用法 没有footer
 * @author: ZhangYW
 * @time: 2019/1/24 9:38
 */
public class SimpleHeaderAdapter extends SimpleSectionedAdapter<SimpleHeaderAdapter.MyItemViewHolder> {

    private Context mContext;
    private List<MyBean> mList;

    public SimpleHeaderAdapter(Context context, List<MyBean> list) {
        this.mContext = context;
        this.mList = list;

    }


    @Override
    protected String getSectionHeaderTitle(int section) {
        return mList.get(section).getHeader();
    }

    /**
     * header或者footer的个数
     * @return
     */
    @Override
    protected int getSectionCount() {
        return mList.size();
    }

    /**
     * 每个header或者footer中包含具体的内容个数
     * @return
     */
    @Override
    protected int getItemCountForSection(int section) {
        return mList.get(section).getList().size();
    }

    @Override
    protected MyItemViewHolder onCreateItemViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_rv_content, parent, false);
        return new SimpleHeaderAdapter.MyItemViewHolder(itemView);
    }

    @Override
    protected void onBindItemViewHolder(MyItemViewHolder holder, int section, int position) {
        MyBean bean = mList.get(section);
        if (null == bean)
            return;
        holder.tv_name.setText(bean.getList().get(position).getContent());
        GlideApp.with(mContext)
                .load(R.mipmap.group)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .centerCrop()
                .into(holder.iv_head);
    }

    /**
     * ItemViewHolder
     */
    public class MyItemViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv_head;
        private TextView tv_name;

        public MyItemViewHolder(View itemView) {
            super(itemView);
            iv_head = (ImageView)itemView.findViewById(R.id.item_iv);
            tv_name = (TextView)itemView.findViewById(R.id.item_tv_title);
        }
    }
}
