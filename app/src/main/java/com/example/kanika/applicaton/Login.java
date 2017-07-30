package com.example.kanika.applicaton;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity {
private EditText loginemail,loginpass;
    private TextView tv;
    private String email,password;
    private Button login,signin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginemail=(EditText)findViewById(R.id.login_email);
        loginpass=(EditText)findViewById(R.id.login_password);
        login=(Button)findViewById(R.id.btn_login);
        signin=(Button)findViewById(R.id.btn_signin);
        tv=(TextView)findViewById(R.id.textView3);
        tv.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        tv.setSelected(true);
        tv.setSingleLine(true);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
          email=loginemail.getText().toString();
                password=loginpass.getText().toString();
                if(email.length()<5 || password.length()<=6)
                {
                    AlertDialog alertDialog = new AlertDialog.Builder(Login.this).create();
                    alertDialog.setTitle("                 Alert      ");
                    alertDialog.setMessage("Email ID or Password are not valid");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "          OK  ",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                }
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(Login.this,Registration.class);
                startActivity(i);
            }
        });
    }
}
