package com.codingchallenge.core.ui.photo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingchallenge.R;
import com.codingchallenge.core.model.Photo;
import com.squareup.picasso.Picasso;

/**
 * Created by Toshiba on 08/11/2015.
 */

public class PhotoViewHolder extends RecyclerView.ViewHolder{

    public TextView mTitlePhoto;
    public ImageView mPhoto;

    public PhotoViewHolder(View itemView) {
        super(itemView);

        mTitlePhoto = (TextView) itemView.findViewById(R.id.title);
        mPhoto = (ImageView) itemView.findViewById(R.id.photo);
    }

    public void bind(Context context, Photo photo){
        mTitlePhoto.setText(photo.getTitle());
        Picasso.with(context).load(photo.getThumbnailUrl()).centerCrop().fit().into(mPhoto);
    }
}