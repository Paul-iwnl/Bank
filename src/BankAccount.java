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
            System.out.println("Insufficient Balance");
        }
        else
        {
            balance = balance - amount;
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
