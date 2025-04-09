package com.example.airteldashboard;

public class Bill {
    private String billDate;
    private String billAmount;

    public Bill(String billDate, String billAmount) {
        this.billDate = billDate;
        this.billAmount = billAmount;
    }

    public String getBillDate() {
        return billDate;
    }

    public void setBillDate(String billDate) {
        this.billDate = billDate;
    }

    public String getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(String billAmount) {
        this.billAmount = billAmount;
    }
}