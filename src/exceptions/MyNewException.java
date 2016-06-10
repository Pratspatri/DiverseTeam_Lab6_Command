/**
 *  Name:Malak Bassam
 *  Course:CSC 561
 *  Instructor: Dr. Girard
 */
package exceptions;
public class MyNewException extends Exception
{

	/**
	 * Use this class to throw exception if constructor 
	 * in Alien class has negative number for recovery rate
	 */
	private static final long serialVersionUID = 6833187190821287594L;
	
public MyNewException(String m)
{

	System.out.println(m);

}
}
