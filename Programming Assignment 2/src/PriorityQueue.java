/**
  * PriorityQueue demonstrates a priority queue using a Heap.
  * ArrayHeap can be implemented as discussed in class.
  *
*/

public class PriorityQueue extends ArrayHeap
{
	private int size;
	
   /**
    * Creates an empty priority queue.
   */
	public PriorityQueue()
	{
      super();
      size = 0;
	}

      
   /**
    * Adds the given element to this PriorityQueue.
    *
    * @param object the element to be added to the priority queue
    * @param priority the integer priority of the element to be added
   */
   public void addElement (HuffmanTreeNode object, int priority)
   {
	  size++;
      PriorityQueueNode node = new PriorityQueueNode(object, priority);
      super.addElement(node);
   }

   /**
    * Removes the next highest priority element from this priority
    * queue and returns a reference to it.
    *
    * @return a reference to the next highest priority element in this queue
   */
   public HuffmanTreeNode removeNext()
   {
	  size--;
      PriorityQueueNode temp = super.removeMin();
      return temp.getElement();
   }
   
   public int getSize() {
	   return size;
   }

}