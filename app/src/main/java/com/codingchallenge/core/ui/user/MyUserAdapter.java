package com.codingchallenge.core.ui.user;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codingchallenge.R;
import com.codingchallenge.core.model.Address;
import com.codingchallenge.core.model.User;

import java.util.List;

/**
 * Created by Hawazine on 08/11/2015.
 */

public class MyUserAdapter extends RecyclerView.Adapter<UserViewHolder> {

    List<User> userList;
    private Context context;

    public MyUserAdapter(List<User> list) {
        this.userList = list;
    }
    public MyUserAdapter(Context context, int resource, List<User> objects) {
        this.context = context;
        this.userList = objects;
    }

    @Override
    public UserViewHolder onCreateViewHolder(ViewGroup viewGroup, int itemType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.user_row,viewGroup,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(UserViewHolder myViewHolder, int position)
    {
        final User user = userList.get(position);
        myViewHolder.bind(context,user);

        myViewHolder.mUserName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Address address = user.getAddress();
                Intent intent = new Intent(v.getContext(), UserDetails.class);
                intent.putExtra("name", user.getName());
                intent.putExtra("username", user.getUsername());
                intent.putExtra("email", user.getEmail());
                intent.putExtra("phone", user.getPhone());
                intent.putExtra("city", address.getCity());
                intent.putExtra("website", user.getWebsite());
                intent.putExtra("street", address.getStreet());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

}