/**
* A class that implements a stack of objects by using
* an array.
*/
import java.util.EmptyStackException;

public final class LinkedStack<T> implements StackInterface<T> 
{
    private Node topNode; // References the first node in the chain

    public LinkedStack() {
        topNode = null;
    }

    public void push(T newEntry) {
       topNode = new Node(newEntry, topNode);
    } 

    public T peek() {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return topNode.getData();
    }

    public T pop() {
        T top = peek();  // Might throw EmptyStackException
        assert (topNode != null);
        topNode = topNode.getNextNode(); 

        return top;
    } 

    public boolean isEmpty() {
        return topNode == null;
    } 
    
    public void clear() {
    {
        topNode = null;  // Causes deallocation of nodes in the chain
    }
}
    
    public String toString() {
		StringBuilder sb = new StringBuilder();
		Node currentN = topNode;
		while (currentN != null) {
			sb.insert(0, currentN.data);
			sb.insert(0, ' ');
			currentN = currentN.next;
		}
		sb.insert(0, "bottom");
		sb.append(" top");
		return sb.toString();
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
