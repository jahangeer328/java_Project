public class Customer {
    private int customerID;  //  attribute of customer class
    private String customerName;
    private String contactNo;
    

    // copy constructor class
    public Customer(int customerID, String customerName, String contactNo) {
         this.customerID = customerID;
        this.customerName = customerName;
        this.contactNo = contactNo;
    }

    // add get method for data retrieval
    public int getCustomerID()
     {
        return customerID;
    }

    // setter methodd
    public void setCustomerName(String customerName) 
    {
        this.customerName = customerName;
    }

    public void setContactNo(String contactNo)
     {
        this.contactNo = contactNo;
    }

    public void display() {
        System.out.printf("%-10s %-15s %-10s\n", "ID", "Name", "Contact_NO");
        System.out.println("--------------------------------------");
        System.out.printf("%-10s %-15s %-10s\n", customerID, customerName, contactNo);

       
    }
}
