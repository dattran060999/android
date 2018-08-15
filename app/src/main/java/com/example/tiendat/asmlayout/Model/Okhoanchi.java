package com.example.tiendat.asmlayout.Model;

public class Okhoanchi {
    public String tenkhoanchi;
    public String loaichi;
    public int _id;

    public Okhoanchi(String tenkhoanchi, String loaichi, int _id) {
        this.tenkhoanchi = tenkhoanchi;
        this.loaichi = loaichi;
        this._id = _id;
    }

    public Okhoanchi(String tenkhoanchi, String loaichi) {
        this.tenkhoanchi = tenkhoanchi;
        this.loaichi = loaichi;
    }
}
