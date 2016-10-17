package com.travelsmart.fourloop.travelsmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import Beans.User;

public class Signup3 extends AppCompatActivity {

    EditText FNameEt;
    EditText LNameEt;
    EditText NICEt;
    EditText EmailEt;

    String mobileNum;

    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup3);

        Intent intentpr = getIntent();
        mobileNum = intentpr.getStringExtra("mobileNum");

        FNameEt = (EditText)findViewById(R.id.FNameEt);
        LNameEt = (EditText)findViewById(R.id.LNameEt);
        NICEt = (EditText)findViewById(R.id.NICEt);
        EmailEt = (EditText)findViewById(R.id.EmailEt);

    }

    public void Next2(View view) {
        String Fname = FNameEt.getText().toString();
        String Lname = FNameEt.getText().toString();
        String NIC = FNameEt.getText().toString();
        String Email = FNameEt.getText().toString();

        int flag = 0;

        user = new User(mobileNum,Fname+" "+Lname,NIC,Email);
        Intent intent = new Intent(Signup3.this,Signup4.class);
        intent.putExtra("user",user);
        intent.putExtra("flag",flag);

        startActivity(intent);

    }
}
