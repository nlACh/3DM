package nlpl.com.a3dm;

import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Toolbar;


public class Front_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_front_page);
        //String dir = Environment.getExternalStorageDirectory().toString()+'/'+"3DM";
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        //So that the app starts with the connect fragment.
        //loadFragment(new connect_fragment());
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.one:
                        loadFragment(new connect_fragment());
                        return true;
                    case R.id.two:
                        loadFragment(new test_frag());
                        return true;
                    case R.id.three:
                        loadFragment(new print_fragment());
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
        return true;
    }

    private void loadFragment(Fragment fragment)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_frame, fragment);
        //We don't need adding the fragments to back stack!
        //transaction.addToBackStack(null);
        transaction.commit();
    }
}
