package Beans;

import java.io.Serializable;

/**
 * Created by Savinda Keshan on 10/16/2016.
 */
public class User implements Serializable {
    String mobileNum;
    String name;
    String email;
    String nicNum;
    String spID;
    String pID;
    
    ServiceProvider sp;
    Passenger p;

    public User(String mobileNum, String name, String email, String nicNum) {
        this.mobileNum = mobileNum;
        this.name = name;
        this.email = email;
        this.nicNum = nicNum;
        spID = null;
        pID = null;
        sp = null;
        p = null;
    }

    public String getMobileNum() {
        return mobileNum;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getNicNum() {
        return nicNum;
    }

    public String getSpID() {
        return spID;
    }

    public String getpID() {
        return pID;
    }

    public ServiceProvider getSp() {
        return sp;
    }

    public Passenger getP() {
        return p;
    }

    public void setP(Passenger p) {
        this.p = p;
    }

    public void setSp(ServiceProvider sp) {
        this.sp = sp;
    }

    public void setpID(String pID) {
        this.pID = pID;
    }

    public void setSpID(String spID) {
        this.spID = spID;
    }
}
