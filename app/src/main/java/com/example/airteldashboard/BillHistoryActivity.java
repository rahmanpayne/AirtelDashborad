package com.example.airteldashboard;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class BillHistoryActivity extends AppCompatActivity {
    private RecyclerView billHistoryRecyclerView;
    private BillHistoryAdapter billHistoryAdapter;
    private List<Bill> billHistoryList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bill_history);

        billHistoryRecyclerView = findViewById(R.id.bill_history_recycler_view);

        // Create a list of bills (you can fetch this from a database or API)
        billHistoryList = new ArrayList<>();
        billHistoryList.add(new Bill("01/01/2025", "UGX 500"));
        billHistoryList.add(new Bill("01/02/2025", "UGX 300"));
        billHistoryList.add(new Bill("01/03/2025", "UGX 700"));

        // Set up RecyclerView with an adapter
        billHistoryAdapter = new BillHistoryAdapter(billHistoryList);
        billHistoryRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        billHistoryRecyclerView.setAdapter(billHistoryAdapter);
    }
}
