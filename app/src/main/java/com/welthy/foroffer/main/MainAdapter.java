package com.welthy.foroffer.main;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.welthy.foroffer.R;
import com.welthy.foroffer.articledetail.ArticleDetailActivity;
import com.welthy.foroffer.bean.ArticleBean;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ArticleViewHolder> {

    private Context mContext;
    private List<ArticleBean> mDatas;

    public MainAdapter(Context context, List<ArticleBean> datas) {
        this.mContext = context;
        this.mDatas = datas;
    }

    @NonNull
    @Override
    public ArticleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(mContext).inflate(R.layout.main_article_adapter_item,parent,false);
        return new ArticleViewHolder(root);
    }

    @Override
    public void onBindViewHolder(@NonNull ArticleViewHolder holder, int position) {
        holder.title.setText(mDatas.get(position).getTitle());
        holder.author.setText(mDatas.get(position).getAuthor());
        if ("".equals(mDatas.get(position).getAbstractMsg())) {
            holder.abstractMsg.setVisibility(View.GONE);
        }else {
            holder.abstractMsg.setText(mDatas.get(position).getAbstractMsg());
        }
        Glide.with(mContext)
                .load(mContext.getResources().getDrawable(R.mipmap.zjn03))
                .into(holder.abstractImg);

        holder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent detailIt = new Intent(mContext, ArticleDetailActivity.class);
                detailIt.putExtra("item",position);
                mContext.startActivity(detailIt);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public void updateDatas(List<ArticleBean> mDatas) {
        this.mDatas = mDatas;
        notifyDataSetChanged();
    }

    public void addData(ArticleBean ab) {
        mDatas.add(0,ab);
        notifyItemInserted(0);
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder {
        RelativeLayout root;
        TextView title;
        TextView abstractMsg;
        TextView author;
        ImageView abstractImg;

        public ArticleViewHolder(@NonNull View itemView) {
            super(itemView);
            root = itemView.findViewById(R.id.main_recyclerview_root);
            title = itemView.findViewById(R.id.title);
            abstractMsg = itemView.findViewById(R.id.abstract_msg);
            abstractImg = itemView.findViewById(R.id.abstract_img);
            author = itemView.findViewById(R.id.abstract_author);
        }
    }
}
