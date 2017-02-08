import java.util.Vector;
/**
A class of stacks whose entries are stored in a vector.
*/
public class VectorStack < T > implements StackInterface < T >
{

    private Vector < T > stack; // last element is the top entry in stack

    private static final int DEFAULT_INITIAL_CAPACITY = 50;

    public VectorStack ()
    {
        this (DEFAULT_INITIAL_CAPACITY);
    }

    public VectorStack (int initialCapacity)
    {
        stack = new Vector < T > (initialCapacity); // size doubles as needed
    } 
 public void push(T newEntry)
    {
        stack = newEntry;
    } 

    public T peek()
    {
        if (isEmpty())
            throw new EmptyStackException();
        else
            return stack[topIndex];
    } 
    public T pop()
    {
        if (isEmpty())
        {
            throw new EmptyStackException();
        }
        else
        {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--; 
         return top;
        } 
   }

   public boolean isEmpty()
    {
        return topIndex < 0;
    } 
   
    public void clear()
    {
		// Remove references to the objects in the stack,
        // but do not deallocate the array
        while (topIndex > -1)
        {
            stack[topIndex] = null;
            topIndex--;
        }   
    }
} 