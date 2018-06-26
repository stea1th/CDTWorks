/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import java.io.Serializable;

/**
 *
 * @author stea1th
 */
public class TestDataDTO implements Serializable{
    
    private int mId;
    private String mName;
    private double mSalary;
    private String abteilName;
    private String city;

    public TestDataDTO(int mId, String mName, double mSalary, String abteilName, String city) {
        this.mId = mId;
        this.mName = mName;
        this.mSalary = mSalary;
        this.abteilName = abteilName;
        this.city = city;
    }

    public TestDataDTO(int mId, String mName, double mSalary, String abteilName) {
        this.mId = mId;
        this.mName = mName;
        this.mSalary = mSalary;
        this.abteilName = abteilName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public void setmName(String mName) {
        this.mName = mName;
    }

    public double getmSalary() {
        return mSalary;
    }

    public void setmSalary(double mSalary) {
        this.mSalary = mSalary;
    }

    public String getAbteilName() {
        return abteilName;
    }

    public void setAbteilName(String abteilName) {
        this.abteilName = abteilName;
    }
    
    
}
