package com.example.kanika.applicaton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Registration extends AppCompatActivity {
private String name,email,password,contact,profession,userid;
    private EditText e_name,e_pass,e_email,e_phn,e_profession,e_userid;
    private Button reg_submit;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        textView=(TextView) findViewById(R.id.MarqueeText);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSelected(true);
        textView.setSingleLine(true);
        e_name=(EditText)findViewById(R.id.Reg_name);
        e_email=(EditText)findViewById(R.id.Reg_email);
        e_phn=(EditText)findViewById(R.id.Reg_phn);
        e_pass=(EditText)findViewById(R.id.Reg_pass);
        e_userid=(EditText)findViewById(R.id.Reg_Userid);
        e_profession=(EditText)findViewById(R.id.Reg_profession);
        reg_submit=(Button)findViewById(R.id.Submit);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSelected(true);
        textView.setSingleLine(true);
        reg_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=e_name.getText().toString();
                email=e_email.getText().toString();
                password=e_pass.getText().toString();
                contact=e_phn.getText().toString();
                profession=e_profession.getText().toString();
                userid=e_userid.getText().toString();
                boolean f=true;
                if (!isValidName(name)) {
                    e_name.setError("Name cannot be empty");
                    f=false;
                }
                if(!isValidName(userid))
                {
                    e_userid.setError("User ID cannot be empty");
                    f=false;
                }
                if (!isValidPassword(password)) {
                    e_pass.setError("Invalid Password:Password must be longer than 6");
                    f=false;
                }
                if(!isValidName(profession)) {
                    e_profession.setError("Profession cannot be empty");
                    f = false;
                }
                if(!isValidNo(contact))
                {
                    e_phn.setError("Invalid Contact Number");
                    f=false;
                }
                if (!isValidEmail(email)) {
                    e_email.setError("Invalid Email ID");
                    f=false;
                }
               if(f==true)
               {
                   Intent i=new Intent(Registration.this,Profile.class);
                   startActivity(i);
               }

            }
        });
    }
        private static final String USERNAME_PATTERN = "^[a-z0-9_-]{3,15}$";

        private boolean isValidName(String name){
            if(name.length()>0)
                return true;
            return false;
        }
        private boolean isValidNo(String no){
            if(no.length()>6 && no.length()<=13)
                return true;
            return false;
        }
        // validating email id
        private boolean isValidEmail(String email) {
            String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
        }

        // validating password with retype password
        private boolean isValidPassword(String pass) {
            if (pass != null && pass.length() > 6) {
                return true;
            }
            return false;

        }
}
