package com.altice_crt_a.android__avanzado_4.classes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.altice_crt_a.android__avanzado_4.R;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jaime on 6/2/2018.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoHolder>{

    ArrayList<Photo> photos;

    public PhotoAdapter() {
        this.photos = new ArrayList<>();
    }

    public void updateData(List<Photo> photos){
        this.photos = new ArrayList<>(photos);
        notifyDataSetChanged();
    }

    @Override
    public PhotoHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_photo_item, parent,false);
        return new PhotoHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotoHolder holder, int position) {

        Glide.with(holder.itemView).load(photos.get(position).getThumbnailUrl()).into(holder.photoImage);
        holder.photoTitle.setText(photos.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return photos.size();
    }

    class PhotoHolder extends RecyclerView.ViewHolder{

        TextView photoTitle;
        ImageView photoImage;

        public PhotoHolder(View itemView) {
            super(itemView);

            photoTitle = itemView.findViewById(R.id.photo_title);
            photoImage = itemView.findViewById(R.id.photo_image);

        }
    }
}
