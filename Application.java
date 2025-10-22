import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Udhar_Book udharBook = new Udhar_Book();
        Scanner input = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n>>>===== (UDHAR BOOK SYSTEM) =====<<<");
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Search Customer");
            System.out.println("4. Add Transaction Credit/Debit");
            System.out.println("5. Update Transaction");
            System.out.println("6. Display Customers");
            System.out.println("7. Display Transactions");
            System.out.println("8. Delete Customer/Transaction");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");

            while (!input.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                input.next();
            }
            choice = input.nextInt();

            switch (choice) {
                case 1 -> udharBook.addCustomer();
                case 2 -> udharBook.updateCustomer();
                case 3 -> udharBook.searchCustomer();
                case 4 -> udharBook.addTransaction();
                case 5 -> udharBook.updateTransaction();
                case 6 -> udharBook.displayCustomers();
                case 7 -> udharBook.displayTransactions();
                case 8 -> udharBook.deleteRecord();
                case 9 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 9);

        input.close();
    }
}

