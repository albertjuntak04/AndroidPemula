package com.example.itd_stu.project_dicoding;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/**
 * Created by ITD-STU on 6/8/19.
 */

public class ListProductAdapter extends RecyclerView.Adapter<ListProductAdapter.CategoryViewHolder> {
    private Context context;
    private ArrayList<Product> listProduct;

    private ArrayList<Product> getListProduct() {
        return listProduct;
    }

    void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    ListProductAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_product, viewGroup, false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, final int position) {
        categoryViewHolder.tvName.setText(getListProduct().get(position).getName());
        categoryViewHolder.tvRemarks.setText(getListProduct().get(position).getRemarks());

        Glide.with(context)
                .load(getListProduct().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.imgPhoto);
        categoryViewHolder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, Display.class);
                intent.putExtra("image_url",getListProduct().get(position).getPhoto());
                intent.putExtra("image_name",getListProduct().get(position).getName());
                intent.putExtra("price",getListProduct().get(position).getPrice());
                intent.putExtra("deskripsi",getListProduct().get(position).getDeskripsi());
                intent.putExtra("display",getListProduct().get(position).getDisplay());
                intent.putExtra("size",getListProduct().get(position).getSize());
                intent.putExtra("feature",getListProduct().get(position).getFeatures());
                intent.putExtra("camera",getListProduct().get(position).getCamera());
                intent.putExtra("toko",getListProduct().get(position).getToko());
                intent.putExtra("pemilik",getListProduct().get(position).getPemilik());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getListProduct().size();
    }

    class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tvName;
        TextView tvRemarks;
        ImageView imgPhoto;
        RelativeLayout layout;

        CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvRemarks = itemView.findViewById(R.id.tv_item_remarks);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            layout=(RelativeLayout) itemView.findViewById(R.id.item_product);

        }
    }
}
