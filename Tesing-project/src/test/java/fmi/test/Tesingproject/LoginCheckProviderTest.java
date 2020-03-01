/**
 * 
 */
package fmi.test.Tesingproject;

import static org.junit.Assert.assertTrue;


import org.junit.Before;
import org.junit.Test;

import fmi.test.DB.DB;
import fmi.test.providers.LoginCheckProvider;
 

/**
 * @author Pc
 *
 */
public class LoginCheckProviderTest {
	
	
	private LoginCheckProvider loginCheckProvider;
	
	
	@Before
    public void setup() {
		loginCheckProvider = new LoginCheckProvider(new DB());
    }
	
	/**
	 * test {@link LoginCheckProvider#checkLoginRights(String)} with User role. Expected success.
	 */
	@Test
	public void testCheckLoginWithUserRole() {
		final String result = loginCheckProvider.checkLoginRights("User");
		assertTrue(result.contains(LoginCheckProvider.SUCCESS));
	}
	
	/**
	 * test {@link LoginCheckProvider#checkLoginRights(String)} with Admin role. Expected success.
	 */
	@Test
	public void testCheckLoginWithAdminRole() {
		final String result = loginCheckProvider.checkLoginRights("Admin");
		assertTrue(result.contains(LoginCheckProvider.SUCCESS));
	}
	
	/**
	 * test {@link LoginCheckProvider#checkLoginRights(String)} with {@code NULL} role. Expected error.
	 */
	@Test
	public void testCheckLoginWithNullRole() {
		final String result = loginCheckProvider.checkLoginRights(null);
		assertTrue(result.contains(LoginCheckProvider.ERROR));
	}

	/**
	 * test {@link LoginCheckProvider#checkLoginRights(String)} with Guest role. Expected login request.
	 */
	@Test
	public void testCheckLoginWithGuestRole() {
		final String result = loginCheckProvider.checkLoginRights("Guest");
		assertTrue(result.contains(LoginCheckProvider.LOGIN_REQUEST));
	}
	/**
	 * test {@link LoginCheckProvider#checkLoginRights(String)} with Empty role. Expected error.
	 */
	@Test
	public void testCheckLoginWithEmptyRole() {
		final String result = loginCheckProvider.checkLoginRights("");
		assertTrue(result.contains(LoginCheckProvider.ERROR));
	}
	
	
}


