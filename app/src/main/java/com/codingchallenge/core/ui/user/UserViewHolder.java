package com.codingchallenge.core.ui.user;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.codingchallenge.R;
import com.codingchallenge.core.model.User;

/**
 * Created by Toshiba on 08/11/2015.
 */

public class UserViewHolder extends RecyclerView.ViewHolder{


    public TextView mUserName;
    public ImageView mImage;

    //itemView est la vue correspondante à 1 cellule
    public UserViewHolder(View itemView) {
        super(itemView);

        mUserName = (TextView) itemView.findViewById(R.id.name);
        mImage = (ImageView) itemView.findViewById(R.id.img);
    }

    //puis ajouter une fonction pour remplir la cellule en fonction d'un MyObject
    public void bind(Context context, User user){
        mUserName.setText(user.getName());
    }
}