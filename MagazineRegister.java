import java.util.ArrayList;
import java.util.Iterator;

/**
 * LALALALLALALLALALA
 * Represents a register for magazines.
 * This version will hold a collection of magazines. 
 * MagazineRegister has the following functions:
 * <ul>
 *  <li>Add a magazine to the magazine register</li>
 *  <li>Remove a magazine from the magazine register</li>
 *  <li>Search for all magazines by title</li>
 *  <li>Search for all magazines from one publisher</li>
 *  <li>List all magazines in the magazine register</li>
 * </ul>
 *
 * @author Martin Håhjem Årdal
 * @version 11.02.2019
 */
public class MagazineRegister
{
    private ArrayList<Magazine> magazines;
    /**
     * Constructor for objects of class Register.
     * Initalizes an arraylist to hold objects of the type Magazine.
     */
    public MagazineRegister()
    {
        magazines = new ArrayList<Magazine>();
    }

    //----------------ArrayList Functionality Methods ---------
    /**
     * isEmpty checks if the magazine register is empty.
     * @return returns true if empty, false if not
     */
    public boolean isEmpty()
    {
        return magazines.isEmpty();
    }

    /**
     * iterator returns an iterator from the magazine register.
     * @return returns an iterator for a arraylist of magazine objects. 
     */
    public Iterator<Magazine> iterator()
    {
        return magazines.iterator();
    }

    //----------------Register Methods ---------
    /**
     * Adds a magazine to the magazine register
     * and returns true if successful. Checks first if the same title
     * already exists in the magazine register. If not matching title 
     * found add the magazine to the magazine register. Returns true
     * if successfull, false if not.
     * @param title The title of the magazine.
     * @param publisher The publisher of the magazine. 
     * @param genre The genre of the magazine.
     * @param numPublications The number of publications over a year.
     * @return true if same title for magazine is found, false if not
     */
    public boolean addNewMagazine(String title, String publisher, String genre,
    String numPublications)
    {
        boolean valid = true;
        for (Magazine magazine : magazines)
        {
            if (magazine.getTitle().equals(title))
            {
                valid = false;
            }
        }
        if (valid)
        {
            magazines.add(new Magazine(title, publisher,
                genre, numPublications));
        }
        return valid;
    }

    /**
     * Removes a magazine from magazine register whose titles
     * exactly matches searchstring, removes the magazine and returns
     * true if magazine is removed, false otherwise.
     *  
     * @param searchString The title of the magazine that will be removed. 
     * @return removed True if magazine is removed, false if otherwise.
     */
    public boolean removedByTitle(String searchString)
    {
        Iterator<Magazine> it = magazines.iterator();
        boolean removed = false;
        while (it.hasNext())
        {
            Magazine magazine = it.next();
            if (magazine.getTitle().trim().equals(searchString.trim()))
            {
                it.remove();
                removed = true;
            }
        }
        return removed;
    }

    /**
     * Searches the magazine register for all 
     * magazines with matching title. Is not case sensetive. 
     * 
     * @param title The title of the magazine to find.
     * @return returnList the list of all the magazines with
     * titles matching the user given title.
     */
    public ArrayList<Magazine> searchByTitle(String title)
    {
        ArrayList<Magazine> returnList = new ArrayList<Magazine>();

        for (Magazine magazine : magazines)
        {   
            String magazineTitle = magazine.getTitle().trim().toLowerCase();
            if (magazineTitle.contains(title.trim().toLowerCase()))
            {
                returnList.add(magazine);
            }
        }

        return returnList;
    }

    /**
     * Searches the magazine register for all magazines with matching publisher.
     * Is not case sensetive.
     * 
     * @param publisher The publisher of the magazine to find.
     * @return returnList the list of all the magazines 
     *         with publisher matching the user given title.
     */
    public ArrayList<Magazine> searchByPublisher(String publisher)
    {
        ArrayList<Magazine> returnList = new ArrayList<Magazine>();

        for (Magazine magazine : magazines)
        {   
            String magazinePubl = magazine.getPublisher().trim().toLowerCase();
            if (magazinePubl.contains(publisher.trim().toLowerCase()))
            {
                returnList.add(magazine);
            }
        }

        return returnList;
    }
}
