package com.androiddev.josephelliott.exchange_o_gram;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Retrofit;

/**
 * Created by Joseph Elliott on 1/12/2016.
 */
public class PostAdapter extends BaseAdapter {
    private Context mContext;
    private List<Post> postList;

    public PostAdapter(Context c, List<Post> postList) {
        mContext = c;
        this.postList = postList;
    }

    public int getCount() {
        return  postList.size();
    }

    public Post getItem(int position) {
        return postList.get(position);
    }

    public long getItemId(int position) {
        return (long)position;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
        } else {
            imageView = (ImageView) convertView;
        }

        DisplayMetrics metrics = mContext.getResources().getDisplayMetrics();
        int width = metrics.widthPixels / 2; // 2 columns wide
        int height = metrics.heightPixels / 2;

        Post post = getItem(position);
        String imageURL = post.getFullImageUrl();
        Picasso
                .with(mContext)
                .load(imageURL)
                .resize(width, height)
                .centerCrop()
                .into(imageView);
        return imageView;
    }

    public void setNewPosts(List<Post> postList) {
        this.postList = postList;
        notifyDataSetChanged();
    }
}
