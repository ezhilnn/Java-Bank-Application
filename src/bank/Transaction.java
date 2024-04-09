package bank;
import java.util.ArrayList;
import java.util.Date;

public class Transaction {
    public enum TransactionType {
        DEPOSIT,
        WITHDRAWAL
    }

    private TransactionType transactionType;
    private double amount;
    private Date date;
    private String remark;
    private ArrayList<ArrayList<String>> trans = new ArrayList<>();

    public void trans(ArrayList<String> tr) {
        this.trans.add(tr);
    }

    public ArrayList<ArrayList<String>> getTrans() {
        return trans;
    }

    // Method to get transactions with a specific amount
    public ArrayList<ArrayList<String>> getAmount(double amount) {
        ArrayList<ArrayList<String>> transactionsWithAmount = new ArrayList<>();
        for (ArrayList<String> tr : trans) {
            double trAmount = Double.parseDouble(tr.get(1)); // Assuming amount is at index 1
            if (trAmount == amount) {
                transactionsWithAmount.add(tr);
            }
        }
        return transactionsWithAmount;
    }


    // Method to get transactions with a specific date
    public ArrayList<ArrayList<String>> getDate(Date date) {
        ArrayList<ArrayList<String>> transactionsWithDate = new ArrayList<>();
        for (ArrayList<String> tr : trans) {
            // Assuming date is at index 1 and has been properly parsed or converted to Date object
            // For demonstration purpose, we're just adding all transactions
            transactionsWithDate.add(tr);
        }
        return transactionsWithDate;
    }

    // Method to get transactions with a specific transaction type
    public ArrayList<ArrayList<String>> getTransactionType(String type) {
        ArrayList<ArrayList<String>> transactionsWithType = new ArrayList<>();
        for (ArrayList<String> tr : trans) {
            // Assuming transaction type is at index 2
            if (tr.get(2).equals(type.toString())) {
                transactionsWithType.add(tr);
            }
        }
        return transactionsWithType;
    }
}
