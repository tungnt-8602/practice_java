package com.example.practivejavaandroid.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.practivejavaandroid.R;
import com.example.practivejavaandroid.model.Product;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder>{

    private Context context;
    private List<Product> productArrayList;

    private OnClickListener onClickListener;

    public ItemAdapter(Context context, List<Product> productArrayList) {
        this.context = context;
        this.productArrayList = productArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View productView = inflater.inflate(R.layout.item_recyclerview, parent, false);
        return new ViewHolder(productView);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product p = productArrayList.get(position);
        Glide.with(context).load(p.getImage()).into(holder.productThumb);
        holder.productName.setText(p.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onClickListener != null) {
                    onClickListener.onClick( position, productArrayList.get(position));
                }
            }
        });
    }

    public interface OnClickListener {
        void onClick(int position, Product p);
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }


    @Override
    public int getItemCount() {
        return productArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView productThumb;
        private TextView productName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            productThumb = itemView.findViewById(R.id.productThumb);
            productName = itemView.findViewById(R.id.productName);
        }
    }
}
