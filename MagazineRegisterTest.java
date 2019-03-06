
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
public class MagazineRegisterTest
{
    Magazine magazine1;
    /**
     * Default constructor for test class MagazineRegisterTest
     */
    public MagazineRegisterTest()
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

 
}

