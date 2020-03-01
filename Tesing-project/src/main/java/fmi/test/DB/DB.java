/**
 * 
 */
package fmi.test.DB;

/**
 * @author Pc
 *
 */
public class DB implements IDBConnection{
	
	public String getConnectionName() {
		return "MySQL Connection";
	}
	
	public String getDBName() {
		return "TEST DATABASE";
	}

}
