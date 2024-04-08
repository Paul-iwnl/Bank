public class LinkedList 
{
    private Node head;
    
    public LinkedList()
    {
        this.head = null;
    }

    public Node getHead()
    {
        return head;
    }

    public void addAccount(BankAccount account)
    {
        Node newNode = new Node(account);
        if(head == null)
        {
            head = newNode;
        }
        else
        {
            Node current = head;
            while (current.getNext() != null) 
            {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    public void removeAccountById(long accountId)
    {
        if(head == null)
        {
            return;
        }
        if(head.getAccount().getAccountId() == accountId)
        {
            head = head.getNext();
            return;
        }

        Node current = head;
        Node previous = null;

        while (current != null && current.getAccount().getAccountId() != accountId)
        {
            previous = current;
            current = current.getNext();
        }
        if(current != null)
        {
            previous.setNext(current.getNext());
        }
    }

    public void displayAllAccounts()
    {
        Node current = head;

        while(current != null)
        {
            current.getAccount().accountInformation();
            current = current.getNext();
        }
    }

    public boolean login(String name, String password) 
    {
        Node current = head;
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
        System.out.println("_______________________________________");
        System.out.println("Login failed! Invalid username or password.");
        System.out.println("_______________________________________");
        return false;
    }

    public double getCurrentAccountBalance(String name) 
    {
        Node current = head;
        while (current != null) 
        {
            BankAccount account = current.getAccount();
            if (account.getName().equals(name)) 
            {
                return account.checkBalance();
            }
            current = current.getNext();
        }
        System.out.println("_______________________________________");
        System.out.println("Failed to retrieve balance. Account not found.");
        System.out.println("_______________________________________");
        return -1; // Return -1 if account not found
    }

    public boolean getCurrentAccountDeposit(String name, double deposit)
    {
        Node current = head;
        while (current != null) 
        {
            BankAccount account = current.getAccount();
            if(account.getName().equals(name))
            {
                account.deposit(deposit);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    public void getCurrentAccountWithdraw(String name, double withdraw)
    {
        Node current = head;
        while(current != null)
        {
            BankAccount account = current.getAccount();
            if(account.getName().equals(name))
            {
                account.withdraw(withdraw);
                break;
            }
            current = current.getNext();
        }
    }

    public boolean getTransferMoney(String name,long transferAccountId,double transferFund)
    {
        double currentAccountBalance = getCurrentAccountBalance(name);
        if(currentAccountBalance < transferFund)
        {
            return false;
        }
        
        Node current = head;
        while(current != null)
        {
            BankAccount account = current.getAccount();
            if(account.getAccountId() == transferAccountId)
            {
                String transferAccountName = account.getName();
                getCurrentAccountDeposit(transferAccountName, transferFund);
                getCurrentAccountWithdraw(name, transferFund);
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

}
