package edu.uic.group19.a422ndbank.MainApp.PayBills;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import edu.uic.group19.a422ndbank.Models.Bill;
import edu.uic.group19.a422ndbank.R;

public class PayBillsAdapter extends RecyclerView.Adapter<PayBillsAdapter.PayBillHolder> {

    private ArrayList<Bill> bills;

    public PayBillsAdapter(ArrayList<Bill> bills) {
        this.bills = bills;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public PayBillHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_pay_bill, parent, false);
        return new PayBillHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PayBillHolder payBillHolder, int i) {
        payBillHolder.bind(bills.get(i));
    }

    @Override
    public int getItemCount() {
        return bills.size();
    }

    public void reloadWith(ArrayList<Bill> bills) {
        this.bills = bills;
        notifyDataSetChanged();
    }

    public static class PayBillHolder extends RecyclerView.ViewHolder {

        private TextView billName, amountDueTextView;
        private EditText editText;

        public PayBillHolder(@NonNull View itemView) {
            super(itemView);
            billName = itemView.findViewById(R.id.cell_pay_bill_name);
            amountDueTextView = itemView.findViewById(R.id.cell_pay_bill_amountDueText);
            editText = itemView.findViewById(R.id.cell_pay_bill_editText);
        }

        public TextView getBillName() {
            return billName;
        }

        public TextView getAmountDueTextView() {
            return amountDueTextView;
        }

        public EditText getEditText() {
            return editText;
        }

        public void bind(Bill bill) {
            billName.setText(bill.getName());
            String amountDue = "Due: $" + bill.getAmountDue();
            amountDueTextView.setText(amountDue);
            editText.setText("");
        }
    }
}
