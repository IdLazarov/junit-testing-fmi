/**
 * 
 */
package fmi.test.providers;

import fmi.test.DB.IDBConnection;

/**
 * This class provides outcomes after log in.
 *
 */
public class LoginCheckProvider {

	private final IDBConnection connection;
	
	
	
	

    public LoginCheckProvider(final IDBConnection connection) {
        this.connection = connection;

    }

    private boolean hasConnection() {
        return "MySQL Connection".equals(connection.getConnectionName())
                || "H2 Connection".equals(connection.getConnectionName());
    }
    
    
    
    public static final String SUCCESS = "Your log in was successful";
    public static final String LOGIN_REQUEST = "Please log in first in order to use the forum";
    public static final String ERROR = "Something went wrong";
    
   
    
    /**
	 * Provide access based on the role.
	 * 
	 * @param role String representation of User Role
	 * @return Special outcomes after the log in(Success,Error,Log in request).
	 */
    public String checkLoginRights(final String role) {
    	
    	if(hasConnection()) {
    		if("User".equals(role) || "Admin".equals(role)) {
    			return SUCCESS;
    		}
    		else if("Guest".equals(role)){
    			return LOGIN_REQUEST;
    		}
    	}
    	
    	return ERROR;
    }
	
}
