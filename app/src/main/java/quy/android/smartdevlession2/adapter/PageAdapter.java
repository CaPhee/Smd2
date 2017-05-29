package quy.android.smartdevlession2.adapter;

import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import quy.android.smartdevlession2.MainActivity;
import quy.android.smartdevlession2.R;

/**
 * Created by iamme on 17/05/26.
 */

public class PageAdapter extends PagerAdapter {

    Context context;
    String title[];
    int imgNumber[];
    String rank[];
    LayoutInflater inflater;
    public PageAdapter(FragmentManager supportFragmentManager) {

    }

    public PageAdapter(MainActivity context, String[] rank, String[] title, int[] imgNumber) {
        this.context = context;
        this.title = title;
        this. imgNumber = imgNumber;
        this.rank = rank;

    }

    @Override
    public int getCount() {
        return rank.length;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        TextView txtRank;
        TextView txtTitle;
        ImageView img;

        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.viewpager_item, container,
                false);

        txtRank = (TextView) itemView.findViewById(R.id.rank);
        txtTitle = (TextView) itemView.findViewById(R.id.title);
        img = (ImageView)itemView.findViewById(R.id.img);

        txtRank.setText(rank[position]);
        txtTitle.setText(title[position]);
        img.setImageResource(imgNumber[position]);

        ((ViewPager) container).addView(itemView);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // Remove viewpager_item.xml from ViewPager
        ((ViewPager) container).removeView((LinearLayout) object);

    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == ((LinearLayout) object);
    }
}
