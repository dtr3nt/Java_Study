
import java.io.Serializable;

/**
 * OVERVIEW: This class contains all the properties of a Contact.  I consist of
 * 2 constructors.  One with no parameters and one with the lastName and 
 * firstName parameter.  This class also contains an Override clone method 
 * that will return a cloned copy of the Contacts object when a Contacts object 
 * calls the .clone() call.
 * 
 * @authors Scott Morris
 * 
 */
public class Contact implements Serializable, Cloneable {

    protected String firstName;
    protected String lastName;
    protected String email;
    protected String phone;

    public Contact() {
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.phone = "";
    }

    public Contact(String fname, String lname) {
        this.firstName = fname;
        this.lastName = lname;
        this.email = "";
        this.phone = "";
    }
    
    @Override
    public Contact clone()
    {
        Contact c = null;        
        try
        {
            c = (Contact) super.clone();
        } catch (CloneNotSupportedException e)
        {
            //will not happen
        }
        return c;
    }
}
