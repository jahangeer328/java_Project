public class Transaction {
    private int customerID; // attribute of transaction class
    private double balance;
    private String date;
    private String[] transactionHistory; // String type array where we save our transaction  history
    private int transactionCount;  // track our transaction as per maxsize
    private static final int MAX_TRANSACTIONS = 100; // set maxsize upto 100


    // copy contructor 
    public Transaction(int customerID, double balance, String date) {
        this.customerID = customerID;
        this.balance = balance;
        this.date = date;
        this.transactionHistory = new String[MAX_TRANSACTIONS];
        this.transactionCount = 0;
        transactionHistory[transactionCount++] = "Initial Balance: " + balance + " on " + date;
    }

    // debit method 
    public void debit(double amount) {
        if (amount > 0) {
            balance += amount;
            if (transactionCount < MAX_TRANSACTIONS) {
                transactionHistory[transactionCount++] = "Debited: " + amount + " | New Balance: " + balance;
            }
        }
    }

    // credit method 
    public void credit(double amount) {
        if (amount > 0) {
            balance -= amount;
            if (transactionCount < MAX_TRANSACTIONS) {
                transactionHistory[transactionCount++] = "Credited: " + amount + " | New Balance: " + balance;
            }
        }
    }

    // getter method 
    public double getBalance()
     {
        return balance;
    }

    public int getCustomerID()
     {
        return customerID;
    }

    // data showing display method
    public void display() {

        System.out.printf("%-10s %-15s %-10s\n", "ID", "Balance", "Date");
        System.out.println("------------------------------------");
        System.out.printf("%-10s %-15s %-10s\n", customerID, balance, date );


        // System.out.println("Customer ID: " + customerID);
        // System.out.println("Current Balance: " + balance);
    
        // System.out.println("Date: " + date);
        System.out.println("Transaction History:");
        for (int i = 0; i < transactionCount; i++) {
            
            System.out.println(transactionHistory[i]);
        }
    }
}
