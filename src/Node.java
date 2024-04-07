public class Node 
{
    private BankAccount account;
    private Node next;
    
    public Node (BankAccount account)
    {
        this.account = account;
        this.next = null;
    }

    public BankAccount getAccount()
    {
        return account;
    }

    public void setAccount (BankAccount account)
    {
        this.account = account;
    }

    public Node getNext()
    {
        return next;
    }

    public void setNext(Node next)
    {
        this.next = next;
    }
}
