package com.travelsmart.fourloop.travelsmart;
public class Url {
    String url = "http://10.0.2.2/TravelSmart/";
    Url(String url){
        this.url=this.url+url;
    }
    public String getUrl(){
        return url;
    }
}
