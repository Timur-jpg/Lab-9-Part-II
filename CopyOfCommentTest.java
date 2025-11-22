

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class CopyOfCommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CopyOfCommentTest
{
    /**
     * Default constructor for test class CopyOfCommentTest
     */
    public CopyOfCommentTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void testAuthorAndRatingStoredCorrectly()
    {
        Comment comment = new Comment("Alice", "Great product!", 5);
        assertEquals("Alice", comment.getAuthor());
        assertEquals(5, comment.getRating());
    }
    
    @Test
    public void testUpvoteIncreasesVoteCount()
    {
        Comment comment = new Comment("Bob", "Nice item", 4);
        assertEquals(0, comment.getVoteCount());
        comment.upvote();
        assertEquals(1, comment.getVoteCount());
    }
    
    @Test
    public void testDownvoteDecreasesVoteCount()
    {
        Comment comment = new Comment("Charlie", "Not bad", 3);
        assertEquals(0, comment.getVoteCount());
        comment.downvote();
        assertEquals(-1, comment.getVoteCount());
    }
}
