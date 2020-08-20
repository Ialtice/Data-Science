/**
 * This interface specifies several
 * methods for operations on an array of double
 * (or int) values.
 * 
 * An interface in Java 8 is made up of method headings only.
 * These are abstract methods. The interface is abstract as well but
 * because the Java compiler already "knows" this, you do not use the
 * keyword abstract in the class heading.
 * 
 * If there are any fields specified, they must be public, static, and 
 * final.
 * Because an interface is abstract, an interface cannot be instantiated.
 * 
 * An interface is used for design purposes and for allowing classes to be considered
 * various types. In Java, you can only inherit from one superclass.
 * 
 * What a programmer does is implement an interface.
 * 
 * @author Isaac Altice
 * @version 05/20/2019
 */



public interface ArrayFunctionsInterface
{
     double [ ] sortMe(double [ ] array);
     double  getMax(double [ ] array);
     double  getMin(double [ ]  array);
     int whereAmI(double [ ] array, double  searchValue);
     double sumMeUp(double [ ] array);
     double [ ] reverseMe(double [ ] array);
     void printMe(double [ ] array);
     double[ ] doubleMySize(double [ ] array);
}
