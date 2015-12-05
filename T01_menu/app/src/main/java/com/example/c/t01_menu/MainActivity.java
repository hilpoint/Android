package com.example.c.t01_menu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView myView = (TextView)findViewById(R.id.myView);
        registerForContextMenu(myView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0, 100, 0, "Hello context menu");
        menu.add(0,101,0,"Hello world");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.menu_test) {
            Toast.makeText(getApplicationContext(),
                    "menu selected",Toast.LENGTH_LONG).show();
        }
        return true;
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == 100) {
            Toast.makeText(getApplicationContext(),
                    "context 1",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(),
                    "context 2",Toast.LENGTH_LONG).show();
        }

        return super.onContextItemSelected(item);
    }
}
