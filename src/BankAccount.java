import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class BankAccount 
{
    // Member variables to store account information
    private long accountId;
    private String name;
    private double balance;
    private String Password;
    private List<Transaction> transactionHistory;

    // Constructor to initialize account details
    public BankAccount(String name, String Password, double balance) 
    {
        // Generating a unique account ID
        this.accountId = generateAccountId();
        this.name = name;
        this.Password = Password;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    // Method to withdraw money from the account
    public void withdraw(double amount) 
    {
        if (amount > balance) 
        {
            // Display insufficient balance message if withdrawal amount exceeds balance
            System.out.println("_______________________________________");
            System.out.println("Insufficient Balance");
            System.out.println("_______________________________________");
        } 
        else 
        {
            // Deduct the withdrawal amount from the balance
            balance = balance - amount;
            Transaction withdrawal = new Transaction(amount,"withdrawal");
            transactionHistory.add(withdrawal);
            // Display withdrawal confirmation message
            System.out.println("_______________________________________");
            System.out.println(amount + " has been withdrawn from your account.");
            System.out.println("_______________________________________");
        }
    }

    // Method to deposit money into the account
    public void deposit(double amount) 
    {
        // Add the deposited amount to the balance
        balance = balance + amount;
        Transaction deposit = new Transaction(amount, "Deposit");
        transactionHistory.add(deposit);
    }

    // Method to check the current balance of the account
    public double checkBalance() 
    {
        return balance;
    }

    // Method to get the account ID
    public long getAccountId() 
    {
        return accountId;
    }

    // Method to get the account holder's name
    public String getName() 
    {
        return name;
    }

    // Method to get the account holder's password (Note: Storing passwords in plain
    // text is not secure)
    public String getPassword() 
    {
        return Password;
    }

    // Method to display account information
    public void accountInformation() 
    {
        System.out.println("__________ACCOUNT INFORMATION__________");
        System.out.println("Name : " + name);
        System.out.println("Account ID :" + accountId);
        System.out.println("_______________________________________");
    }

    // Static method to generate a unique account ID using ThreadLocalRandom
    public static Long generateAccountId() 
    {
        long generatedcode = ThreadLocalRandom.current().nextInt(100000, 1000000);
        return generatedcode;
    }

    public void displayTransactionHistory()
    {
        System.out.println("_______________________________________");  
        System.out.println("Transcation History for "+name+" : ");
        for(Transaction transaction : transactionHistory)
        {
            System.out.println(transaction.getType() + ": $"+ transaction.getAmount());
        }
        System.out.println("_______________________________________");
    }

    public List<Transaction> getTransactionHistory() 
    {
        return transactionHistory;
    }
}
