/**
 * 
 */
package fmi.test.Tesingproject;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import fmi.test.DB.DB;
import fmi.test.providers.CommentAndTopicDeleteProvider;

/**
 * @author Pc
 *
 */
public class CommentAndTopicDeleteProviderTest {

private CommentAndTopicDeleteProvider commentAndTopicDeleteProvider;
	
	
	@Before
    public void setup() {
		commentAndTopicDeleteProvider = new CommentAndTopicDeleteProvider(new DB());
    }
	
	/**
	 * test {@link CommentAndTopicDeleteProvider#checkDeleteRights(String)} with User role. Expected unauthorized.
	 */
	@Test
	public void testCheckDleteRightsWithUserRole() {
		final String result = commentAndTopicDeleteProvider.checkDeleteRights("User");
		assertTrue(result.contains(CommentAndTopicDeleteProvider.UNAUTHORIZED));
	}
	
	/**
	 * test {@link CommentAndTopicDeleteProvider#checkDeleteRights(String)} with Admin role. Expected success.
	 */
	@Test
	public void testCheckDeleteRightsWithAdminRole() {
		final String result = commentAndTopicDeleteProvider.checkDeleteRights("Admin");
		assertTrue(result.contains(CommentAndTopicDeleteProvider.SUCCESS));
	}
	
	/**
	 * test {@link CommentAndTopicDeleteProvider#checkDeleteRights(String)} with Guest role. Expected error.
	 */
	@Test
	public void testCheckDeleteRightsWithGuestRole() {
		final String result = commentAndTopicDeleteProvider.checkDeleteRights("Guest");
		assertTrue(result.contains(CommentAndTopicDeleteProvider.ERROR));
	}
	

	/**
	 * test {@link CommentAndTopicDeleteProvider#checkDeleteRights(String)} with Empty role. Expected error.
	 */
	@Test
	public void testCheckDeleteRightsWithEmptyRole() {
		final String result = commentAndTopicDeleteProvider.checkDeleteRights("");
		assertTrue(result.contains(CommentAndTopicDeleteProvider.ERROR));
	}
	

	/**
	 * test {@link CommentAndTopicDeleteProvider#checkDeleteRights(String)} with {@code NULL}. Expected error.
	 */
	@Test
	public void testCheckDeleteRightsWithNullRole() {
		final String result = commentAndTopicDeleteProvider.checkDeleteRights(null);
		assertTrue(result.contains(CommentAndTopicDeleteProvider.ERROR));
	}
	
	
}
