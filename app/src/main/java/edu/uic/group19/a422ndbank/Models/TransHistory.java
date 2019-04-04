package edu.uic.group19.a422ndbank.Models;

import edu.uic.group19.a422ndbank.R;

public class TransHistory {
    private TransHistoryType type;
    private int amount;
    private String date;

    public TransHistory(TransHistoryType type, int amount, String date) {
        this.type = type;
        this.amount = amount;
        this.date = date;
    }

    public TransHistoryType getType() {
        return type;
    }

    public int getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public enum TransHistoryType {
        Mobile("Mobile", R.drawable.mobile_icon),
        BalanceTransfer("Balance Transfer", R.drawable.balance_transfer_icon),
        Deposit("Deposit", R.drawable.deposit_icon);

        private final String displayText;
        private int drawable;

        TransHistoryType(String displayText, int drawable) {
            this.displayText = displayText;
            this.drawable = drawable;
        }

        public String getDisplayText() {
            return displayText;
        }

        public int getDrawable() {
            return drawable;
        }
    }
}
