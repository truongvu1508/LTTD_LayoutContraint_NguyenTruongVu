package com.example.bt_constraintlayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.w3c.dom.Text;

public class RegisterActivity extends AppCompatActivity {
    private EditText inputEmail, inputPassword, inputConfirmPassword, inputUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        TextView btn=findViewById(R.id.textViewSignIn);
        inputEmail = findViewById(R.id.inputEmail);
        inputPassword = findViewById(R.id.inputPassword);
        inputConfirmPassword = findViewById(R.id.inputConfirmPassword);
        inputUsername = findViewById(R.id.inputUsername);
        Button btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();
                String confirmPassword = inputConfirmPassword.getText().toString().trim();
                String username = inputUsername.getText().toString().trim();

                if (username.isEmpty()) {
                    inputUsername.setError("Username is required");
                    return;
                }

                if (email.isEmpty()) {
                    inputEmail.setError("Email is required");
                    return;
                }

                if (password.isEmpty()) {
                    inputPassword.setError("Password is required");
                    return;
                }

                if (confirmPassword.isEmpty()) {
                    inputConfirmPassword.setError("Please confirm your password");
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    inputConfirmPassword.setError("Passwords do not match");
                    return;
                }

                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                intent.putExtra("email", email);
                intent.putExtra("password", password);
                startActivity(intent);
                finish();
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(RegisterActivity.this,LoginActivity.class));
            }
        });
    }
}