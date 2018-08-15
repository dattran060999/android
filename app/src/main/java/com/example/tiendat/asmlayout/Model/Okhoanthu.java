package com.example.tiendat.asmlayout.Model;

public class Okhoanthu {
   public String tenkhoanthu;
   public int _id;
   public String loaithu;

    public Okhoanthu(String tenkhoanthu, int _id, String loaithu) {
        this.tenkhoanthu = tenkhoanthu;
        this._id = _id;
        this.loaithu = loaithu;
    }

    public Okhoanthu(String tenkhoanthu, String loaithu) {
        this.tenkhoanthu = tenkhoanthu;
        this.loaithu = loaithu;
    }
}
