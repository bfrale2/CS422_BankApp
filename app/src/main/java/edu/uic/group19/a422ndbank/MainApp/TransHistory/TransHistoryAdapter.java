package edu.uic.group19.a422ndbank.MainApp.TransHistory;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import edu.uic.group19.a422ndbank.Models.TransHistory;
import edu.uic.group19.a422ndbank.R;

public class TransHistoryAdapter extends RecyclerView.Adapter<TransHistoryAdapter.TransHistoryHolder> {

    private ArrayList<TransHistory> transHistory;

    public TransHistoryAdapter(ArrayList<TransHistory> transHistory) {
        this.transHistory = transHistory;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    @NonNull
    @Override
    public TransHistoryHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cell_trans_history, parent, false);
        return new TransHistoryHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TransHistoryHolder viewHolder, int i) {
        viewHolder.bind(transHistory.get(i));
    }

    @Override
    public int getItemCount() {
        return transHistory.size();
    }

    public static class TransHistoryHolder extends RecyclerView.ViewHolder {

        private ImageView transactionIcon;
        private TextView typeText, date, amountView;


        public TransHistoryHolder(@NonNull View itemView) {
            super(itemView);
            transactionIcon = itemView.findViewById(R.id.cell_trans_hist_icon);
            typeText = itemView.findViewById(R.id.cell_trans_hist_typeText);
            date = itemView.findViewById(R.id.cell_trans_hist_date);
            amountView = itemView.findViewById(R.id.cell_trans_hist_transactionAmount);
        }

        public void bind(TransHistory item) {
            transactionIcon.setImageResource(item.getType().getDrawable());
            typeText.setText(item.getType().getDisplayText());
            date.setText(item.getDate());

            int amount = item.getAmount();
            if (amount >= 0) {
                amountView.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.positiveGreen));
            }
            else {
                amountView.setTextColor(ContextCompat.getColor(itemView.getContext(), R.color.negativeRed));
            }
            amountView.setText(Integer.toString(amount));
        }
    }
}
