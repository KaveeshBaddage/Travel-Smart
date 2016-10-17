package com.travelsmart.fourloop.travelsmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import Beans.Passenger;
import Beans.ServiceProvider;
import Beans.User;

public class Signup4 extends AppCompatActivity {
    User user;
    ServiceProvider serviceProvider;
    Passenger passenger;
    int flag;

    Button passengerBtn;
    Button serviceProviderBtn;
    Button doneBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup4);

        Intent intentpr = getIntent();
        user = (User)intentpr.getSerializableExtra("user");
        flag = intentpr.getIntExtra("flag",0);

        passengerBtn = (Button)findViewById(R.id.PassangerBtn);
        serviceProviderBtn = (Button)findViewById(R.id.ServiceProviderBtn);
        doneBtn = (Button)findViewById(R.id.DoneBtn2);

        if(flag == 1){
            //disable buttons and change button color
            serviceProvider = (ServiceProvider)intentpr.getSerializableExtra("serviceProvider");
        }
        else if(flag == 2){
            //disable buttons and change button color
            passenger = (Passenger)intentpr.getSerializableExtra("passenger");
        }
        else if(flag == 3){
            //disable buttons and change button color
            passenger = (Passenger)intentpr.getSerializableExtra("passenger");
            serviceProvider = (ServiceProvider)intentpr.getSerializableExtra("serviceProvider");
        }

    }

    public void ServiceProvider(View view) {
        if(flag == 0){

        }
        else if(flag == 1){

        }
        else if(flag == 2){
            
        }
    }

    public void Passenger(View view) {

    }

    public void Done2(View view) {

    }
}
