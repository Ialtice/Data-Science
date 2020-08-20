
/**
 * This code is to help you to use a generic type
 * when creating your LinearNode that is put in
 * the List.
 * 
 * @author Isaac Altice
 * @version v1
 */
public class LinearNode<T>
{
	/* Variables and Objects */
    private T element;
    private LinearNode<T> next;
	
	/**
	 * Constructor - Sets element to the data and sets next to null
	 * @param T - the data to put into the node
	 */
	public LinearNode(T data)
	{
	    element = data;
	    next = null;
	}
	
	/**
	 * Sets the next node in the line
	 * @param LinearNode<T> - the node to set next to
	 */
	public void setNext(LinearNode<T> ln)
	{
	    next = ln;
	}
	
	/**
	 * Gets the next linear node in the line
	 * @return LinearNode<T> - the node that is in next
	 */
	public LinearNode<T> getNext( )
	{
	    return next;
	}
	
	/**
	 * Returns the element in the node
	 * @return T - element in the node
	 */
	public T getElement()
	{
	    return element;
	}
	
	/**
	 * Sets the element to the incoming element
	 * @param T - the element to put into the node
	 */
	public void setElement(T data)
	{
	    element = data;
	}    
}
