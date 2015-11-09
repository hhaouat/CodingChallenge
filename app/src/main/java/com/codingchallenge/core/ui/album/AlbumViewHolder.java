package com.codingchallenge.core.ui.album;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.codingchallenge.R;
import com.codingchallenge.core.model.Album;

/**
 * Created by Toshiba on 08/11/2015.
 */

public class AlbumViewHolder extends RecyclerView.ViewHolder{

    /*@Bind(R.id.idAlbum)
    TextView mIdAlbumText;
    @Bind(R.id.title)
    TextView mTitleText;*/

    public TextView mIdAlbumText;
    public TextView mTitleText;

    //itemView est la vue correspondante à 1 cellule
    public AlbumViewHolder(View itemView) {
        super(itemView);
        //ButterKnife.bind(itemView);

        mIdAlbumText = (TextView) itemView.findViewById(R.id.idAlbum);
        mTitleText = (TextView) itemView.findViewById(R.id.title);
    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    public void bind(Album mAlbum){
        mTitleText.setText(mAlbum.getTitle());
        mIdAlbumText.setText(""+mAlbum.getId());
        //Picasso.with(imageView.getContext()).load(myObject.getImageUrl()).centerCrop().fit().into(imageView);
    }
}