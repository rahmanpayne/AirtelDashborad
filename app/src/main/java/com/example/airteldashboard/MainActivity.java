package com.example.airteldashboard;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import com.example.airteldashboard.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private DashboardData dashboardData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Use DataBinding to bind the layout to the activity
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Create a sample DashboardData object
        dashboardData = new DashboardData(
                "UGX 231,000", // Account balance
                "5 GB used", // Data usage
                "UGX 500 outstanding" // Outstanding bill
        );

        // Bind the data to the layout
        binding.setDashboard(dashboardData);

        // Set button listeners

        // Recharge Now Button
        binding.rechargeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the recharge function
                handleRechargeClick();
            }
        });

        // View Bill History Button
        binding.billHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Call the view bill history function
                handleViewBillHistoryClick();
            }
        });
    }

    // Function to handle Recharge Now button click
    private void handleRechargeClick() {
        // Create an EditText to prompt the user for recharge amount
        final EditText rechargeAmountInput = new EditText(this);
        rechargeAmountInput.setHint("Enter recharge amount");

        // Create an AlertDialog to ask the user for the recharge amount
        new AlertDialog.Builder(this)
                .setTitle("Recharge Now")
                .setMessage("Please enter the recharge amount:")
                .setView(rechargeAmountInput)
                .setPositiveButton("Recharge", (dialog, which) -> {
                    // Get the input amount from the EditText
                    String amountStr = rechargeAmountInput.getText().toString();

                    // Validate that the input is a valid number
                    if (amountStr.isEmpty()) {
                        Toast.makeText(MainActivity.this, "Please enter a valid amount", Toast.LENGTH_SHORT).show();
                    } else {
                        // Assuming the recharge amount is valid, update the account balance
                        // Here, we're simply adding the entered amount to the existing balance
                        int currentBalance = Integer.parseInt(dashboardData.getAccountBalance().replace("₹", ""));
                        int rechargeAmount = Integer.parseInt(amountStr);
                        int newBalance = currentBalance + rechargeAmount;

                        // Update the account balance (you can call a method or update the DataBinding object here)
                        dashboardData.setAccountBalance("₹" + newBalance);

                        // Show a confirmation message
                        Toast.makeText(MainActivity.this, "Recharge successful! New balance: ₹" + newBalance, Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    // Function to handle View Bill History button click
    private void handleViewBillHistoryClick() {
        // Navigate to BillHistoryActivity when the button is clicked
        Intent intent = new Intent(this, BillHistoryActivity.class);
        startActivity(intent);
    }
}
