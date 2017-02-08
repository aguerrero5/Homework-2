/**
* A class that implements a queue of objects by using
* an array.
*/

public class QueueArray<T> implements QueueInterface<T>
{
   private final int DEFAULT_CAPACITY = 100;
   private int rear;
   private T[] queue; 
   private T result;

 //Creates an empty queue using the default capacity.
   public QueueArray()
   {
      rear = 0;
      queue = (T[])(new Object[DEFAULT_CAPACITY]);
   }

   
  //Creates an empty queue using the specified capacity.
   public QueueArray(int initialCapacity)
   {
      rear = 0;
      queue = (T[])(new Object[initialCapacity]);
   }

 /* Adds the specified element to the rear of this queue, expanding
     the capacity of the queue array if necessary.*/
  
   public void enqueue (T element)
   {
      if (size() == queue.length) 
         expandCapacity();

      queue[rear] = element;
      rear++;
   }
     /*Removes the element at the front of this queue and returns a
     reference to it. Throws an EmptyCollectionException if the
     queue is empty.*/
 
   public T dequeue(){
      T result = queue[0];

      rear--;

      // shift the elements
      for (int scan=0; scan < rear; scan++)
         queue[scan] = queue[scan+1];
      
      queue[rear] = null;
 
      return result;
   }
   
     /*Returns a reference to the element at the front of this queue.
     The element is not removed from the queue.  Throws an
     EmptyCollectionException if the queue is empty. */ 
   
   public T getFront(){
     return queue[0];
   }
    // Returns true if this queue is empty and false otherwise. 
   
   public boolean isEmpty()
   {
      return (rear == 0);
   }
   
    // Returns the number of elements currently in this queue.
   public int size()
   {
      return rear;
   }

    // Returns a string representation of this queue. 
    public String toString(){
      String result = "";

      for (int scan=0; scan < rear; scan++) 
         result = result + queue[scan].toString() + "\n";

      return result;
   }
   private void expandCapacity()
   {
      T[] larger = (T[])(new Object[queue.length*2]);

      for (int scan=0; scan < queue.length; scan++)
         larger[scan] = queue[scan];

      queue = larger;
   }
   public void clear(){
	   queue[rear]= null;
   }
}