import java.util.*;
/**
 * Write a description of class Driver2 here.
 * 
 * @author Isaac Altice
 * @version v1
 */
public class ListDriver
{
    public static void main(String[ ] args)
    {
        LinkedOrderedList<String> myList = new LinkedOrderedList<String>();
        Iterator it;
        myList.add("zebra");
        myList.add("donkey");
        myList.add("elephant");
        myList.add("cat");
        myList.add("zoo");
        myList.add("dog");
        String item;
        it = myList.iterator( );
        System.out.println(myList + "\n\n");
        
        while(it.hasNext( ))
        {
           item = (String)(it.next( ));
           System.out.println(item.length( ));
        }
        
    }    
}
