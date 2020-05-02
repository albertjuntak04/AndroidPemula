package com.example.itd_stu.project_dicoding;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/**
 * Created by ITD-STU on 6/9/19.
 */

public class GridProductAdapter extends RecyclerView.Adapter<GridProductAdapter.GridViewHolder> {
    private Context context;
    private ArrayList<Product> listProduct;

    private ArrayList<Product> getListProduct() {
        return listProduct;
    }

    public void setListProduct(ArrayList<Product> listProduct) {
        this.listProduct = listProduct;
    }

    public GridProductAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_grid_product, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, final int position) {
        Glide.with(context)
                .load(getListProduct().get(position).getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);
        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,Display.class);
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

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
