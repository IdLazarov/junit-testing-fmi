/**
 * 
 */
package fmi.test.Tesingproject;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fmi.test.DB.DB;
import fmi.test.providers.Comment;
import fmi.test.providers.CommentToOwnerVisibilityProvider;

/**
 * @author Pc
 *
 */
public class CommentToOwnerVisibilityProviderTest {

	
	private CommentToOwnerVisibilityProvider commentToOwnerVisibilityProvider;
	private Comment comment;
	
	@Before
    public void setup() {
		commentToOwnerVisibilityProvider = new CommentToOwnerVisibilityProvider(new DB(),comment);
    }
	
	/**
	 * test {@link CommentToOwnerVisibilityProvider#checkLoginRights(String)} with User role. Expected invisible.
	 */
	@Test
	public void testCheckVisibilityWithUserRole() {
		
		final Comment comment = new Comment();
		final String result = commentToOwnerVisibilityProvider.checkVisibilityRights("Sam,","John",comment);
		assertTrue(result.contains(CommentToOwnerVisibilityProvider.INVISIBLE));
	}
	
	/**
	 * test {@link CommentToOwnerVisibilityProvider#checkLoginRights(String)} with Owner role. Expected visible.
	 */
	@Test
	public void testCheckVisibilityWithOwnerRole() {
		final Comment comment = new Comment();
		final String result = commentToOwnerVisibilityProvider.checkVisibilityRights("Sam","Sam",comment);
		assertTrue(result.contains(CommentToOwnerVisibilityProvider.VISIBLE));
	}
	
	/**
	 * test {@link CommentToOwnerVisibilityProvider#checkLoginRights(String)} with Empty role. Expected invisible.
	 */
	@Test
	public void testCheckVisibilityWithEmptyRole() {
		final Comment comment = new Comment();
		final String result = commentToOwnerVisibilityProvider.checkVisibilityRights("","Frodo",comment);
		assertTrue(result.contains(CommentToOwnerVisibilityProvider.INVISIBLE));
	}
	
	/**
	 * test {@link CommentToOwnerVisibilityProvider#checkLoginRights(String)} with {@code NULL}. Expected invisible.
	 */
	@Test
	public void testCheckVisibilityWithNullRole() {
		final Comment comment = new Comment();
		final String result = commentToOwnerVisibilityProvider.checkVisibilityRights(null,"Bagins",comment);
		assertTrue(result.contains(CommentToOwnerVisibilityProvider.ERROR));
	}
}
