import java.util.Scanner;

public class MainClass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        LinkedList accountList = new LinkedList();

        int choice;

        do
        {
            System.out.println("__________Banking System menu__________");
            System.out.println("Press 1 : Add a new account");
            System.out.println("Press 2 : Withdraw from an existing account");
            System.out.println("Press 3 : Deposit to an existing account");
            System.out.println("Press 4 : Display all account");
            System.out.println("Press 5 : Exit");
            System.out.println("_______________________________________");

            System.out.println("Enter your choice : ");
            choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    System.out.println("_______________________________________");
                    System.out.println("Enter name : ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Enter a password : ");
                    sc.nextLine();
                    String password = sc.nextLine();
                    System.out.println("Enter your Initial Deposit :");
                    double balance = sc.nextDouble();
                    BankAccount newAccount = new BankAccount(name,password,balance);
                    accountList.addAccount(newAccount);
                    System.out.println("Account added successfully !");
                    System.out.println("_______________________________________");
                    break;
                case 2:

                    break;
                case 4:
                    accountList.displayAllAccounts();
                    break;
                default:
                    System.out.println("Enter a valid choice");
                    break;
            }
        } while (choice != 5);
        sc.close();
    }
}
