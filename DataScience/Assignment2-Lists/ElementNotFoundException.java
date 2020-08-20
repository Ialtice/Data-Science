
/**
 * ElementNotFoundException represents the situation in which a target element 
 * is not present in a collection
 *
 * @author Isaac Altice
 * @version 4.0
 */
public class ElementNotFoundException extends RuntimeException
{
    /**
     * Sets up this exception with an appropriate message.
     */
    public ElementNotFoundException (String msg)
    {
	    super (msg);
    }
}
