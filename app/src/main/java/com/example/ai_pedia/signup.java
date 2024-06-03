package com.example.ai_pedia;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {
    EditText name,username,phno,editTextEmail,editTextPassword;
    Button sup,al;
    FirebaseAuth mAuth;
    TextView textView;
    //ProgressBar progressBar;
  //  @Override
//    public void onStart() {
//        super.onStart();
//        // Check if user is signed in (non-null) and update UI accordingly.
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser != null){
//            Intent i1= new Intent(getApplicationContext(),home.class);
//            startActivity(i1);
//            finish();
//        }
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(ContextCompat.getColor(this, R.color.your_color));
        }
        setContentView(R.layout.activity_signup);
        mAuth= FirebaseAuth.getInstance();
        name=findViewById(R.id.editTextTextPersonName);
        username=findViewById(R.id.Usernamesu);
        phno=findViewById(R.id.editTextPhone);
        editTextEmail=findViewById(R.id.editTextTextEmailAddress);
        editTextPassword=findViewById(R.id.Passwordsu);
        sup = findViewById(R.id.buttonsu);
        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Name, phone, email, password;
                email = editTextEmail.getText().toString();
                password = editTextPassword.getText().toString();
                Name = name.getText().toString();
                phone = phno.getText().toString();
                if (TextUtils.isEmpty(Name)) {
                    Toast.makeText(signup.this, "Enter Name", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(phone)) {
                    Toast.makeText(signup.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(signup.this, "Enter Email", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(signup.this, "Enter Password", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    Toast.makeText(signup.this, "Account Created!", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(getApplicationContext(), signin.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // If account creation fails, display a message to the user.
                                    Toast.makeText(signup.this, "Account creation failed.", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
        al = findViewById(R.id.btn3);
        al.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2= new Intent(getApplicationContext(),signin.class);
                startActivity(i2);
            }
        });
    }
}




