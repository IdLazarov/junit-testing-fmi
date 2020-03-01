/**
 * 
 */
package fmi.test.providers;

import fmi.test.DB.IDBConnection;

/**
 * @author Class for connection between user and his own comments
 *
 */
public class CommentToOwnerVisibilityProvider {

	private final IDBConnection connection;
	private final Comment comment;
	
	
	

    public CommentToOwnerVisibilityProvider(final IDBConnection connection,final Comment comment) {
        this.connection = connection;
        this.comment = comment; 

    }

    private boolean hasConnection() {
        return "MySQL Connection".equals(connection.getConnectionName())
                || "H2 Connection".equals(connection.getConnectionName());
    }
    
    
    
    public static final String VISIBLE = "Look at all your hateful comments";
    public static final String INVISIBLE = "You shall not SEE";
    public static final String ERROR = "Something went wrong";

    
   
    
    /**
	 * Provide visibility based on the ownership of the comment.
	 * 
	 * @param user and owner Strings representation of the comparison if the user is the owner of the comment
	 * 
	 * @return Special outcomes after the log in(Visible,Error,Invisible).
	 */
    public String checkVisibilityRights(final String user,final String owner,final Comment comment) {
    	
    	if(hasConnection()) {
    		comment.setOwner(owner);
    		if(owner != null && user != null) {
    			
    			if(user.equals(owner) && !("".equals(user)) ) {
    				return VISIBLE;
    			}   			
    			return INVISIBLE;
    		} 		
    	}
    	return ERROR;
    }
	
}
