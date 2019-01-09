package com.example.begroup_web_0.trabzon.customAdapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.begroup_web_0.trabzon.R;
import com.example.begroup_web_0.trabzon.list.sliderList;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class pagerAdapter extends PagerAdapter {

    Context context;
    ArrayList<sliderList> image;
    public pagerAdapter(Context context, ArrayList<sliderList> image)
    {
        this.context=context;
        this.image=image;
    }

    @Override
    public int getCount() {
        return image.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view==(LinearLayout)o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=LayoutInflater.from(context).inflate(R.layout.slider,container,false);
        ImageView images=(ImageView)view.findViewById(R.id.slider);
        Picasso.with(context).load(image.get(position).getImg()).into(images);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}