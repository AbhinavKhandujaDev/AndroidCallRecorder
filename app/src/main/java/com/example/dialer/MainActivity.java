package com.example.dialer;

import android.os.Bundle;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNav;
    FrameLayout frameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setIds();
        setBottomNav();
        setFragment(new CallsFragment());
    }

    protected void setIds() {
        bottomNav = findViewById(R.id.main_bottom_nav);
        frameLayout = findViewById(R.id.main_frame_layout);
    }

    protected void setBottomNav() {
        bottomNav.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.menu_dialpad:
                    setFragment(new DialerFragment());
                    break;
                case R.id.menu_call_end:
                    setFragment(new CallsFragment());
                    break;
                default:
                    setFragment(new TestFragment());
                    break;
            }
            return true;
        });
    }

    protected void setFragment(Fragment fragment) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_frame_layout, fragment);
        transaction.commit();
    }
}