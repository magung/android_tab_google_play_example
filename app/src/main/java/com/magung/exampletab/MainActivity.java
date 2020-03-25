package com.magung.exampletab;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.SearchView;
import android.widget.TextView;

import com.magung.exampletab.ui.main.PageViewModel;
import com.magung.exampletab.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity {
    /*
    Fungsi untuk mengganti warna pada status bar
     */
    public void setStatusBarColor(String color) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            int statusBarColor = Color.parseColor(color);
            if (statusBarColor == Color.BLACK && window.getNavigationBarColor() == Color.BLACK) {
                window.clearFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            } else {
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            }
            window.setStatusBarColor(statusBarColor);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        final TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        final SearchView searchView = findViewById(R.id.searchView);
        searchView.setQueryHint("Search Home");
        final RelativeLayout relativeLayout = findViewById(R.id.rlSearch);
        final AppBarLayout appBarLayout = findViewById(R.id.ablTittle);
        setStatusBarColor("#3F51B5");
        relativeLayout.setBackgroundColor(Color.parseColor("#3F51B5"));
        appBarLayout.setBackgroundColor(Color.parseColor("#3F51B5"));
        tabs.setBackgroundColor(Color.parseColor("#3F51B5"));
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                String Isi_search = "";
                switch (tab.getPosition()) {
                    case 0:
                        setStatusBarColor("#3F51B5");
                        tabs.setBackgroundColor(Color.parseColor("#3F51B5"));
                        relativeLayout.setBackgroundColor(Color.parseColor("#3F51B5"));
                        appBarLayout.setBackgroundColor(Color.parseColor("#3F51B5"));
                        Isi_search = "Search Home";
                        break;
                    case 1:
                        setStatusBarColor("#007a0e");
                        tabs.setBackgroundColor(Color.parseColor("#007a0e"));
                        relativeLayout.setBackgroundColor(Color.parseColor("#007a0e"));
                        appBarLayout.setBackgroundColor(Color.parseColor("#007a0e"));
                        Isi_search = "Search Games";
                        break;
                    case 2:
                        setStatusBarColor("#960000");
                        tabs.setBackgroundColor(Color.parseColor("#960000"));
                        relativeLayout.setBackgroundColor(Color.parseColor("#960000"));
                        appBarLayout.setBackgroundColor(Color.parseColor("#960000"));
                        Isi_search = "Search Movies";
                        break;
                    case 3:
                        setStatusBarColor("#008282");
                        tabs.setBackgroundColor(Color.parseColor("#008282"));
                        relativeLayout.setBackgroundColor(Color.parseColor("#008282"));
                        appBarLayout.setBackgroundColor(Color.parseColor("#008282"));
                        Isi_search = "Search Books";
                        break;
                }
                searchView.setQueryHint(Isi_search);

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


    }


}