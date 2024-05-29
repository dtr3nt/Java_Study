/**
* David Trent
* Due 18FEB29
* program2
* gq093
*/


public class LinkedStringList
{
  /**
  * Constructor : Set Linked List to empty
  */
  public LinkedStringList ()
  {
    count = 0;
    head = null;
  }
  
  /**
  * returns true if the queue is empty, Otherwise, returns false.
  */
  public boolean isEmpty()
  {
    return count == 0;
  }  

 /**
  * returns (false) ALWAYS
  */
  public boolean isFull()
  {
    return false;
  }

  /**
  * returns (int) elements in the LinkedStringList
  */
  public int size()
  {
    return count;
  }

  public LinkedStringListNode set_position(int index)
  {
    LinkedStringListNode n = head;
    for (int i = 0; i < index; i++) n = n.next;
    return n;
  }

  public void insert (String newStr, int index)
  {
    if (index < 0 || index > count)
    {
      throw new RuntimeException ("index Out of Bounds");
    }
    LinkedStringListNode new_node;
    LinkedStringListNode previous;
    LinkedStringListNode following;

    if (index > 0)
    {
      previous = set_position(index - 1);
      following = previous.next;
      new_node = new LinkedStringListNode(newStr, following);

      if (new_node == null) throw new RuntimeException ("Overflow");
      
      previous.next = new_node;  
    }    
    else
    {
      following = head;
      new_node = new LinkedStringListNode(newStr,following);
      if (new_node == null) throw new RuntimeException ("Overflow");
    
      head = new_node;
    }
    count++;
  } 

  
  
  public String retrieve (int index)
  {
    LinkedStringListNode current;
    if ( index < 0 || index >= count) throw new RuntimeException("Out of Bounds");
    current = set_position(index);
    return current.info;
  }

  public String replace(String newStr, int index)
  {
    LinkedStringListNode n = head;
    for (int i = 0; i < index - 1; i++)
    {
      n = n.next;
    }
    n.info = newStr;
    return n.info;
  }
  
  public void remove(int index)
  {
    LinkedStringListNode prior;
    LinkedStringListNode current;
    if (count == 0) throw new RuntimeException("Empty List");
    if (index < 0 || index >= count) throw new RuntimeException("Out of Bounds");
  
    if (index > 0)
    {
      prior = set_position(index - 1);
      current = prior.next;
      prior.next = current.next;
    }
    else
    {
      current = head;
      head = head.next;
    }
    count--;
  }

  public void clear()
  {
    head = null;
    count = 0;
  }
   
  private LinkedStringListNode head; // point to the head od LinkedStringList
  private int count; // element counts number of items in LinkedList
}

