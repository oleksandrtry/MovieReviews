package cocooncreations.net.moviereviews.ui.main;

import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import cocooncreations.net.moviereviews.R;
import cocooncreations.net.moviereviews.ui.base.adapters.ViewPagerAdapter;
import cocooncreations.net.moviereviews.ui.movie.favorite.MovieFavoriteFragment;
import cocooncreations.net.moviereviews.ui.movie.search.MovieSearchFragment;

public class MainActivity extends AppCompatActivity {


    private ViewPager viewPager;
    private TabLayout tabLayout;
    private ViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        viewPager = findViewById(R.id.container);
        tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setUpViewPager(viewPager);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void setUpViewPager(ViewPager viewPager) {
        adapter = new ViewPagerAdapter(this.getSupportFragmentManager());
        String[] tabsTitle = getResources().getStringArray(R.array.main_tabs);
        adapter.addFragment(MovieSearchFragment.newInstance(), tabsTitle[0]);
        adapter.addFragment(MovieFavoriteFragment.newInstance(), tabsTitle[1]);
        viewPager.setAdapter(adapter);
    }
}