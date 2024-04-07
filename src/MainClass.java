import java.util.Scanner;

public class MainClass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        LinkedList accountList = new LinkedList();

        int choice,accountChoice;
        String name,password;

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
                    System.out.println("_______________________________________");
                    System.out.println("Enter name : ");
                    sc.nextLine();
                    name = sc.nextLine();
                    System.out.println("Enter a password : ");
                    password = sc.nextLine();
                    System.out.println("Enter your Initial Deposit :");
                    double balance = sc.nextDouble();
                    BankAccount newAccount = new BankAccount(name,password,balance);
                    accountList.addAccount(newAccount);
                    System.out.println("Account added successfully !");
                    System.out.println("_______________________________________");
                    break;
                case 2:
                    System.out.println("_______________________________________");
                    System.out.println("Enter name : ");
                    sc.nextLine();
                    name = sc.nextLine();
                    System.out.println("Enter Password :");
                    password = sc.nextLine();
                    if(accountList.login(name, password))
                    {
                        do
                        {
                            System.out.println("__________WELCOME "+name+" __________");
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
                                    
                                    break;
                                    
                                case 2:

                                    break;

                                case 3:

                                    break;

                                case 4:

                                    break;

                                case 5:

                                    break;

                                case 6:

                                    break;

                                default:
                                    System.out.println("Enter a valid choice");
                                    break;
                            }

                        }while (accountChoice != 6);
                    }
                    break;
                case 3:
                    accountList.displayAllAccounts();
                    break;
                default:
                    System.out.println("Enter a valid choice");
                    break;
            }
        } while (choice != 4);
        sc.close();
    }
}
