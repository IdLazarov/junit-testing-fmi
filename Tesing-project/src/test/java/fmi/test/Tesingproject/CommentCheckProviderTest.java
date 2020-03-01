/**
 * 
 */
package fmi.test.Tesingproject;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fmi.test.DB.DB;
import fmi.test.providers.CommentCheckProvider;



/**
 * @author Pc
 *
 */
public class CommentCheckProviderTest {

	
	private CommentCheckProvider commentCheckProvider;
	
	
	@Before
    public void setup() {
		commentCheckProvider = new CommentCheckProvider(new DB());
    }
	/**
	 * test {@link CommentCheckProvider#checkCommentContent(String)} with  {@code NULL}. Expected error.
	 */
	@Test
	public void testCheckCommentWithNullContent() {
		final String result = commentCheckProvider.checkCommentContent(null);
		assertTrue(result.contains(CommentCheckProvider.ERROR));
	}
	/**
	 * test {@link CommentCheckProvider#checkCommentContent(String)} with Empty string. Expected error.
	 */
	@Test
	public void testCheckCommentWithEmptyContent() {
		final String result = commentCheckProvider.checkCommentContent("");
		assertTrue(result.contains(CommentCheckProvider.ERROR));
	}
	/**
	 * test {@link CommentCheckProvider#checkCommentContent(String)} with Random string. Expected success.
	 */
	@Test
	public void testCheckCommentWithRandomContent() {
		final String result = commentCheckProvider.checkCommentContent("Hello World");
		assertTrue(result.contains(CommentCheckProvider.SUCCESS));
	}
}



