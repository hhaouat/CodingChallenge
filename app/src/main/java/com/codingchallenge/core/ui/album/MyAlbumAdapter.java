package com.codingchallenge.core.ui.album;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingchallenge.R;
import com.codingchallenge.core.model.Album;
import com.codingchallenge.core.ui.photo.PhotoActivity;

import java.util.List;

/**
 * Created by Toshiba on 08/11/2015.
 */

public class MyAlbumAdapter extends RecyclerView.Adapter<AlbumViewHolder> {

    List<Album> albumList;
    private Context context;

    //ajouter un constructeur prenant en entrée une liste
    public MyAlbumAdapter(List<Album> list) {
        this.albumList = list;
    }
    public MyAlbumAdapter(Context context, int resource, List<Album> objects) {
       // super(context, resource, objects);
        this.context = context;
        this.albumList = objects;
    }

    //cette fonction permet de créer les viewHolder
    //et par la même indiquer la vue à inflater (à partir des layout xml)
    @Override
    public AlbumViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.album_row,viewGroup,false);
        return new AlbumViewHolder(view);
    }

    //c'est ici que nous allons remplir notre cellule avec le texte/image de chaque MyObjects
    @Override
    public void onBindViewHolder(AlbumViewHolder myViewHolder, int position) {
        final Album myObject = albumList.get(position);
        myViewHolder.bind(myObject);

        myViewHolder.mTitleText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PhotoActivity.class);
                intent.putExtra("albumId", myObject.getId());
                v.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return albumList.size();
    }

}