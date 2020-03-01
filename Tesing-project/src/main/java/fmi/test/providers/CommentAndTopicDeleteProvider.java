/**
 * 
 */
package fmi.test.providers;

import fmi.test.DB.IDBConnection;

/**
 * @author Pc
 *
 */
public class CommentAndTopicDeleteProvider {

private final IDBConnection connection;
	
	
	
	

    public CommentAndTopicDeleteProvider(final IDBConnection connection) {
        this.connection = connection;

    }

    private boolean hasConnection() {
        return "MySQL Connection".equals(connection.getConnectionName())
                || "H2 Connection".equals(connection.getConnectionName());
    }
    
    
    
    public static final String SUCCESS = "Delete successful";
    public static final String UNAUTHORIZED = "No rights granted";
    public static final String ERROR = "Something went wrong";
    
   
    
    /**
	 * Provide access based on the role.
	 * 
	 * @param role String representation of User Role
	 * @return Special outcomes after the log in(Success,Error,Log in request).
	 */
    public String checkDeleteRights(final String role) {
    	
    	if(hasConnection()) {
    		if("Admin".equals(role)) {
    			return SUCCESS;
    		}
    		else if("User".equals(role)){
    			return UNAUTHORIZED;
    		}
    	}
    	
    	return ERROR;
    }
	
}
