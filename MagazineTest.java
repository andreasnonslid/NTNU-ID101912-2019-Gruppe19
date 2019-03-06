
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class MagazineRegisterTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class MagazineTest
{
    Magazine magazine1;
    /**
     * Default constructor for test class MagazineRegisterTest
     */
    public MagazineTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        magazine1 = new Magazine("Hei", "på", "deg", "4", 5);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testGetEdition()
    {
        assertEquals(5, magazine1.getEdition());
    }

    @Test
    public void testGetTitle()
    {
        assertEquals("Hei", magazine1.getEdition());
    }
    
    @Test
    public void testGetNumbPublications()
    {
        assertEquals("4", magazine1.getNumbPublications());
    }

    @Test
    public void testGetGenre()
    {
        assertEquals("deg", magazine1.getGenre());
    }
    
     @Test
    public void testGetPublisher()
    {
        assertEquals("på", magazine1.getPublisher());
    }
}

