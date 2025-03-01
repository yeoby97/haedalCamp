package com.example.haedalandroid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.example.haedalandroid.user.currentUser;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView emailTextView = findViewById(R.id.emailTextView);
        TextView passwordTextView=findViewById(R.id.passwordTextView);
        Button homeButton=findViewById(R.id.btn_home);
        Button searchButton=findViewById(R.id.btn_search);
        Button galleryButton=findViewById(R.id.btn_gallery);
        Button favoriteButton=findViewById(R.id.btn_favorite);
        Button accountButton=findViewById(R.id.btn_account);

        emailTextView.setText(currentUser.email);

        //인텐트를 받아서 저장된 정보를 가져온다.
        Intent intent = getIntent();
        String email=intent.getStringExtra("email");
        String password=intent.getStringExtra("password");
        emailTextView.setText(email);
        passwordTextView.setText(password);

        //버튼 클릭 시 프래그먼트를 띄우도록 클릭리스너를 설정한다
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new HomeFragment());
            }
        });
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new SearchFragment());
            }
        });
        galleryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new GalleryFragment());
            }
        });
        favoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new FavoriteFragment());
            }
        });
        accountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new AccountFragment());
            }
        });
    }
    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
