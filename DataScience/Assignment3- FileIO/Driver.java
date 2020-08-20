import java.io.*;
import java.util.*;
/**
 * A program driver that will ask the user to enter the name of a text file they wish to perform operations
 *
 * @author Isaac Altice
 * @version (06/21/2019
 */
public class Driver
{
    public static void main(String args[]) throws IOException
    {
        
        
        LinkedBinarySearchTree<Word> tree = new LinkedBinarySearchTree<Word>(); // tree holds a Linked binary tree of Word objects
        ArrayUnorderedList<Word> list = new ArrayUnorderedList<Word>();// list holds a unordered array list of Word Objects
        Word word; // Word object variable
        Word target;// variable to hold Word objects that the user is searching for for
        Word temp;// variable to hold temp word objects
        File file;//declares file
        Scanner in = new Scanner(System.in);// scanner to get user inputs
        int choice;// variable for menu choices
        int orderChoice;// variable for traversal menu
        int count;// variable holds counts
        Iterator<Word> iterator;// iterator for Word objects to move from list to tree
        
        System.out.println("Enter the file name, without extention, you wish to analyze: ");// ask user
        file = new File("C:\\Users\\isaac\\Downloads\\" + in.next() + ".txt");// inializes file to whatever the user enters plus .txt
        Scanner inFile = new Scanner(file);//declare and initialize scanner to get data from text file
        while(inFile.hasNextLine())// loop to go through every line of text file
        {
            StringTokenizer st = new StringTokenizer(inFile.next()," ");//tokenizer st splits apart each line of text in file into correct parameters for new words in the list
            while(st.hasMoreTokens())//loop through st tokens using them as parameters for new customer objects
            {
                list.addToRear(new Word(st.nextToken().toLowerCase()));//changes token to all lower case and adds to the end of list
                
            }
        }
        iterator =  list.iterator();// iterator to go through list of word objects
        while(iterator.hasNext())//contines til null value is found in list
        {
            temp = new Word(iterator.next());// copies word object to temp
            if(!tree.isEmpty() && tree.contains(temp))// if tree is not empty and the word is already in the tree increase that word objects count
            {
                temp = tree.find(temp);
                temp.setCount(temp.getCount() + 1);
            }
            else// add the word object to the tree
                tree.addElement(temp);
        }
        
        do//perform operations on tree unil user decides to quit, enter a zero
        {
            in = new Scanner(System.in);//scanner to get user menu choice
            menu();//display menu
            System.out.println("Enter the number for your menu choice: ");//ask user for menu choice
            choice = in.nextInt();//get choice from user
            switch(choice)//perform correct operation 
            {
                case 1:// if user enters 1 search tree for word and if found display how many occurences, if not tell user not found
                    in = new Scanner(System.in);//scanner to get word to search for
                    System.out.println("Enter the word you want to search for: ");//ask user for word
                    target = new Word(in.nextLine());//creates word object to search tree for with the String word in the aWord field
                    if(tree.contains(target))// if tree contains a Word object with the same aWord field
                    {
                        System.out.println("Word: " + target.getaWord());//displays aWord field searched for
                        System.out.println("Occurences: " + tree.find(target).getCount());//displays the count field to the user as occurences
                    }
                    else// if tree does not contain word searched for
                    {
                        System.out.println("Word: " + target.getaWord());//displays aWord field searched for
                        System.out.println("Word is not in the tree");//display word not found to user
                    }
                    break;
                case 2://if user enters 2 ask user for word to delete then delete an occurence of and display updates
                    in = new Scanner(System.in);//scanner to get word to search for
                    System.out.println("Enter the word you want to delete a occurence of: ");//ask the user what word he wants to delete a occurence of 
                    target = new Word(in.nextLine());//makes Word Object to search for
                    
                    if(tree.contains(target))// if tree contains a word object that has the same aWord field has target
                    {
                        temp = tree.find(target);// searches tree for target and sets target to temp
                        System.out.println("Word: " + temp.getaWord());// displays word to user that will be deleted
                        temp.setCount(temp.getCount() - 1);// deletes one occurence of this word
                        System.out.println("Occurences: " + temp.getCount());//shows user updated count
                        if(temp.getCount() == 0)// if the count reaches zero remove the word from the tree
                        {
                            System.out.println("Word removed from tree");//display a message to user that word was removed from tree
                            tree.removeElement(temp);//remove the element from the tree
                            
                        }
                            
                    }
                    else//if word is not in tree
                    {
                        System.out.println("Word is not in the tree");//display to user word not found in tree
                    }
                    break;
                case 3:// if user enters 3 ask for a type of traversal then display the tree in that traversal
                    in = new Scanner(System.in);//scanner to get user menu choice
                    orderMenu();
                    System.out.println("Enter the number for the traversal you want from the Menu above: ");
                    orderChoice = in.nextInt();//ask user for menu choice then save to orderchoice
                    switch(orderChoice)// use user input for orderchoice to perform different traversals
                    {
                        case 1:// if user enters zero print a preorder traversal
                            System.out.println("Pre-order:");//display traversal
                            String treePreOrder = "";// holds string that gets updated as the iterator traverses
                            iterator = tree.iteratorPreOrder();//preorder traversal for tree
                            count = 0;// makes sure line displayed isnt too long
                            
                            while (iterator.hasNext()) //loop til iterator goes through entire tree
                            {
                            count++;// how many words in the current string line
                        if( (count % 10) != 0)// updates string with word values with a max of 10 words per line
                            treePreOrder += iterator.next()+ ", ";
                        else 
                            treePreOrder += iterator.next() + "\n";
                            }
                            System.out.println(treePreOrder);//display tree traversal to user
                        break;
                        case 2:// if user enter 2 display the tree in post order traversal
                            System.out.println("Post-order:");//display what traversal
                            String treePostorder = "";//holds current traversal 
                            iterator = tree.iteratorPostOrder();//iterates thorugh tree in post order
                            count = 0;// how many words in line currently/ elements traversed
                        
                            while (iterator.hasNext()) // iterates through tree updating the string to be displayed to user and if line contains more than 10 words move to next line
                            {
                                count++;
                            if( (count % 10) != 0)
                                treePostorder += iterator.next() + ", ";
                            else 
                                treePostorder += iterator.next() + "\n";
                            }
                            System.out.println(treePostorder);// display traversal to user
                        break;
                        case 3://if user enter 3 display tree in in order traversal
                            System.out.println("In-order:");//display what traversal
                            String treeInorder = "";//holds current words traversed in a string
                            iterator = tree.iteratorInOrder();// iterator for tree in order traversal 
                            count = 0;// how many elements put into string
                        
                            while (iterator.hasNext()) // iterates through tree updating the string to be displayed to user and if line contains more than 10 words move to next line
                            {
                                count++;
                            if( (count % 10) != 0)
                                treeInorder += iterator.next() + ", ";
                            else 
                                treeInorder += iterator.next() + "\n";
                            }
                            System.out.println(treeInorder);
                        break;
                        case 4:
                            System.out.println("Level-order:");//display what traversal
                            String treeLevelorder = "";//holds current words traversed in a string
                            iterator = tree.iteratorLevelOrder();//iterator for tree level order traversal
                            count = 0;//how many elements put in string
                        
                            while (iterator.hasNext()) // iterates through tree updating the string to be displayed to user and if line contains more than 10 words move to next line
                            {
                                count++;
                            if( (count % 10) != 0)
                                treeLevelorder += iterator.next() + ", ";
                            else 
                                treeLevelorder += iterator.next() + "\n";
                            }
                            System.out.println(treeLevelorder);
                        break;
                        default://display invalid menu choice if user enters a number not listed
                        System.out.println("Invalid menu choice");
                    }
                    
                    break;
                case 4:// if user enters a 4 for menu choice ask the user for a type of traversal you want the tree to be printed to a data file in
                    PrintWriter newTree = new PrintWriter("C:\\Users\\isaac\\Downloads\\outwords.txt");//declares and initializes printwriter for file outword.txt
                    in = new Scanner(System.in);//scaneer to get user traversal choice
                    orderMenu();//display order menu
                    System.out.println("Enter the number for the traversal you want from the Menu above: ");//ask and get user choice for traversal and set to orderchoice
                    orderChoice = in.nextInt();
                    switch(orderChoice)// chooses the correct traversal, displays to user and creates tree iterator. 
                    {
                        case 1://user enters 1 display preorder and create preorder iterator
                            System.out.println("Pre-order:");
                            iterator = tree.iteratorPreOrder();
                        break;
                        case 2://user enters 2 display postorder and create postorder iterator
                            System.out.println("Post-order:");
                            iterator = tree.iteratorPostOrder();
                        break;
                        case 3://user enters 3 display inorder and create pinorder iterator
                            System.out.println("In-order:");
                            iterator = tree.iteratorInOrder();
                        break;
                        case 4://user enters 4 display level order and create level order iterator
                            System.out.println("Level-order:");
                            iterator = tree.iteratorLevelOrder();
                    }
                    while(iterator.hasNext())//loop until all words are printed to file 
                    {
                        temp = iterator.next();
                        newTree.print(temp.toString() + " ");
                    }
                    newTree.close();//close print writer
                    System.out.println("Tree traversal has been saved to file outwords.txt");//display to user file has been made and saved
                    break;
                case 0:// displays goodbye and exits program
                    System.out.println("Goodbye");
                    break;
                default://if user enters a number not on menu display message
                    System.out.println("Invalid Menu Option");
                
            }
        }while(choice != 0);
    }
    /**
     * menu method displays menu options for operations a user can perform on a binary tree
     */
    public static void menu()
    {
        System.out.println("====================================================================\n");
        System.out.println("Menu");
        System.out.println("1. Find number of occurences of a word");
        System.out.println("2. Delete a occurence of a word");
        System.out.println("3. Print all words and their number of occurences");
        System.out.println("4. Save to file");
        System.out.println("0. Quit");
        System.out.println("====================================================================\n");
        
    }
    /**
     * orderMenu method displays menu options for type of traversal to the user for printing the tree
     */
    public static void orderMenu()
    {
        System.out.println("====================================================================\n");
        System.out.println("Tree traversal options:");
        System.out.println("1. Preorder");
        System.out.println("2. Inorder");
        System.out.println("3. Postorder");
        System.out.println("4. Levelorder");
        System.out.println("====================================================================\n");
    }
}
