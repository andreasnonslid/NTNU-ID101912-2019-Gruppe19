
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;

/**
 * Makes up the user interface (text based) of the application.
 * Responsible for all user interaction, like displaying the menu
 * and receiving input from the user.
 * 
 * @author asty
 * @version 1.0
 */
public class ApplicationUI 
{

    // The menu that will be displayed.
    private String[] menuItems = {
        "1. List all magazines",
        "2. Add new magazine",
        "3. Find a magazine by title",
        "4. Find magazine by publisher",
        "5. Remove magazine by title",
    };
    private MagazineRegister magazineRegister;

    /**
     * Creates an instance of the ApplicationUI User interface.
     * Initalizes a magazine register. 
     */
    public ApplicationUI() 
    {
        magazineRegister = new MagazineRegister();
    }

    /**
     * Starts the application by showing the menu and retrieving input from the
     * user.
     */
    public void start() 
    {
        this.init();

        boolean quit = false;

        while (!quit) 
        {
            try 
            {
                int menuSelection = this.showMenu();
                switch (menuSelection) 
                {
                    case 1:
                        this.printAllMagazines();
                        break;

                    case 2:
                        this.addNewMagazine();
                        break;

                    case 3:
                        this.findMagazineByTitle();
                        break;

                    case 4:
                        this.findMagazineByPublisher();
                        break;

                    case 5:
                        this.removeByTitle();
                        break;

                    case 6:
                        System.out.println("\nThank you for using Application v0.1. Bye!\n");
                        quit = true;
                        break;

                    default:
                }
            } 
            catch (InputMismatchException ime) 
            {
                System.out.println("\nERROR: Please provide a number between 1 and " + this.menuItems.length + "..\n");
            }
        }        

    }

    /**
     * Displays the menu to the user, and waits for the users input. The user is
     * expected to input an integer between 1 and the max number of menu items. 
     * If the user inputs anything else, an InputMismatchException is thrown. 
     * The method returns the valid input from the user.
     *
     * @return the menu number (between 1 and max menu item number)
     *      provided by the user.
     * @throws InputMismatchException if user enters an
     *      invalid number/menu choice
     */
    private int showMenu() throws InputMismatchException 
    {
        System.out.println("\n**** Application v0.1 ****\n");
        // Display the menu
        for ( String menuItem : menuItems )
        {
            System.out.println(menuItem);
        }
        int maxMenuItemNumber = menuItems.length + 1;
        // Add the "Exit"-choice to the menu
        System.out.println(maxMenuItemNumber + ". Exit\n");
        System.out.println("Please choose menu item (1-" + maxMenuItemNumber + "): ");
        // Read input from user
        Scanner reader = new Scanner(System.in);
        int menuSelection = reader.nextInt();
        if ((menuSelection < 1) || (menuSelection > maxMenuItemNumber)) 
        {
            throw new InputMismatchException();
        }
        return menuSelection;
    }

    // ------ The methods below this line are "helper"-methods, used from the menu ----
    // ------ All these methods are made privat, since they are only used by the menu ---

    /**
     * Initializes the application.
     * Typically you would create the LiteratureRegistrer-instance here
     */
    private void init()
    {
        System.out.println("init() was called");
        addDummyMagazines();
    }

    /**
     * Prints out a detailed view of all magazines from magazine register,
     * if register not empty. If empty, tells user. 
     */
    private void printAllMagazines()
    {
        if (!magazineRegister.isEmpty())
        {
            System.out.println("Printing all items in collection:");
            Iterator<Magazine> it = magazineRegister.iterator();
            while (it.hasNext())
            {
                printDetails(it.next());
            }
        }
        else
        {
            System.out.println("Magazine collection is empty.");
        }

    }

    /**
     * Add a new magazine to the magazine register if possible.
     * Asks user for input for and checks if input is valid.
     */
    private void addNewMagazine()
    {
        System.out.print("Please enter the title of the magazine: ");
        String title = getInputString();

        System.out.print("Please enter the publisher of the magazine: ");
        String publisher = getInputString();

        System.out.print("Please enter the genre of the magazine: ");
        String genre = getInputString();

        System.out.print("Please enter the number of publications of the magazine: ");
        String numPublications = getInputString();

        if (validStringInput(title) && validStringInput(publisher) &&
                validStringInput(genre) && validStringInput(numPublications)) 
        {
            if (!magazineRegister.addNewMagazine(title, publisher,
                    genre, numPublications))
            {
                System.out.println("\nCan't add duplicate title\n");
            }
            else
            {
                System.out.println("\nSuccessfully added magazine with title \""
                    + title + "\".");
                magazineRegister.addNewMagazine(title, publisher,
                    genre, numPublications);
            }
        }
        else
        {
            System.out.println("\nInput invalid. Try again");
        }
    }

