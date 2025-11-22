import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  mik
 * @version 0.1
 */
public class SalesItemTest
{
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
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

    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        assertEquals(false, salesIte1.addComment("Joshua Black", "Not worth the money. The font is too small.", -5));
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesIte1 = new SalesItem("test name", 1000);
        assertEquals("test name", salesIte1.getName());
        assertEquals(1000, salesIte1.getPrice());
    }
    @Test
    public void testFindMostHelpfulCommentReturnsHighestVoted()
    {
        SalesItem item = new SalesItem("Laptop", 99999);
        item.addComment("Alice", "Good product", 5);
        item.addComment("Bob", "Great item", 4);
        item.addComment("Charlie", "Excellent", 5);
    
        item.upvoteComment(1); 
        item.upvoteComment(1); 
        item.upvoteComment(0); 
    
        Comment mostHelpful = item.findMostHelpfulComment();
    
        assertNotNull(mostHelpful);
        assertEquals("Bob", mostHelpful.getAuthor());
        assertEquals(2, mostHelpful.getVoteCount());
    }

    @Test
    public void testFindMostHelpfulCommentWithNegativeVotes()
    {
        SalesItem item = new SalesItem("Phone", 50000);
        item.addComment("Alice", "Bad product", 1);
        item.addComment("Bob", "Terrible", 2);
    
        item.downvoteComment(0);
        item.downvoteComment(0);
        item.downvoteComment(0);
        item.downvoteComment(1);
    
        Comment mostHelpful = item.findMostHelpfulComment();
    
        assertNotNull(mostHelpful);
        assertEquals("Bob", mostHelpful.getAuthor());
        assertEquals(-1, mostHelpful.getVoteCount());
    } 
    @Test
    public void testAddCommentWithAllValidRatings()
    {
        SalesItem item = new SalesItem("Tablet", 30000);
        assertTrue(item.addComment("User1", "Rating 1", 1));
        assertTrue(item.addComment("User2", "Rating 5", 5));
        assertEquals(2, item.getNumberOfComments());
        }

    @Test
    public void testRemoveComment()
    {
        SalesItem item = new SalesItem("Mouse", 2500);
        item.addComment("Alice", "Good", 4);
        item.addComment("Bob", "Great", 5);
        item.removeComment(0);
        assertEquals(1, item.getNumberOfComments());
    }

    @Test
    public void testInvalidIndexDoesNotCrash()
    {
        SalesItem item = new SalesItem("Keyboard", 5000);
        item.addComment("Alice", "Good", 4);
        item.removeComment(-1);
        item.upvoteComment(10);
        assertEquals(1, item.getNumberOfComments());
    }
}
