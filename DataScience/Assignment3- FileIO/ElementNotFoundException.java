/**
 * Exception class to throw when an element is not found
 * 
 * Extends RuntimeException
 * 
 * @author Isaac Altice
 * @version 1
 */
public class ElementNotFoundException extends RuntimeException
{
	
	public ElementNotFoundException(String msg)
	{
		System.out.print(msg);
	}

 }