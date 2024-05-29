/**
* A node of LinkedStringList
*/
public class LinkedStringListNode
{
  public String info; // the INFO part in the Node
  public LinkedStringListNode next; // point to next node in the LinkedStringList

  public LinkedStringListNode()
  {
    next = null;
  }

  public LinkedStringListNode( String item, LinkedStringListNode next) 
  {
    info = item;
    this.next = next;
  }
}


