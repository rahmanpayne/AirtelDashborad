package com.example.airteldashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class BillHistoryAdapter extends RecyclerView.Adapter<BillHistoryAdapter.BillViewHolder> {
    private List<Bill> billList;

    public BillHistoryAdapter(List<Bill> billList) {
        this.billList = billList;
    }

    @Override
    public BillViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bill_history, parent, false);
        return new BillViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BillViewHolder holder, int position) {
        Bill bill = billList.get(position);
        holder.billDateTextView.setText("Date: " + bill.getBillDate());
        holder.billAmountTextView.setText("Amount: " + bill.getBillAmount());
    }

    @Override
    public int getItemCount() {
        return billList.size();
    }

    // ViewHolder class to hold the views for each list item
    public static class BillViewHolder extends RecyclerView.ViewHolder {
        TextView billDateTextView;
        TextView billAmountTextView;

        public BillViewHolder(View itemView) {
            super(itemView);
            billDateTextView = itemView.findViewById(R.id.bill_date);
            billAmountTextView = itemView.findViewById(R.id.bill_amount);
        }
    }
}
