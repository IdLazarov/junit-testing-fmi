/**
 * 
 */
package fmi.test.providers;

import fmi.test.DB.IDBConnection;

/**
 * This class provides comment content
 *
 */
public class CommentCheckProvider {

	private final IDBConnection connection;

	public CommentCheckProvider(final IDBConnection connection) {
		this.connection = connection;

	}

	private boolean hasConnection() {
		return "MySQL Connection".equals(connection.getConnectionName())
				|| "H2 Connection".equals(connection.getConnectionName());
	}

	public static final String SUCCESS = "Your comment was successfully submitted";
	public static final String ERROR = "Please insert text before submitting";

	/**
	 * Provide outcome based on the content of the comment.
	 * 
	 * @param comment String representation of comment content
	 * @return Special outcomes after the comment(Success,Error).
	 */
    public String checkCommentContent(final String comment) {
    	
    	if(hasConnection()) {
    		if(comment != null) {
    			if(!comment.equals("")) {
        			return SUCCESS;
        		}
    		}
    		
    	}
    	
    	return ERROR;
    }

}
