package com.example.backpackerlk.Activities;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.backpackerlk.Dashboard;

import com.example.backpackerlk.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SellerProfile extends AppCompatActivity {

    private Button editProfileButton;
    private Button goToDashboardButton;
    private ImageView backIcon;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //hide the name bar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide(); //This line hides the action bar


        setContentView(R.layout.activity_seller_profile);

        //navigation
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.nav_profile);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();

            if (itemId == R.id.nav_home) {
                startActivity(new Intent(getApplicationContext(), Home.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (itemId == R.id.nav_categories){
                startActivity(new Intent(getApplicationContext(), Categories.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            } else if (itemId == R.id.nav_profile) {
                startActivity(new Intent(getApplicationContext(), WhoAreYou.class));
                overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                finish();
                return true;
            }

            return false;
        });

        // Set up ScrollView listener to hide/show bottom navigation
        ScrollView scrollView = findViewById(R.id.main1); // Use the ID of your ScrollView
        scrollView.setOnScrollChangeListener((v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            if (scrollY < oldScrollY) {
                // Scrolling up - make the bottom navigation invisible
                bottomNavigationView.animate().alpha(0f).setDuration(200).start();
            } else if (scrollY > oldScrollY) {
                // Scrolling down - make the bottom navigation visible
                bottomNavigationView.animate().alpha(1f).setDuration(200).start();
            }
        });

        // Initialize UI components
        backIcon = findViewById(R.id.icback);
        editProfileButton = findViewById(R.id.editprofileBtn);
        goToDashboardButton = findViewById(R.id.gotodashboardBtn);


        // Set edit profile button click listener
        editProfileButton.setOnClickListener(v -> {
            Intent intent = new Intent(SellerProfile.this, EditSellerProfile.class);
            startActivity(intent);
        });

        // Set go to dashboard button click listener
        goToDashboardButton.setOnClickListener(v -> {
            Intent intent = new Intent(SellerProfile.this, Dashboard.class);
            startActivity(intent);
        });
    }


}
