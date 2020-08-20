
/**
 * Write a description of class ArrayFunctions here.
 *
 * @author (Isaac Altice)
 * @version (05/20/2019)
 */
public class ArrayFunctions implements ArrayFunctionsInterface
{
    public double [] sortMe(double [] array)
    {
        boolean needNextPass = true;
        for (int k =1; k< array.length && needNextPass;k++)
        {
            for(int i=0; i<array.length;i++)
            {
                if(array[k] > array[k+1])
                {
                    double temp = array[k];
                    array[k] = array[k+1];
                    array[k+1] = temp;
                    needNextPass = true;
                }
            }
        }
        return array;
    }
    public double getMax(double [] array)
    {
        double max = array[0];
        for(int i=1; i<array.length;i++)
        {
            if (array[i] > max)
                max = array[i]; 
            }
        return max;
    }
    public double getMin(double [] array)
    {
        double min = array[0];
        for(int i=1; i<array.length;i++)
        {
            if (array[i] < min)
                min = array[i]; 
            }
        return min;
    }
    public double[ ] doubleMySize(double [ ] array)
    {
        int size = array.length;
        double newArray [] = new double[size * 2];
        for(int i=0; i<array.length;i++)
        {
            double temp = array[i];
            newArray[i] = temp;
            
        }
        return newArray;
    }
    public int whereAmI(double [ ] array, double  searchValue)
    {
        int index = -1;
        for(int i = 0;i< array.length;i++)
        {
            if(searchValue == array[i])
                index = i;
        }
        return index;
    }
    public double [ ] reverseMe(double [ ] array)
    {
        int beginning = 0;
        int end = array.length;
        double temp;
        while (beginning != end)
        {
            temp = array[beginning];
            array[beginning] = array[end];
            array[end] = temp;
            beginning++;
            end--;
        }
        return array;
    }
    public double sumMeUp(double [ ] array)
    {
        double sum =0;
        for(int i = 0; i<array.length;i++)
            sum += array[i];
        return sum;
    }
    public void printMe(double [ ] array)
    {
        for(int i = 0; i<array.length;i++)
        {
            for(int j = 0; j<5;j++)
                System.out.print(array[i] + " ");
            System.out.println();
        }
    }
}
