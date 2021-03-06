/**
*A class that implements a queue of objects by using
*a chain of linked nodes.
*/
public class QueueLinkList < T > implements QueueInterface < T >
{
    private Node firstNode; // references node at front of queue

    private Node lastNode; // references node at back of queue

    public QueueLinkList()
    {
        firstNode = null;
        lastNode = null;
    } 

    public void enqueue (T newEntry)
    {
        Node newNode = new Node (newEntry, null);
        if (isEmpty ())
            firstNode = newNode;
        else
            lastNode.setNextNode (newNode);
        lastNode = newNode;
    } 

    public T dequeue ()
    {
        T front = null;
        if (!isEmpty ())
        {
            front = firstNode.getData ();
            firstNode = firstNode.getNextNode ();
            if (firstNode == null)
                lastNode = null;
        } 
        return front;
    } 
	public T getFront( ) {
		@SuppressWarnings("unchecked")
		T front = (T)firstNode;
        return front;
    }


    public boolean isEmpty ()
    {
        return (firstNode == null) && (lastNode == null);
    } 


    public void clear ()
    {
        firstNode = null;
        lastNode = null;
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