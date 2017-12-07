import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Reads in the different files of the program
 */
public class FileReader
{
    //TODO: put somewhere else!!!!!!
    public static User findUser(String userName, ArrayList<User> list)
    {
        User returnUser = null;
        for (User u : list)
        {
            if(u.getUsername().equals(userName))
            {
                returnUser = u;
                return returnUser;
            }
        }
        return returnUser;
    }
    
    /**
     * Reads in the fileName file
     *
     * @param fileName the name of a file
     * @return a scanner containing the fileName file
     */
    public static Scanner readFile(String fileName)
    {
        File inputFile = new File(fileName);
        Scanner in = null;
        try
        {
            in = new Scanner(inputFile);
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open " + fileName);
            System.exit(0);
        }
        return in;
    }

    /**
     * @param userFile the location of the User file
     * @param favUserFile the location of the favourite User file
     * @return ArrayList of Users stored in the files
     */
    public static ArrayList<User> createUserList(String userFile, String favUserFile)
    { 
        ArrayList<User> list = createFavUsers(userFile, favUserFile);
        
        return list;
    }
    
    /**
     * Creates an arrayList full of Users form a file Each line of the file
     * needs to be in the format <Username> <First Name> <Profile Picture Name>
     * <Address Details>
     *
     * @param fileName the location of the file
     * @return ArrayList of Users created from the curLine details
     */
    private static ArrayList<User> createUsers(String fileName)
    {
        Scanner input = readFile(fileName);

        ArrayList<User> list = new ArrayList<>();

        while (input.hasNextLine())
        {
            User u = createUser(input.nextLine());
            list.add(u);
        }
        input.close();

        return list;
    }

    /**
     * Creates a User text needs to be in the format <Username> <First Name>
     * <Profile Picture Name> <Address Details>
     *
     * @param curLine A string which contains the Users details.
     * @return User created from the curLine details
     */
    private static User createUser(String curLine)
    {
        Scanner line = new Scanner(curLine);

        //create a user
        String userName = line.next();
        String fName = line.next();
        String picName = line.next();

        Address address = createAddress(line.nextLine());

        line.close();

        User u = new User(userName, fName, address, picName);

        return u;
    }

    /**
     * Creates an address text needs to be in the format <Address line 1>
     * <City/Town> <Postcode> <Address line 2>
     *
     * @param curLine A string which contains the Address details.
     * @return Address created from the curLine details
     */
    private static Address createAddress(String curLine)
    {
        Scanner line = new Scanner(curLine);

        String addressLine1 = line.next();
        String townOrCity = line.next();
        String postcode = line.next();
        String addressLine2 = line.next();

        line.close();
        Address a = new Address(addressLine1, addressLine2, townOrCity, postcode);

        return a;
    }
    
    /**
     * Creates an arrayList of users that is filled with the correct favourite users
     * the favourite users file needs to be in the format 
     * <Username> <Favourited User 1> <Favourited User 2> ... <Favourited User n>
     *
     * @param curLine A string which contains the Address details.
     * @return Address created from the curLine details
     */
    
    /**
     * Creates an arrayList of users that is filled with the correct favourite users
     * the favourite users file needs to be in the format 
     * <Username> <Favourited User 1> <Favourited User 2> ... <Favourited User n>
     * @param fileName
     * @param usersFileName
     * @return arrayList of users with the correct favourite users
     */
    private static ArrayList<User> createFavUsers(String usersFileName, String favUsersFileName)
    {
        ArrayList<User> userList = createUsers(usersFileName);
        
        Scanner input = readFile(favUsersFileName);

        while (input.hasNextLine())
        {
            User updatedUser = createFavUser(input.nextLine(),userList);
            
            //Delete the outdated User stored
            User outdatedUser = findUser(updatedUser.getUsername(), userList);
            userList.remove(outdatedUser);
            
            //add the updated User
            userList.add(updatedUser);
        }
        input.close();

        return userList;
    }
 
    /**
     * Creates a users with the correct list of favourite users
     * the curLine needs to be in the format 
     * <Username> <Favourited User 1> <Favourited User 2> ... <Favourited User n>
     * @param curLine the string that contains details about the users favourited users
     * @param userList A list of all the users on the system
     * @return 
     */
    private static User createFavUser(String curLine, ArrayList<User> userList)
    {
        Scanner line = new Scanner(curLine);
        
        //The user that the favourited list will be created for
        String selectedUsername = line.next();
        
        User selectedUser = findUser(selectedUsername, userList);
        
        while (line.hasNext())
        {
            String favUsername = line.next();
            User favUser = findUser(favUsername, userList);
            
            //Add the favourite user to the selected Users favourite list
            selectedUser.AddFavUser(favUser);
        }

        line.close();

        return selectedUser;
    }
}
