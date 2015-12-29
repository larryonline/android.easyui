package me.zhennan.android.easyui.samples;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    final static String FRAGMENT_TAG = "simpleListFragment";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupFragment();
    }

    protected void setupFragment(){
        Fragment fragment = getSupportFragmentManager().findFragmentByTag(FRAGMENT_TAG);
        if(null == fragment){
            fragment = Fragment.instantiate(this, SimpleListFragment.class.getName());
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.box_frame, fragment, FRAGMENT_TAG)
                    .commit();
        }
    }
}
