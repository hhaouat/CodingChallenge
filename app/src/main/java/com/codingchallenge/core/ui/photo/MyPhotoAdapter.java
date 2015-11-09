package com.codingchallenge.core.ui.photo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingchallenge.R;
import com.codingchallenge.core.model.Photo;

import java.util.List;

/**
 * Created by Toshiba on 08/11/2015.
 */

public class MyPhotoAdapter extends RecyclerView.Adapter<PhotoViewHolder> {

    List<Photo> photoList;
    private Context context;

    public MyPhotoAdapter(List<Photo> list) {
        this.photoList = list;
    }
    public MyPhotoAdapter(Context context, int resource, List<Photo> objects) {
        this.context = context;
        this.photoList = objects;
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.photo_row,viewGroup,false);
        return new PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder myViewHolder, int position) {
        Photo myObject = photoList.get(position);
        myViewHolder.bind(context,myObject);
    }

    @Override
    public int getItemCount() {
        return photoList.size();
    }

}