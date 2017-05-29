package quy.android.smartdevlession2;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;

import com.viewpagerindicator.CirclePageIndicator;

import quy.android.smartdevlession2.adapter.FragmentAdapter;
import quy.android.smartdevlession2.adapter.PageAdapter;


public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    TabLayout tabLayout;
    PageAdapter adapter;
    FragmentAdapter fragmentAdapter;
    String rank[];
    String title[];
    int imgNumber[];
    Button button;
    CirclePageIndicator cIndicator;
    TabHost tabHost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        mapping();

        adapter = new PageAdapter(MainActivity.this,rank,title,imgNumber);
        viewPager.setAdapter(adapter);
        cIndicator.setScrollbarFadingEnabled(false);
        cIndicator.setFadingEdgeLength(200);
        cIndicator.setViewPager(viewPager);

//        FragmentManager manager = getSupportFragmentManager();
//        fragmentAdapter = new FragmentAdapter(manager);
//        viewPager.setAdapter(fragmentAdapter);
//
//        tabLayout.setupWithViewPager(viewPager);
//        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initData(){
        rank = new String[] { "1", "2", "3", "4" };
        title = new String[]{"description1","description2","description3","description4"};
        imgNumber = new int[]{ R.drawable.anh1,R.drawable.anh2,R.drawable.anh3,R.drawable.anh4};
    }

    private void mapping(){
//        tabHost = (TabHost) findViewById(R.id.tab_host);
        viewPager = (ViewPager)findViewById(R.id.pager);
//        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        cIndicator = (CirclePageIndicator) findViewById(R.id.indicator);
        button = (Button) findViewById(R.id.goto_second);
    }
    private void nextPage() {
        int currentPage = viewPager.getCurrentItem();
        int totalPages = viewPager.getAdapter().getCount();

        int nextPage = currentPage+1;
        if (nextPage >= totalPages) {
            // We can't go forward anymore.
            // Loop to the first page. If you don't want looping just
            // return here.
            nextPage = 0;
        }

        viewPager.setCurrentItem(nextPage, true);
    }
    private void previousPage() {
        int currentPage = viewPager.getCurrentItem();
        int totalPages = viewPager.getAdapter().getCount();

        int previousPage = currentPage-1;
        if (previousPage < 0) {
            // We can't go back anymore.
            // Loop to the last page. If you don't want looping just
            // return here.
            previousPage = totalPages - 1;
        }

        viewPager.setCurrentItem(previousPage, true);
    }
}
