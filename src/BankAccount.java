import java.util.concurrent.ThreadLocalRandom;

public class BankAccount 
{
    private long accountId;
    private String name;
    private double balance;
    private String Password;
    
    public BankAccount(String name, String Password ,double balance)
    {
        this.accountId = generateAccountId();
        this.name = name;
        this.Password = Password;
        this.balance = balance;
    }

    public void withdraw(double amount)
    {
        if(amount > balance)
        {
            System.out.println("_______________________________________");
            System.out.println("Insufficient Balance");
            System.out.println("_______________________________________");
        }
        else
        {
            balance = balance - amount;
            System.out.println("_______________________________________");
            System.out.println(amount + " has been withdrawn from your account.");
            System.out.println("_______________________________________");
        }
    }

    public void deposit (double amount)
    {
        balance = balance + amount;
    }

    
    public double checkBalance()
    {
        return balance;
    }
    
    public long getAccountId()
    {
        return accountId;
    }

    public String getName()
    {
        return name;
    }

    public String getPassword()
    {
        return Password;
    }

    public void accountInformation()
    {
        System.out.println("__________ACCOUNT INFORMATION__________");
        System.out.println("Name : "+name);
        System.out.println("Account ID :"+accountId);
        System.out.println("_______________________________________");
    }
    
    public static Long generateAccountId()
    {
        long generatedcode = ThreadLocalRandom.current().nextInt(100000, 1000000);
        return generatedcode;
    }
    
}