    /**   UTVID
     * Checks if input string from user is valid.
     * Returns false if input is starts with '"'. 
     * @param input The input String to test
     * @return valid False if empty, true otherwise. 
     */
    private boolean validStringInput(String input) 
    {
        boolean valid = true;
        if (input.startsWith("\""))
        {
            valid = false;
        }
        return valid;
    }

    /**
     * Find and display a magazine based on title of magazine.
     * Asks user for title of magazine, checks input against magazine register.
     * If magazines with similar title is found, prints them. 
     */
    private void findMagazineByTitle()
    {
        //Ask user for input
        System.out.print("Please enter the title of the magazine: ");
        String title = getInputString();
        
        //Get a list with matching magazines
        ArrayList<Magazine> magazineList = magazineRegister.searchByTitle(title);

        //Check if ArrayList is not empty and prints all titles if not
        if (!magazineList.isEmpty())
        {
            System.out.println("\nFound the following magazines contaning title \"" + title + "\".\n");
            for (Magazine magazine : magazineList)
            {
                printDetails(magazine);
            }
        }
        else
        {
            System.out.println("\nCouldn't find any magazine with title \"" + title + "\".");
        } 
    }
    
    /**
     * Find and display a magazine based on publisher of magazine.
     * Asks user for publisher of magazine, checks input against magazine register.
     * If magazines with similar title is found, prints them. 
     */
    private void findMagazineByPublisher()
    {
        //Ask user for input
        System.out.print("Please enter the title of the magazine: ");
        String publisher = getInputString();

        //Get a list with matching magazines
        ArrayList<Magazine> magazineList = magazineRegister.searchByPublisher(publisher);

        //Check if ArrayList is not empty and prints all titles if not
        if (!magazineList.isEmpty())
        {
            System.out.println("\nFound the following magazines with publisher similar to \"" + publisher + "\".\n");
            for (Magazine magazine : magazineList)
            {
                printDetails(magazine);
            }
        }
        else
        {
            System.out.println("\nCouldn't find any magazine with publisher similar to \"" + publisher + "\".");
        }

    }

    /**
     * Finds and removes a magazine by searching for exact title.
     * Asks user for title of magazine, checks against magazine register if exact match.
     * Removes the magazine from magazine register if exact match. 
     */
    private void removeByTitle()
    {
        System.out.println("Please enter the exact case sensitive title of the magazine you want to remove: ");
        String title = getInputString();

        if (magazineRegister.removedByTitle(title))
        {
            System.out.println("\nRemoved the magazine the exact title \"" + title + "\".\n");
        }
        else
        {
            System.out.println("\nDid not find any magazine with exact title \"" + title + "\".\n");
        }   
    }

    /**
     * Prints all details of a magazine.
     * Prints out the title, publisher, genre and number of publications
     * of given magazine. 
     * 
     * @param magazine The magazine to print details from.
     */
    private void printDetails(Magazine magazine)
    {
        if (magazine != null)
        {
            System.out.print("Title: " + magazine.getTitle() + ", Publisher: " + magazine.getPublisher());
            System.out.print(", Genre: " + magazine.getGenre());
            System.out.println(", Num. of publications " + magazine.getNumbPublications());
        }
        else
        {
            System.out.println("No magazine found");
        }
    }

    /** 
     * Makes a new scanner object, takes a string input from user,closes the scanner object 
     * and then returns the string.
     * @return returnString the string from user input
     */
    private String getInputString()
    {
        Scanner reader = new Scanner(System.in);
        String returnString = reader.nextLine();
        reader.close();

        return returnString;
    }

    /**
     * Adds dummy items to magazine collection.
     * 
     * For testing purposes only.
     */
    private void addDummyMagazines()
    {
        magazineRegister.addNewMagazine("Se og Hør", "Aller Media", "Kjendis", "52");
        magazineRegister.addNewMagazine("Her og Nå", "Egmont", "Kjendis", "52");
        magazineRegister.addNewMagazine("Hytteliv", "Egmont", "Livsstil", "12");
        magazineRegister.addNewMagazine("KK", "Aller Media", "Livsstil", "12");
        magazineRegister.addNewMagazine("Vi Over 60", "Aller Media", "Livsstil", "12");
        magazineRegister.addNewMagazine("Spiderman", "Marvel", "Comics", "24");
        magazineRegister.addNewMagazine("Hawkeye", "Marvel", "Comics", "24");
    }

}
