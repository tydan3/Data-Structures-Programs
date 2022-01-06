/**
* PriorityQueueNode represents a node in a priority queue containing a
* comparable object, order, and a priority value.
*
*/

public class PriorityQueueNode implements Comparable<PriorityQueueNode>
{
   private static int nextorder = 0;
   private int priority;
   private int order;
   private HuffmanTreeNode element;
   
   /**
     * Creates a new PriorityQueueNode with the specified data.
     *
     * @param obj the element of the new priority queue node
     * @param prio the integer priority of the new queue node
   */
   public PriorityQueueNode (HuffmanTreeNode obj, int prio)
   {
      this.element = obj;
      this.priority = prio;
      this.order = nextorder;
      nextorder++;
   }

   /**
     * Returns the element in this node.
     *
     * @return the element contained within this node
   */
   public HuffmanTreeNode getElement()
   {
      return this.element;
   }

   /**
     * Returns the priority value for this node.
     *
     * @return the integer priority for this node
   */
   public int getPriority()
   {
      return this.priority;
   }

   /**
     * Returns the order for this node.
     *
     * @return the integer order for this node
   */
   public int getOrder()
   {
      return this.order;
   }

   /**
     * Returns a string representation for this node.
     *
   */
   public String toString()
   {
      String temp = (this.element.toString() + this.priority + this.order);
      return temp;
   }

   /**
     * Returns the 1 if the current node has higher priority than
     * the given node and -1 otherwise.
     *
     * @param obj the node to compare to this node
     * @return the integer result of the comparison of the obj node and
     * this one
   */

   public int compareTo(PriorityQueueNode obj)
   {
      int result;
      PriorityQueueNode temp = obj;
      if (this.priority > temp.getPriority())
         result = 1;
      else if (this.priority < temp.getPriority())
         result = -1;
      else if (this.order > temp.getOrder())
         result = 1;
      else
         result = -1;
      
      return result;
   }
}