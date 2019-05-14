package com.example.classatttendance;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    ListView listView;
    String mTitle[]={
            "Database Programming",
            "Android Programming",
            "C Programming",
            "Fundamentals of It",
            "Information System",
            "Management Information Systen",
            "Communication Skills",
            "Developmental Studies"
    };
    String mDescription[]={
            "Mr Mwavu Rogers",
            "Mr Kimera Richard",
            "Mr Kimera Richard",
            "Mr Baguma Kenneth",
            "Madam Munguci Gloria",
            "Madam Kachick",
            "Madam Kabarungi Moreen Mukisa",
            "Mr Justus "
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        listView=(ListView)findViewById(R.id.listView);
        MyAdapter adapter=new MyAdapter(this,mTitle,mDescription);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    startActivity(new Intent(HomeActivity.this,RegisterActivity.class));
                }else{
                    startActivity(new Intent(HomeActivity.this,RegisterActivity.class));
                }
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.msetting) {
            startActivity(new Intent(HomeActivity.this,SettingsActivity.class));
            return true;
        }if (id == R.id.mregister) {
            startActivity(new Intent(HomeActivity.this,RegisterActivity.class));

            return true;
        }if (id == R.id.mhistory) {
//            startActivity(new Intent(HomeActivity.this,SettingsActivity.class));

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.register) {
            startActivity(new Intent(HomeActivity.this,RegisterActivity.class));
        } else if (id == R.id.about) {
            startActivity(new Intent(HomeActivity.this,AboutActivity.class));

        } else if (id == R.id.setting) {
            startActivity(new Intent(HomeActivity.this,SettingsActivity.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
class MyAdapter extends ArrayAdapter<String> {
    Context context;
    String rTitle[];
    String rDescription[];


    public MyAdapter(Context c,String title[],String description[]) {
        super(c, R.layout.rows,R.id.textview1, title);
        this.context = c;
        this.rTitle = title;
        this.rDescription = description;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater=(LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=layoutInflater.inflate(R.layout.rows,parent,false);

        TextView mTitle=row.findViewById(R.id.textview1);
        TextView mDescription=row.findViewById(R.id.textview2);


        mTitle.setText(rTitle[position]);
        mDescription.setText(rDescription[position]);
        return row;
    }
}
