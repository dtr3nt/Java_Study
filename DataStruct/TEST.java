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

  public void insert (String newStr, int index)
  { 
    if (index < 0 || index > count) throw new RuntimeException ("index OutofBounds");
    if (count == 0)
    {
      LinkedStringListNode node = new LinkedStringListNode();
      node.info = newStr;
      node.next = null;
      if (head == null)
      {
        head = node;
      }
      else
      {
        LinkedStringListNode n = head;
        while (n.next != null)
        {
          n = n.next;
        }
        n.next = node;
      }
    }
    else if ( index == count-1)
    {
      LinkedStringListNode n = head;
      for (int i = 0; i < index - 1; i++)
      {
        n = n.next;
      }
      LinkedStringListNode node = new LinkedStringListNode();
      node.info = newStr;
      n.next = node;
      node.next = null;
    }
    else if (index == 0)
    {
      LinkedStringListNode n = head;
      LinkedStringListNode node = new LinkedStringListNode();
      node.info = newStr;
      LinkedStringListNode temp = n.next;
      n.next = node;
      node.next = temp;
    }
    else
    {
      LinkedStringListNode n = head;
      for (int i = 0; i < index - 1; i++)
      {
        n = n.next;
      }
      LinkedStringListNode node = new LinkedStringListNode();
      node.info = newStr;
      LinkedStringListNode temp = n.next;
      n.next = node;
      node.next = temp;
    }
    count++;
  }
  
  public String retrieve(int index)
  {
    if (count == 0) throw new RuntimeException("Link List Empty");

    LinkedStringListNode n = head;
    if (index == 0) return n.info;
    else
    {
      for (int i = 0; i < index - 1; i++)
      {
        n = n.next;
      }
      return n.info;
    }
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
  
  public void remove( int index)
  {
    LinkedStringListNode n = head;
    if (index == 0)
    {
      n.info = null;
    }
    else if (index != 0)
    {
      for (int i = 0; i < index - 1; i++)
      {
        n = n.next;
      }
      n.info = null;
    }
    count--;
  }
   
  private LinkedStringListNode head; // point to the head od LinkedStringList
  private int count; // element counts number of items in LinkedList
}

