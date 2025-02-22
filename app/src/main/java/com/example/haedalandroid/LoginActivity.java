package com.example.haedalandroid;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.haedalandroid.user.currentUser;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 해당 엑티비티의 화면을 activity_login.xml로 설정
        setContentView(R.layout.activity_login);

        // 화면에 있는 이메일텍스트 뷰를 가져옴
        // 이제 email_deitText를 이용해서 해당 뷰를 조작할 수 있음.
        TextView email_editText = findViewById(R.id.email_editText);

        // 화면에 있는 비밀번호텍스트 뷰를 가져옴
        // 마찬가지로 password_editText를 이용해서 해당 뷰를 조작할 수 있음.
        TextView password_editText = findViewById(R.id.password_editText);

        Button email_login_button = findViewById(R.id.email_login_button);

        email_login_button.setOnClickListener(v -> {

            // email_editText에서 getText()를 이용해 글자를 가져온다 하지만 char[]형이기 때문에 string형으로 바꿔준다.
            String email = email_editText.getText().toString();
            // 마찬가지로 입력한 비밀번호를 가져온다.
            String password = password_editText.getText().toString();

            currentUser.email = email;
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            finish();

        });
    }
}
