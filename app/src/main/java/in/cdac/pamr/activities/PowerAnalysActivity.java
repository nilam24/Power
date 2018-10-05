package in.cdac.pamr.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import in.cdac.pamr.R;

/**
 * Created by Dell1 on 21/05/2017.
 */

public class PowerAnalysActivity extends AppCompatActivity {

    String pname;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       // getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        actionBarSetup();


    }

    public void actionBarSetup()
    {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        pname = preferences.getString("user",null);

        actionBar.setTitle("Power AMR Solutions");
        actionBar.setSubtitle(pname+"          "+"Power Analysis Report");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater=new MenuInflater(PowerAnalysActivity.this);
      //  inflater.inflate(R.menu.menu_dash,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.home) {

            Intent upIntent = NavUtils.getParentActivityIntent(this);
            if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
                TaskStackBuilder.create(this).addNextIntentWithParentStack(upIntent).startActivities();
            } else {
                NavUtils.navigateUpTo(this, upIntent);

            }
            return true;

        }


        return super.onOptionsItemSelected(item);
    }
}
