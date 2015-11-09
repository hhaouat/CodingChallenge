package com.codingchallenge.core.ui.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.codingchallenge.R;
import com.codingchallenge.core.model.Address;
import com.codingchallenge.core.model.User;
import com.codingchallenge.core.ui.album.AlbumActivity;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserDetails extends AppCompatActivity
{
    User user;
    Address address;

    @Bind(R.id.name)
    TextView mNameText;
    @Bind(R.id.username)
    TextView mUsernameText;
    @Bind(R.id.email)
    TextView mMailText;
    @Bind(R.id.phone)
    TextView mPhoneText;
    @Bind(R.id.website)
    TextView mWebsiteText;
    @Bind(R.id.city)
    TextView mCityText;
    @Bind(R.id.albumButton)
    Button mAlbumButton;
    @Bind(R.id.myalbums)
    TextView mAlbumsText;
    @Bind(R.id.myposts)
    TextView mPostsText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_details);
        ButterKnife.bind(this);

        user = new User();
        address = new Address();

        String name = getIntent().getExtras().getString("name") != null ? getIntent().getExtras().getString("name") : "name";
        user.setName(name);
        mNameText.setText(getString(R.string.name, " " , name));

        String username = getIntent().getExtras().getString("username") != null ? getIntent().getExtras().getString("username") : "username";
        user.setUsername(username);
        mUsernameText.setText(getString(R.string.username," ", username));

        String mail = getIntent().getExtras().getString("email") != null ? getIntent().getExtras().getString("email") : "email";
        user.setEmail(mail);
        mMailText.setText(getString(R.string.email, " ", mail));

        String phone = getIntent().getExtras().getString("phone") != null ? getIntent().getExtras().getString("phone") : "phone";
        user.setPhone(phone);
        mPhoneText.setText(getString(R.string.phone," ", phone));

        String website = getIntent().getExtras().getString("website") != null ? getIntent().getExtras().getString("website") : "website";
        user.setWebsite(website);
        mWebsiteText.setText(getString(R.string.website," ",website));

        String city = getIntent().getExtras().getString("city") != null ? getIntent().getExtras().getString("city") : "city";
        address.setCity(city);
        mCityText.setText(getString(R.string.city, " ", city));

        mAlbumButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserDetails.this, AlbumActivity.class);
                intent.putExtra("userId", user.getId());
                startActivity(intent);
            }
        });
    }

}
