/**
A class that implements a queue of objects by using
a two-part circular chain of linked nodes
*/
public class circularLinkedQueue < T > implements QueueInterface < T >
{
    private Node queueNode; // references first node in queue
    private Node freeNode; // references node after back of queue
    
    public circularLinkedQueue ()
    {
        freeNode = new Node (null, null);
        freeNode.setNextNode (freeNode);
        queueNode = freeNode;
    } 


    public void enqueue (T newEntry)
    {
        freeNode.setData (newEntry);
        if (isChainFull ())
        {
            // allocate a new node and insert it after the node that
            // freeNode references
            Node newNode = new Node (null, freeNode.getNextNode ());
            freeNode.setNextNode (newNode);
        } 
        freeNode = freeNode.getNextNode ();
    } 


    public T getFront ()
    {
        T front = null;
        if (!isEmpty ())
            front = queueNode.getData ();
        return front;
    } 


    public T dequeue ()
    {
        T front = null;
        if (!isEmpty ())
        {
            front = queueNode.getData ();
            queueNode.setData (null);
            queueNode = queueNode.getNextNode ();
        } 
        return front;
    } 


    public boolean isEmpty ()
    {
        return queueNode == freeNode;
    } 

	public void clear() {
        queueNode = null;  // Causes deallocation of nodes in the chain
    }

    private boolean isChainFull(){
        return queueNode == freeNode.getNextNode ();
    } 


    private class Node {
        private T    data; // Entry in stack
        private Node next; // Link to next node
      
        private Node(T dataPortion){
            this(dataPortion, null);
        } 
        
        private Node(T dataPortion, Node linkPortion){
            data = dataPortion;
            next = linkPortion;    
        } 
        
        private T getData() {
            return data;
        } 
        
        private void setData(T newData) {
            data = newData;
        } 
        
        private Node getNextNode() {
            return next;
        } 
        
        private void setNextNode(Node nextNode) {
            next = nextNode;
        } 
        
    } 
    
} 