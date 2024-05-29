
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @authors Scott Morris
 */
public class AddressBook implements Cloneable {

    /**
     * OVERVIEW: Constructor for AddressBook.This will create a new AddressBook 
     * object; check for an existing contact file and load contacts if exist.
     *
     * @throws java.io.IOException
     */
    public AddressBook() throws IOException {
        //MODIFIES: AddressBook object
        //EFFECTS: Creates a new AddressBook object.  A contact has four properties
        //firstName, lastName, email, phone.  If file exist his will read from 
        //disk all previously entered contacts that exis in contacts.dat; 
        //otherwise the book will be empty.
        //If any IO errors occur an IOException will be thrown.

        contacts = new ArrayList<>();
        readContacts();
    }

    /**
     * OVERVIEW: This method will check for an existing contacts dat file; if 
     * exist it will read the file and reload the address book. 
     * If there is an error with the file such as it does not exist an 
     * IOException will be thrown.
     *
     * @throws IOException
     * @throws EOFException
     */
    private void readContacts() throws IOException, EOFException {
        // EFFECTS: If contacts.dat file exist we will open the file using 
        // try-with-recourses so the file will be automatically closed after 
        //contact are added; if file does not exist the throws IOException.  
        //Called from addContacts and deleteContact

        int i = 0;
        //Check if an address book exist on disk
        Path AddrFile = Paths.get(CONTACT_FILE_NAME);
        if (Files.exists(AddrFile)) {
            //File Exist.
            //Open and load up the AddressBook
            try (var AddBK = new ObjectInputStream(
                    new BufferedInputStream(Files.newInputStream(AddrFile)))) {

                while (true) {
                    try {
                        Contact s = new Contact();
                        s = (Contact) AddBK.readObject();
                        contacts.add(s.clone());
                    } catch (ClassNotFoundException ex) {
                        Logger.getLogger(AddressBook.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            } catch (EOFException e) {                
            } catch (IOException e) {
                throw new IOException(e.toString());
            }
        }
    }

    /**
     * OVERVIESW: This method will check for an existing contacts dat file; if
     * exist it will reload new contacts into the file to be read at reload. If
     * there is an error with the file such as it does not exist an IOException
     * will be thrown.
     *
     * @throws IOException
     */
    private void writeContacts() throws IOException {
        //MODIFIES: Contacts.dat file
        //EFFECTS: If contacts.dat file exist we will open the file using 
        // try-with-recourses so the file will be automatically closed after contact
        // is appended; if file does not exist the throws IOException.  Called from 
        // addContacts and deleteContact

        Path AddrFile = Paths.get(CONTACT_FILE_NAME);
        // Create an output object stream for file contact.dat
        try (var outBinFile = new ObjectOutputStream(
                new BufferedOutputStream(Files.newOutputStream(AddrFile)))) {
            // Loop through contacts and write to binary file
            for (Contact newContact : contacts) {
                outBinFile.writeObject(newContact);
                outBinFile.flush();
            }
        } catch (IOException e) {
            throw new IOException(e.toString());
        }
    }

    /**
     * OVERVIEW: This method will add a newContact to the AddressBook and 
     * write the newContact to contact.dat
     * 
     * @param newContact
     * @throws NullPointerException
     * @throws EmptyNameException
     * @throws IOException
     * @throws DuplicateContactException
     */
    public void addContact(Contact newContact)
            throws NullPointerException, EmptyNameException, IOException, 
            DuplicateContactException {
        //REQUIRES: newContact firstName and lastName to exist
        //MODIFIES adds to contacts arrayList and AddressBook
        //EFFECTS: Takes a parameter of Contact Class called newContact.  
        //If newContact firstName or lastName is null then 
        //throws a NullPointerException "contact name cannot be null"; 
        //else if newContact firstName or newContact lastName are  
        //empty then throws EmptyNameException "contact name cannot be empty";
        //if the newContact already exist in the address book then 
        //throws a DuplicateContactException "Duplicate Contact";
        //If all requirements are met then a clone of the Contact class will 
        //be added to the contacts list and the newContact is written to the 
        //contact.dat
        if (newContact.firstName == null || newContact.lastName == null) {
            throw new NullPointerException("contact name cannot be null");
        } else if (newContact.firstName.isEmpty() || newContact.lastName.isEmpty()) {
            throw new EmptyNameException("contact name cannot be empty");
        }

        if (!doesExist(newContact.firstName, newContact.lastName)) {
            contacts.add(newContact.clone());
            writeContacts();
        } else {
            throw new DuplicateContactException("Duplicate Contact");
        }

    }

    private boolean doesExist(String firstName, String lastName) {
        //Check if the contact already exist in our AddressBook
        for (int i = 0; i <= contacts.size() - 1; i++) {
            if ((contacts.get(i).lastName.equals(lastName))
                    && (contacts.get(i).firstName.equals(firstName))) {
                //Contact Exist
                return true;
            }
        }
        //Contact does not exist
        return false;
    }

    /**
     * OVERVIEW: This will delete a requested contact from the AddressBook and 
     * re-write the addressBook to be read at reload.
     * 
     * @param firstName
     * @param lastName
     * @throws IOException
     * @throws NullPointerException
     * @throws EmptyNameException
     * @throws ContactNotFoundException
     */
    public void deleteContact(String firstName, String lastName)
            throws IOException, NullPointerException,
            EmptyNameException, ContactNotFoundException {
        //REQUIRES: newContact firstName and lastName to exist
        //MODIFIES: AddressBook by deleting requested contacts.
        //EFFECTS: If firstName and lastName are null throws NullPointerException
        //"contact name cannot be null"; else if newContact firstName or 
        //newContact lastName are empty then throws EmptyNameException 
        //contact name cannot be empty"; if all requirements are met and the 
        //requested Contact exists; then Contact is deleted and address book is 
        //re-written
        if (firstName == null || lastName == null) {
            throw new NullPointerException("contact name cannot be null");
        } else if (firstName.isEmpty() || lastName.isEmpty()) {
            throw new EmptyNameException("contact name cannot be empty");
        }

        if (doesExist(firstName, lastName)) {
            for (int i = 0; i <= contacts.size() - 1; i++) {
                if (contacts.get(i).firstName.equals(firstName)
                        && contacts.get(i).lastName.equals(lastName)) {
                    contacts.set(i, contacts.get(contacts.size() - 1));
                    contacts.remove(contacts.size() - 1);
                }
            }
            writeContacts();
        } else {
            throw new ContactNotFoundException("Contact does not exist");
        }

    }

    /**
     * Will search and return an array of all cloned Contact objects 
     * with the requested partial lastName
     * 
     * @param lastName
     * @return
     * @throws NullPointerException
     * @throws EmptyNameException
     */
    public Contact[] searchByLastNamePartial(String lastName)
            throws NullPointerException, EmptyNameException {
        //REQUIRES: a partial lastName to not be null or empty;
        //EFFECTS: checks if the partial lastName is null and throws a
        //NullPointerExceptions; checks if the partial lastName is empty 
        //throws a EmptyNameException.  If all requirements are met, then 
        //loops through to see if the partial lastName exist and return as 
        //array of all the cloned Contacts found.
        
        int index = 0;
        List<Contact> c = new ArrayList<Contact>();

        if (lastName == null) {
            throw new NullPointerException("Last Name cannot be null");
        } else if (lastName.isEmpty()) {
            throw new EmptyNameException("last name cannot be empty");
        }

        for (int i = 0; i <= contacts.size() - 1; i++) {
            if (contacts.get(i).lastName.contains(lastName)) {
                c.add(contacts.get(i).clone());
                index++;
            }
        }

        //Creates a new Contact array with the number of elements found
        Contact[] con = new Contact[c.size()];
        con = c.toArray(con);

        return con;
    }

    /**
     * Will search and return an array of all cloned Contact objects 
     * with the requested lastName 
     * 
     * @param lastName
     * @return
     * @throws NullPointerException
     * @throws EmptyNameException
     */
    public Contact[] searchByLastName(String lastName)
            throws NullPointerException, EmptyNameException {
        ArrayList<Contact> c = new ArrayList<Contact>();
        //REQUIRES: a lastName to not be null or empty;
        //EFFECTS: checks if the lastName is null and throws a
        //NullPointerExceptions; checks if the lastName is empty 
        //throws a EmptyNameException.  If all requirements are met, then 
        //loops through to see if the lastName exist and return an 
        //array of all the cloned Contacts found.
        
        if (lastName == null) {
            throw new NullPointerException("Last Name cannot be null");
        } else if (lastName.isEmpty()) {
            throw new EmptyNameException("last name cannot be empty");
        }

        int index = 0;
        for (int i = 0; i <= contacts.size() - 1; i++) {
            if (contacts.get(i).lastName.equals(lastName)) {
                c.add(contacts.get(i).clone());
                index++;
            }
        }

        Contact[] con = new Contact[c.size()];
        con = c.toArray(con);

        return con;
    }

    /**
     * Will return an array that list a clone of allContacts that currently 
     * exist in the addressBook.
     * 
     * @return
     */
    public Contact[] list() {        
        //EFFECTS: This will return an array of cloned Contacts objects.
        List<Contact> c = new ArrayList<Contact>();
        //Contact c[] = new Contact[contacts.size()];
        for (int i = 0; i <= contacts.size() - 1; i++) {
            c.add(contacts.get(i).clone());
        }

        //var myIntSet2 = (IntSet) myIntSet.clone();
        Contact[] con =  new Contact[c.size()];
        con = c.toArray(con);

        return con;
    }
    

    private final ArrayList<Contact> contacts;
    private final String CONTACT_FILE_NAME = "contact.dat";

}
