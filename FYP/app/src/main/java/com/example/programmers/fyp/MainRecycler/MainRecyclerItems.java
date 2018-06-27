package com.example.programmers.fyp.MainRecycler;

import java.io.Serializable;

/**
 * Created by Programmers on 10/02/2018.
 */

public class MainRecyclerItems implements Serializable {

    public int id,fee;
    public String name;
    public String address;
    public String specialization;
    public String pic;



    public MainRecyclerItems(int id,int fee, String name, String address, String specialization, String pic)
    {
        this.id = id;
this.name = name;
this.address = address;
this.specialization = specialization;
this.pic = pic;
this.fee = fee;

    }

    public int getFee() {
        return fee;
    }

    public int getId() {
        return id;

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getSpecialization() {
        return specialization;
    }

    public String getPic() {
        return pic;
    }

}