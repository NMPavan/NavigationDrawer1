package io.google.navigationdrawer1;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    Toolbar toolbar;
    NavigationView navigationView;
    DrawerLayout d1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.navigation_drawer );
        toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        d1 = (DrawerLayout) findViewById( R.id.drawer_layout );
        navigationView = (NavigationView) findViewById( R.id.navigation_view );



        // here we are just adding inclicklistenet to he navigationdrawer


        navigationView.setNavigationItemSelectedListener( (NavigationView.OnNavigationItemSelectedListener) this );


        //here in this we ahve just pass the object of the toolbar and drawerlayout and the references of open and close drawer
        //and then we are just setting refrence of the above with drwerlayout object
        // then we are just syncing our state
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( this, d1, toolbar, R.string.openDrawer, R.string.close_drwawer );
        d1.setDrawerListener( toggle );
        toggle.syncState();
    }

    @Override
    public void onBackPressed() {
        if (d1.isDrawerOpen( GravityCompat.START )) {
            d1.closeDrawer( GravityCompat.START );

        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
       getMenuInflater().inflate(R.menu.activity_menu1,menu);
       return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.item1_id){
            Toast.makeText( this, "item 1 is selectd", Toast.LENGTH_SHORT ).show();

        }else if (id==R.id.item2_id){
            Toast.makeText( this,"item2 is clicked",Toast.LENGTH_SHORT ).show();

        }else if (id==R.id.item3_id){
            Toast.makeText( this,"item3 is clicked",Toast.LENGTH_SHORT ).show();

        }


        return super.onOptionsItemSelected( item );

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        switch (id){
            case R.id.item1_id:
                Toast.makeText( this,"Inbox",Toast.LENGTH_SHORT ).show();
                break;
            case R.id.item2_id:
                Toast.makeText( this,"stared",Toast.LENGTH_SHORT ).show();
                break;
            case R.id.item3_id:
                Toast.makeText( this,"sent mail",Toast.LENGTH_SHORT ).show();
                break;
            case R.id.item4_id:
                Toast.makeText( this,"Drafts",Toast.LENGTH_SHORT ).show();
                break;
            case R.id.all_mail:
                Toast.makeText( this,"All mail",Toast.LENGTH_SHORT ).show();
                break;
            case R.id.trash_id:
                Toast.makeText( this,"trash",Toast.LENGTH_SHORT ).show();
                break;

            case R.id.spam_id:
                Toast.makeText( this,"spam",Toast.LENGTH_SHORT ).show();
                break;


        }
        //this means that our navigation drawer will close to the left sideof the screen
         d1.closeDrawer( GravityCompat.START );



        return true;

    }
}
