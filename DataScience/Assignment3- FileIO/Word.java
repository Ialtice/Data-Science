
/**
 * Class for a word object that contains a string  and a integer value representing how many
 * times it has occured
 *
 * @author Isaac Altice
 * @version 06/21/2019
 */
public class Word<T> implements Comparable<T>
{
    private String aWord;// holds a word 
    private int count;// holds how many times the word occures
    /**
     * default constructor for Word obejct setting aWord to null and count to zero
     */
    public Word()
    {
        aWord = null;
        count = 0;
    }
    /**
     * overided constructor for Word object
     * 
     * @param String inWord - a word that will be assigned to aWord field and given an intial occurence value of 1
     */
    public Word(String inWord)
    {
        aWord = inWord;
        count = 1;
    }
    /**
     * overided constructor for Word object
     * Makes a deep copy of a word object
     * 
     * @param Word inWord - a word object that will be deep copied
     */
    public Word(Word inWord)
    {
        aWord = inWord.getaWord();
        count = inWord.getCount();
    }
    /**
     * toString method - displays the Word objects word field with its occurence count in parenthesis
     * 
     * @return String - the word field followed by the count field in parenthesis
     */
    public String toString()
    {
        return aWord + "(" + count + ")"; 
    }
    /**
     * compareTo method - compares two Word objects using their aWord field ignoring the case of the string and returning an integer value positive if this is greater,negative if inWord is 
     * greater and 0 if they are the same
     * 
     * @param T inWord - a element of generic type that will be cast to a Word object
     * 
     * @return a integer , positive if this aWord field > inWord aWord field, negative if this aWord field < inWord aWord field, 0 if this aWord field = inWord aWord field
     */
    public int compareTo(T inWord)
    {
        Word compWord =(Word) inWord;
        return this.aWord.compareToIgnoreCase(compWord.aWord);
    }
    /**
     * getaWord method - gets a word objects aWord field
     * 
     * @return - String aWord field of a Word
     */
    public String getaWord()
    {
        return aWord;
    }
    /**
     * getCount method - gets a Word objects count field
     * 
     * @return - integer count field of a Word
     */
    public int getCount()
    {
        return count;
    }
    /**
     * setCount method - takes in a integer value that will be assigned to a Word objects count field 
     * 
     * @param integer inCount - a integer value that the count field will be changed to 
     */
    public void setCount(int inCount)
    {
        count = inCount;
    }
}
