public class LinkedList 
{
    private Node head; // Reference to the first node in the linked list

    // Constructor to initialize an empty linked list
    public LinkedList() 
    {
        this.head = null;
    }

    // Getter method for the head node
    public Node getHead() 
    {
        return head;
    }

    // Method to add a new account to the linked list
    public void addAccount(BankAccount account) 
    {
        // Create a new node with the given account
        Node newNode = new Node(account);
        // If the list is empty, set the new node as the head
        if (head == null) 
        {
            head = newNode;
        } 
        else 
        {
            // Traverse to the end of the list and add the new node
            Node current = head;
            while (current.getNext() != null) 
            {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    // Method to remove an account from the linked list by its ID
    public void removeAccountById(long accountId) 
    {
        if (head == null) 
        {
            return;
        }
        if (head.getAccount().getAccountId() == accountId) 
        {
            head = head.getNext();
            return;
        }

        Node current = head;
        Node previous = null;

        // Traverse the list to find the node with the specified account ID
        while (current != null && current.getAccount().getAccountId() != accountId) 
        {
            previous = current;
            current = current.getNext();
        }
        // If the node is found, remove it from the list
        if (current != null) 
        {
            previous.setNext(current.getNext());
        }
    }

    // Method to display information of all accounts in the linked list
    public void displayAllAccounts() 
    {
        Node current = head;

        // Traverse the list and print information of each account
        while (current != null) 
        {
            current.getAccount().accountInformation();
            current = current.getNext();
        }
    }

    // Method to authenticate a user login
    public boolean login(String name, String password) 
    {
        Node current = head;
        // Traverse the list to find the account with the specified username and
        // password
        while (current != null) 
        {
            BankAccount account = current.getAccount();
            if (account.getName().equals(name) && account.getPassword().equals(password)) 
            {
                System.out.println("_______________________________________");
                System.out.println("Login successful! Welcome, " + name + "!");
                System.out.println("_______________________________________");
                return true;
            }
            current = current.getNext();
        }
        // If no matching account is found, display login failure message
        System.out.println("_______________________________________");
        System.out.println("Login failed! Invalid username or password.");
        System.out.println("_______________________________________");
        return false;
    }

    // Method to get the current balance of an account
    public double getCurrentAccountBalance(String name) 
    {
        Node current = head;
        // Traverse the list to find the account with the specified username
        while (current != null) 
        {
            BankAccount account = current.getAccount();
            if (account.getName().equals(name)) 
            {
                return account.checkBalance();
            }
            current = current.getNext();
        }
        // If the account is not found, return -1
        System.out.println("_______________________________________");
        System.out.println("Failed to retrieve balance. Account not found.");
        System.out.println("_______________________________________");
        return -1; // Return -1 if account not found
    }

    // Method to deposit funds into an account
    public boolean getCurrentAccountDeposit(String name, double deposit) 
    {
        Node current = head;
        // Traverse the list to find the account with the specified username
        while (current != null) 
        {
            BankAccount account = current.getAccount();
            if (account.getName().equals(name)) 
            {
                account.deposit(deposit);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    // Method to withdraw funds from an account
    public void getCurrentAccountWithdraw(String name, double withdraw) 
    {
        Node current = head;
        // Traverse the list to find the account with the specified username
        while (current != null) 
        {
            BankAccount account = current.getAccount();
            if (account.getName().equals(name)) 
            {
                account.withdraw(withdraw);
                break;
            }
            current = current.getNext();
        }
    }

    // Method to transfer funds between two accounts
    public boolean getTransferMoney(String name, long transferAccountId, double transferFund) 
    {
        // Check if the current account has sufficient balance for the transfer
        double currentAccountBalance = getCurrentAccountBalance(name);
        if (currentAccountBalance < transferFund) 
        {
            return false;
        }

        Node current = head;
        // Traverse the list to find the account to which funds will be transferred
        while (current != null) 
        {
            BankAccount account = current.getAccount();
            if (account.getAccountId() == transferAccountId) 
            {
                String transferAccountName = account.getName();
                // Deposit funds into the transfer account
                getCurrentAccountDeposit(transferAccountName, transferFund);
                // Withdraw funds from the current account
                getCurrentAccountWithdraw(name, transferFund);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }
}
