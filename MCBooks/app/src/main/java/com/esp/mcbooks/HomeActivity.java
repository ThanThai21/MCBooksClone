package com.esp.mcbooks;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    GridView gridView;
    BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        gridView = (GridView)findViewById(R.id.content_book_grid_view);
        bookAdapter = new BookAdapter(this, R.layout.book_item);
        getBooklist();
        gridView.setAdapter(bookAdapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView textView = (TextView)view.findViewById(R.id.item_title_text_view);
                Toast.makeText(HomeActivity.this, textView.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });



    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_learning) {
            toolbar.setTitle(R.string.nav_learning_title);
            return false;
        } else if (id == R.id.nav_mybook) {
            toolbar.setTitle(R.string.nav_mybook_title);
            return false;
        } else if (id == R.id.nav_mygift) {
            toolbar.setTitle(R.string.nav_mygift_title);
            return false;
        } else if (id == R.id.nav_notify) {
            toolbar.setTitle(R.string.nav_notify_title);
            return false;
        } else if (id == R.id.nav_setting) {
            Intent intent = new Intent(HomeActivity.this, SettingActivity.class);
            startActivity(intent);
            return false;
        } else if (id == R.id.nav_mail) {
            return false;
        } else if (id == R.id.nav_fanpage) {
            return false;
        } else if (id == R.id.nav_exit) {
            return false;
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void getInit() {

    }

    void getBooklist() {
        bookAdapter.add(new Book("Title 1", "Description 1"));
        bookAdapter.add(new Book("Title 2", "Description 2"));
        bookAdapter.add(new Book("Title 3", "Description 3"));
        bookAdapter.add(new Book("Title 4", "Description 4"));
        bookAdapter.add(new Book("Title 5", "Description 5"));
        bookAdapter.add(new Book("Title 6", "Description 6"));
        bookAdapter.add(new Book("Title 7", "Description 7"));
    }
}
