public class Node 
{
    private BankAccount account; // BankAccount object stored in the node
    private Node next; // Reference to the next node in the linked list

    // Constructor to initialize a node with a BankAccount object
    public Node(BankAccount account) 
    {
        this.account = account;
        this.next = null; // Initially, the next reference is set to null
    }

    // Getter method to retrieve the BankAccount object stored in the node
    public BankAccount getAccount() 
    {
        return account;
    }

    // Setter method to update the BankAccount object stored in the node
    public void setAccount(BankAccount account) 
    {
        this.account = account;
    }

    // Getter method to retrieve the reference to the next node
    public Node getNext() 
    {
        return next;
    }

    // Setter method to update the reference to the next node
    public void setNext(Node next) 
    {
        this.next = next;
    }
}
