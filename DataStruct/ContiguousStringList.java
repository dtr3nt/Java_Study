/**
* David Trent
* Due 18FEB20
* program2
* gq093
*/

public class ContiguousStringList
{
  /**
  * Constructor : set array to be empty
  */
  public ContiguousStringList()
  {
    count = 0;
    strArray = new String[DEFAULT_ARRAY_SIZE];
  }  
  
  /**
  * returns (true) if Array is empty, (false) otherwise.
  */
  public boolean isEmpty()
  {
    return count == 0;
  }
  
  /**
  * returns (true) if Array is full, (false) otherwise.
  */
  public boolean isFull()
  {
    return count == DEFAULT_ARRAY_SIZE;
  }
  
  /**
  * returns (int) elements in the array
  */
  public int size()
  {
    return count;
  }
 
  /**
  * if array if full, throws RuntimeException
  * Shifts all present elements BACK apon insertion at Index
  */ 
  public void insert (String newStr, int arrPos)
  {
    if (count  == DEFAULT_ARRAY_SIZE) // array full
      throw new RuntimeException("Array if Full"); // Use FullArrayException later
    {
      for (int i = arrPos; i < DEFAULT_ARRAY_SIZE - 1; i++)
      {
        strArray[i+1] = strArray[i];
      }
      strArray[arrPos] = newStr;
      count++;
    }
  }
  
  /**
  * Returns String at int Position
  */
  public String retrieve (int arrPos)
  {
    if (count == 0)
      throw new RuntimeException ("Array is empty");
    else return strArray[arrPos];
  } 
  
  /**
  * Returns New String at Position
  */
  public String replace (String newStr, int arrPos)
  {
    return strArray[arrPos] = newStr;
  }
  
  /**
  * Shifts String Array FORWARD apon Removal
  * Defense Programming NOTE: 1st If Statement just to throw Exception
  */
  public void remove (int arrPos)
  {
    if (arrPos > DEFAULT_ARRAY_SIZE-1) strArray[arrPos] = strArray[arrPos+1];

    if (count == 0) // array empty 
      throw new RuntimeException("Array is Empty"); // Use EmptyArrayException later
    else if (arrPos == DEFAULT_ARRAY_SIZE-1)
    {
      strArray[arrPos] = null;
      count--;
    }
    else
    {
      for (int i = arrPos; i < DEFAULT_ARRAY_SIZE-1; i++)
      {
        strArray[i] = strArray[i+1];
      }
    count--;
    }  
  }

  /**
  * Sets count to ZERO 
  */
  public void clear ()
  {
    count = 0;
  }

  private static final int DEFAULT_ARRAY_SIZE = 3; // for test
  private String[] strArray; // Stores elements in String array
  private int count; // element counts number of items in array
} 
