package com.example.activities_a2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword;
    Button btnCancel, btnLogin;
    TextView tvForgetPasswod, tvSignup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);
        btnCancel = findViewById(R.id.btnCancel);
        tvForgetPasswod = findViewById(R.id.tvForgetPassword);
        tvSignup = findViewById(R.id.tvSignup);



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
               if(email.isEmpty())
               {
                   etEmail.setError("Invalid email");
               }
               else if(password.isEmpty())
               {
                   etPassword.setError("Invalid password");
               }
               else
               {
                   if(email.equalsIgnoreCase("admin@gmail.com") && password.equals("admin@123"))
                   {
                       Intent i= new Intent(MainActivity.this, Home.class);
                       startActivity(i);
                       finish();
                   }
                   else
                   {
                       Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                   }
               }

            }
        });


    }
}