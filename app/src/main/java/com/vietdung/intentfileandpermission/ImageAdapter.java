package com.vietdung.intentfileandpermission;

import android.content.Context;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private Context mContext;
    private List<String> mImages;

    public ImageAdapter(Context context, List<String> images) {
        mContext = context;
        mImages = images;
    }

    @NonNull
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_image, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ViewHolder holder, int position) {
        holder.setImage(String.valueOf(Uri.fromFile(new File(mImages.get(position)))));
    }

    @Override
    public int getItemCount() {
        return (mImages != null) ? mImages.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setTag(getAdapterPosition());
            image = itemView.findViewById(R.id.image_Picture);
        }

        public void setImage(String imagePart) {
            Glide.with(mContext).load(imagePart)
                    .into(image);
        }
    }
}
