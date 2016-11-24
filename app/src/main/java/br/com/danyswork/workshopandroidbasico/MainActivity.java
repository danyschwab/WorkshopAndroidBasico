package br.com.danyswork.workshopandroidbasico;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeFragment homeFragment = new HomeFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, homeFragment)
                .addToBackStack(homeFragment.getFragmentTag()).commit();
    }


    @Override
    public void onBackPressed() {
        if (!popBackStack()) {
            finish();
        }
    }

    public boolean popBackStack() {
        return getSupportFragmentManager().popBackStackImmediate();
    }

}
