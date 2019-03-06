/**
 * Represents a magazine. The role of a magazine object is to hold
 * information to uniquly describe magazines. 
 * A magazine is described by the following fields:
 * <ul>
 *  <li>a title</li>
 *  <li>publisher</li>
 *  <li>genre</li>
 *  <li>Number of publications</li>
 * </ul>
 *  
 * @author Martin Håhjem Årdal
 * @version 09.02.2019
 */
public class Magazine
{
    private String title;
    private String publisher;
    private String genre;
    private String numPublications;
    private int edition;

    /**
     * Constructor for objects of class Magazine
     * @param title The title of the magazine.
     * @param publisher The publisher of the magazine.
     * @param genre The genre of the magazine.
     * @param edition The edition of the magazine.
     * @param numPublications The number of publications over a year.
     */
    public Magazine(String title, String publisher, String genre,
    String numPublications, int edition)
    {
        this.title = title.trim();
        this.publisher = publisher.trim();
        this.genre = genre.trim();
        this.numPublications = numPublications.trim();
        this.edition = edition;
    }

    /**
     * getTitle retrives a magazine's title.
     * 
     * @return title Returns string in title field.
     */
    public String getTitle()
    {
        return this.title;
    }

    /**
     * getPublisher retrives a magazine's publisher.
     *
     * @return publisher Returns string in publisher field.
     */
    public String getPublisher()
    {
        return this.publisher;
    }

    /**
     * getGenre retrives a magazine's genre.
     *
     * @return genre Returns string in genre field.
     */
    public String getGenre()
    {
        return this.genre;
    }

    /**
     * getNumPublications retrives a magazine's number of publications.
     *
     * @return numPublications Returns string in numPublications field.
     */
    public String getNumbPublications()
    {
        return this.numPublications;
    }
    
    /**
     * getEdition retrives a magazine's edition.
     *
     * @return edition Returns int in edition field.
     */
    public int getEdition()
    {
        return edition;
    }
}
