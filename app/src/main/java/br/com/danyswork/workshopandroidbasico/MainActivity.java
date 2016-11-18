package br.com.danyswork.workshopandroidbasico;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeFragment homeFragment = new HomeFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, homeFragment)
                .addToBackStack(homeFragment.getFragmentTag()).commit();
    }
}
