package com.example.airteldashboard;

public class DashboardData {
    private String accountBalance;
    private String dataUsage;
    private String outstandingBills;

    // Constructor
    public DashboardData(String accountBalance, String dataUsage, String outstandingBills) {
        this.accountBalance = accountBalance;
        this.dataUsage = dataUsage;
        this.outstandingBills = outstandingBills;
    }

    // Getters and Setters
    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getDataUsage() {
        return dataUsage;
    }

    public void setDataUsage(String dataUsage) {
        this.dataUsage = dataUsage;
    }

    public String getOutstandingBills() {
        return outstandingBills;
    }

    public void setOutstandingBills(String outstandingBills) {
        this.outstandingBills = outstandingBills;
    }
}
