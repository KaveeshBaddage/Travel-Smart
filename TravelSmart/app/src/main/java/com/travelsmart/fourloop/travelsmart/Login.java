package com.travelsmart.fourloop.travelsmart;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import Beans.Passenger;
import Beans.ServiceProvider;
import Beans.User;

public class Login extends AppCompatActivity {
    EditText mobileNumEt;
    EditText passwordEt;

    User user;

    StringRequest request;
    RequestQueue requestQueue;

    Url URL = new Url("login1.php");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mobileNumEt = (EditText)findViewById(R.id.MobileNumEt2);
        passwordEt = (EditText)findViewById(R.id.PasswordEt1);
        requestQueue = Volley.newRequestQueue(this);

    }

    public void Login2(View view) {

        request = new StringRequest(Request.Method.POST,URL.getUrl(), new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    if(!(jsonObject.names().equals("fail"))){
                        int flag = 0 ;

                        String mobileNum = jsonObject.getString("mobile_num");
                        String name = jsonObject.getString("name");
                        String email = jsonObject.getString("email");
                        String nicNum = jsonObject.getString("nic_num");

                        user = new User(mobileNum,name,email,nicNum);

                        if(!(jsonObject.getString("sp_id").equals(null))){
                            ServiceProvider serviceProvider = getServiceProvider();

                            user.setSpID(jsonObject.getString("sp_id"));
                            user.setSp(serviceProvider);

                            flag = 1;
                        }
                        if(!(jsonObject.getString("p_id").equals(null))){
                            Passenger passenger = getPassenger();

                            user.setpID(jsonObject.getString("p_id"));
                            user.setP(passenger);

                            if(flag == 1){
                                flag = 3;
                            }
                            else{
                                flag = 2;
                            }
                        }
                        SwitchAccount(flag);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("mobileNum", mobileNumEt.getText().toString());
                hashMap.put("password", passwordEt.getText().toString());
                return hashMap;
            }
        };

        requestQueue.add(request);
    }
    public ServiceProvider getServiceProvider(){
        ServiceProvider serviceProvider = new ServiceProvider();
        return serviceProvider;
    }
    public Passenger getPassenger(){
        Passenger passenger = new Passenger();
        return passenger;
    }
    public void SwitchAccount(int flag){
        if(flag==1){
            Intent intent = new Intent(Login.this,Home.class);
            startActivity(intent);
        }
        else if(flag==2){
            Intent intent = new Intent(Login.this,Home.class);
            startActivity(intent);
        }
        else if(flag==3){
            Intent intent = new Intent(Login.this,SwitchAccount.class);
            startActivity(intent);
        }
    }

}
