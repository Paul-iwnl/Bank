import java.util.Scanner;

public class MainClass 
{
    public static void main(String args[]) 
    {
        // Initialize scanner for user input
        Scanner sc = new Scanner(System.in);

        // Create a linked list to store bank accounts
        LinkedList accountList = new LinkedList();

        // Variables to store user input and choices
        int choice, accountChoice;
        String name, password;
        double balance, deposit, withdraw, transferFund;
        long transferAccountId;

        // Main menu loop
        do 
        {
            System.out.println("__________Banking System menu__________");
            System.out.println("Press 1 : Add a new account");
            System.out.println("Press 2 : Log In to an Existing Account ");
            System.out.println("Press 3 : Display all account ");
            System.out.println("Press 4 : Exit");
            System.out.println("_______________________________________");

            System.out.println("Enter your choice : ");
            choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    // Add a new account
                    System.out.println("_______________________________________");
                    System.out.println("Enter name : ");
                    sc.nextLine(); // consume newline
                    name = sc.nextLine();
                    System.out.println("Enter a password : ");
                    password = sc.nextLine();
                    System.out.println("Enter your Initial Deposit :");
                    balance = sc.nextDouble();
                    BankAccount newAccount = new BankAccount(name, password, balance);
                    accountList.addAccount(newAccount);
                    System.out.println("Account added successfully !");
                    System.out.println("_______________________________________");
                    break;
                case 2:
                    // Log in to an existing account
                    System.out.println("_______________________________________");
                    System.out.println("Enter name : ");
                    sc.nextLine(); // consume newline
                    name = sc.nextLine();
                    System.out.println("Enter Password :");
                    password = sc.nextLine();
                    if (accountList.login(name, password)) 
                    {
                        // Sub-menu for account actions
                        do 
                        {
                            System.out.println("__________WELCOME " + name + "__________");
                            System.out.println("Press 1 : To Check Balance.");
                            System.out.println("Press 2 : To Deposit Money.");
                            System.out.println("Press 3 : To Withdraw Money.");
                            System.out.println("Press 4 : To Tranfer Money to Another Account.");
                            System.out.println("Press 5 : To View Transaction History.");
                            System.out.println("Press 6 : To Log Out");
                            System.out.println("_______________________________________");
                            System.out.println("Enter Your Choice :");
                            accountChoice = sc.nextInt();

                            switch (accountChoice) 
                            {
                                case 1:
                                    // Check balance
                                    balance = accountList.getCurrentAccountBalance(name);
                                    if (balance != -1) 
                                    {
                                        System.out.println("_______________________________________");
                                        System.out.println("Your current balance is: " + balance);
                                        System.out.println("_______________________________________");
                                    }
                                    break;

                                case 2:
                                    // Deposit money
                                    System.out.println("_______________________________________");
                                    System.out.println("Enter the deposit amount : ");
                                    deposit = sc.nextDouble();
                                    if (accountList.getCurrentAccountDeposit(name, deposit)) 
                                    {
                                        System.out.println("_______________________________________");
                                        System.out.println(deposit + " has been deposited to your account.");
                                        System.out.println("_______________________________________");
                                    } 
                                    else 
                                    {
                                        System.out.println("_______________________________________");
                                        System.out.println("Deposit failed");
                                        System.out.println("_______________________________________");
                                    }
                                    break;
                                case 3:
                                    // Withdraw money
                                    System.out.println("_______________________________________");
                                    System.out.println("Enter the withdraw amount : ");
                                    withdraw = sc.nextDouble();
                                    accountList.getCurrentAccountWithdraw(name, withdraw);
                                    break;

                                case 4:
                                    // Transfer money
                                    System.out.println("_______________________________________");
                                    System.out.println("Enter the Account ID You Want to Transfer the Money Into : ");
                                    transferAccountId = sc.nextLong();
                                    System.out.println("Enter the amount you want to transfer :");
                                    transferFund = sc.nextDouble();
                                    if (accountList.getTransferMoney(name, transferAccountId, transferFund)) 
                                    {
                                        System.out.println("_______________________________________");
                                        System.out.println("Transfer Successfull !");
                                        System.out.println("_______________________________________");
                                    } 
                                    else 
                                    {
                                        System.out.println("_______________________________________");
                                        System.out.println("Transfer failed !");
                                        System.out.println("_______________________________________");
                                    }
                                    break;

                                case 5:
                                    // View transaction history (not implemented)
                                    break;

                                case 6:
                                    // Log out
                                    break;

                                default:
                                    System.out.println("Enter a valid choice");
                                    break;
                            }

                        } while (accountChoice != 6);
                    }
                    break;
                case 3:
                    // Display all accounts
                    accountList.displayAllAccounts();
                    break;
                case 4:
                    // Exit the program
                    break;
                default:
                    System.out.println("Enter a valid choice");
                    break;
            }
        } while (choice != 4);

        // Close scanner to prevent resource leak
        sc.close();
    }
}
