import java.util.Scanner;

public class Udhar_Book {
    private Customer[] customers; // create customer class object 
    private Transaction[] transactions; // create transaction class object 
    private int customerCount; // for track customer as per maxsize
    private int transactionCount;
    private static final int MAX_SIZE = 100; // set maxsize as 100
    private Scanner input = new Scanner(System.in); /// Scanner class for input

    // create constructor of udhar_Book class
    public Udhar_Book() {
        customers = new Customer[MAX_SIZE]; // contructor give maxsize
        transactions = new Transaction[MAX_SIZE]; // constructor give maxsize
        customerCount = 0;   // initalize customer Count with 0
        transactionCount = 0; // intialize transaction count with 0
    }



    // add customer method 
    public void addCustomer() {

        // this condition will  chack our customer count less than maxsize  
        //if it's correct then continue process or not correct then jump to else condition
        if (customerCount < MAX_SIZE) {
            
            System.out.print("Enter Customer ID: ");
            int id = input.nextInt(); input.nextLine();
            System.out.print("Enter Name: ");
            String name = input.nextLine();
            System.out.print("Enter Contact: ");
              String contact = input.nextLine();

            customers[customerCount++] = new Customer(id, name, contact);
            System.out.println("Customer added successfully!");
        } else {
            System.out.println("Customer list full.");
        }
    }

    // Customer update metthod 
    public void updateCustomer() {
         System.out.print("Enter Customer ID to update: ");
        int id = input.nextInt(); input.nextLine();
        // if customer id equals to customer id then allow to update custoemr detaials or not correct give answer as per condition
        //this loop will start from 0 and till check id will same and change
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerID() == id) { // this condition will check customers id == equals to id if equal  then allow to update or not same then give answer as per condition
                 System.out.print("New Name: ");
                String name = input.nextLine();
                System.out.print("New Contact: ");
                String contact = input.nextLine();
                customers[i].setCustomerName(name);
                 customers[i].setContactNo(contact);
                System.out.println("Customer updated.");
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    // search customer is there are not 
    public void searchCustomer() {
         System.out.print("Enter Customer ID: ");  // this method will found customer with her id and dispaly her details
        int id = input.nextInt();

        // this loop start  with 0 till customer count if in this loop 0 to customer count
        // first,between and last anywhere id will same then it will show you customer detials or not then give answer as per condition 
        for (int i = 0; i < customerCount; i++) {
            if (customers[i].getCustomerID() == id) {
                 customers[i].display();
                return;
            }
        }
        System.out.println("Customer not found.");
    }

    // display method 
    public void displayCustomers() {
        // this condition will check customer count equal to == 0 then show not customer available and return
        if (customerCount == 0) {
             System.out.println("No customers available.");
            return;
        } // else customer avaialable then display as per customer class display method
        for (int i = 0; i < customerCount; i++) {
            customers[i].display();
            transactions[i].display();
            System.out.println("---------------------------------------");
        }
    }

    // add transaction 
    public void addTransaction() {
        System.out.print("Enter Customer ID: ");
        int id = input.nextInt();
        
        for (int i = 0; i < transactionCount; i++) {
            if (transactions[i].getCustomerID() == id) {
                System.out.print("Credit or Debit (C/D): ");
                char type = input.next().toUpperCase().charAt(0);
                System.out.print("Amount: ");
                double amount = input.nextDouble();
                if (type == 'C') {
                    transactions[i].credit(amount);
                    System.out.println("Credited successfully.");
                } else if (type == 'D') {
                    transactions[i].debit(amount);
                    System.out.println("Debited successfully.");
                } else {
                    System.out.println("Invalid type.");
                }
                return;
            }


        }

        // if already no have transaction then frist add transaction
        if (transactionCount < MAX_SIZE) {
            System.out.print("Enter Initial Balance: ");
            double balance = input.nextDouble(); input.nextLine();
            System.out.print("Enter Date: ");
            String date = input.nextLine();
            transactions[transactionCount++] = new Transaction(id, balance, date);
            System.out.println("Transaction created.");
        } else {
            System.out.println("Transaction list full.");
        }
    }

    // transactionn update method 
    public void updateTransaction() {
        System.out.print("Enter Customer ID: ");
        int id = input.nextInt(); input.nextLine();
        for (int i = 0; i < transactionCount; i++) { // this loop will run 0 to transaction Count
            if (transactions[i].getCustomerID() == id) { // if your id equal to your customer id then process or not 
                System.out.print("Enter New Balance: ");
                double balance = input.nextDouble(); input.nextLine();
                System.out.print("Enter New Date: ");
                String date = input.nextLine();
                transactions[i] = new Transaction(id, balance, date);
                System.out.println("Transaction updated.");
                return;
            }
        }
        System.out.println("Transaction not found.");
    }


    // display method
    public void displayTransactions() {
        if (transactionCount == 0) { // if transaction == zero then give answer as per condition
            System.out.println("No transactions available.");
            return;
        }
        for (int i = 0; i < transactionCount; i++) { // then display
            transactions[i].display();
            System.out.println("------------------------------");
        }
    }

    // transaction and customer record delete method
    public void deleteRecord() {
        System.out.print("Delete Customer (C) or Transaction (T)? ");
        char ch = input.next().toUpperCase().charAt(0);
        System.out.print("Enter ID: ");
        int id = input.nextInt();

        if (ch == 'C') {
            for (int i = 0; i < customerCount; i++) {
                if (customers[i].getCustomerID() == id) {  // if id equals to customer id then delete customer record
                    for (int j = i; j < customerCount - 1; j++) {
                        customers[j] = customers[j + 1];
                    }
                    customerCount--;
                    System.out.println("Customer deleted.");
                    return;
                }
            }
        } else if (ch == 'T') { // or if  in transaction delete method id equals to transactionCustomer id then delete customer record
            for (int i = 0; i < transactionCount; i++) {
                if (transactions[i].getCustomerID() == id) {  // id equals then delete transaction 
                    for (int j = i; j < transactionCount - 1; j++) {
                        transactions[j] = transactions[j + 1];
                    }
                    transactionCount--;
                    System.out.println("Transaction deleted.");
                    return;
                }
            }
        } else { // else not found then run this condtion
            System.out.println("Invalid input.");
        }
    }
}
