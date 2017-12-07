
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Saves the different files of the program
 */
public class FileWriter
{

    /**
     * Creates a new prinWriter to write to the fileName file
     *
     * @param fileName the name of a file
     * @return a PrintWriter containing the fileName file
     */
    public static PrintWriter writeFile(String fileName)
    {
        File outputFile = new File(fileName);
        PrintWriter out = null;
        try
        {
            out = new PrintWriter(outputFile);
        } catch (FileNotFoundException e)
        {
            System.out.println("Cannot open " + fileName);
            System.exit(0);
        }
        return out;
    }

    /**
     * Updates a file to contain a list of users
     * @param list the arrayList of Users that will be saved to the fileName file
     * @param fileName the file that the Users will be saved too
     */
    public static void updateUsers(ArrayList<User> list, String fileName)
    {
        Scanner input = FileReader.readFile(fileName);
        String fileString = "";

        for (User u : list)
        {
            
            //add Users details to string in the correct format
            fileString += u.getUsername() + " ";
            fileString += u.getFirstName() + " ";
            fileString += u.getProfileImage() + " ";

            //Address
            fileString += u.getAddress().getAddressLine1() + " ";
            fileString += u.getAddress().getTownOrCity() + " ";
            fileString += u.getAddress().getPostCode() + " ";
            fileString += u.getAddress().getAddressLine2() + "\r\n";
        }

        //Write to file
        PrintWriter out = writeFile(fileName);

        out.print(fileString);

        out.close();
    }
    
    /**
     * Saves changes made to the FavUsers file
     * @param list the arrayList of all Users on the system
     * @param favUsersFileName the location of the file that the changes will be saved too
     */
    public static void updateFavouriteUsers(ArrayList<User> list, String favUsersFileName)
    {
        String fileString = "";

        for (User curUser : list)
        {
            
            fileString += curUser.getUsername();
            //add favourited Users usernames in the correct format
            for(User favUser : curUser.getFavUsers())
            {
                fileString += " " + favUser.getUsername();
            }
            
            fileString += "\r\n";
        }

        //Write to file
        PrintWriter out = writeFile(favUsersFileName);

        out.print(fileString);

        out.close();
    }
}
