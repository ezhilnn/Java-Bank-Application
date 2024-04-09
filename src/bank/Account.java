package bank;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//class Account {
//    -accountNumber: String
//    -balance: double
//    -transactions: List<Transaction>
//    +Account(accountNumber: String, initialBalance: double)
//    +getAccountNumber(): String
//    +getBalance(): double
//    +deposit(amount: double): boolean
//    +withdraw(amount: double): boolean
//    +addTransaction(transaction: Transaction)
//    +getTransactionHistory(): List<Transaction>
//}
public class Account {
    Transaction t=new Transaction();
    private String accountNumber;
    public ArrayList<Transaction> transactions;
    public String getAccountNumber() {

        return accountNumber;
    }
    public void deposit(double amount){

        this.balance+=amount;
        addTransaction(amount,"deposit");

    }
    public boolean withdraw(double amount){
        if(this.balance>=amount){

            this.balance-=amount;
            addTransaction(amount,"withdraw");
            return true;
        }
        return false;
    }

    public void addTransaction(double amount,String tType){
        ArrayList<String> arr=new ArrayList<>();
        arr.add(getCurrentDateTime());
        arr.add(String.valueOf(amount));
        arr.add(tType);
        arr.add(String.valueOf(this.balance));
//    transactions.add(arr);
        t.trans(arr);

    }
    public void getTransactions(){
        ArrayList<ArrayList<String>> trans=t.getTrans();
        System.out.println("-------Account Statement --------");
        for (ArrayList<String> transaction : trans) {
            for (String element : transaction) {
                System.out.print(element + " ");
            }
            System.out.println(); // New line for each transaction
        }
    }
    public static String getCurrentDateTime() {
        // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

        // Define the format for displaying the date and time
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Format the current date and time

        // Return the formatted date and time
        return currentDateTime.format(formatter);
    }
    public Account(String accountNumber,double initialBalance){
        this.accountNumber=accountNumber;
        this.balance=initialBalance;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {

        return balance;
    }
    public void filterByTranscation(String d){
        ArrayList<ArrayList<String>> trans=t.getTransactionType(d);
        System.out.println("-------Account Statement --------");
        for (ArrayList<String> transaction : trans) {
            for (String element : transaction) {
                System.out.print(element + " ");
            }
            System.out.println(); // New line for each transaction
        }

    }
    public void filterByAmount(Double d){
        ArrayList<ArrayList<String>> trans=t.getAmount(d);
        System.out.println("-------Account Statement --------");
        for (ArrayList<String> transaction : trans) {
            for (String element : transaction) {
                System.out.print(element + " ");
            }
            System.out.println(); // New line for each transaction
        }

    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    private double balance;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account acc = new Account("07810100014030", 0.0);

        while (true) {
            System.out.println("Select an option:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Transactions");
            System.out.println("5. Filter Transactions by Type");
            System.out.println("6. Filter Transactions by Amount");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + acc.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    acc.deposit(depositAmount);
                    System.out.println("Deposit successful.");
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (acc.withdraw(withdrawAmount)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient funds.");
                    }
                    break;
                case 4:
                    acc.getTransactions();
                    break;
                case 5:
                    System.out.print("Enter transaction type to filter by: ");
                    String transactionType = scanner.next();
                    acc.filterByTranscation(transactionType);
                    break;
                case 6:
                    System.out.print("Enter amount to filter by: ");
                    double filterAmount = scanner.nextDouble();
                    acc.filterByAmount(filterAmount);
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }


}
