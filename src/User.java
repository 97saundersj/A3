import java.util.ArrayList;

/**
 * stores a user’s​ profile, account details,​and​ ​favourite users.
 * @author 913613
 */
public class User //TODO: Create a way of unfavouriting users
{
    private String username;
    private String firstName;
    private Address address;
    private String profileImage;
    private ArrayList<User> favUsers;
    //ArrayList<AuctionItem> favItems;
    //ArrayList<Bid> bidHistory;
    //ArrayList<Auction> sellingHistory;

    /**
     * 
     * @param username the users username
     * @param firstName the users first name
     * @param address the users address
     * @param profileImage the file name of the users profile image
     * @param favUsers  A list of the users favourite users
     */
    public User(String username, String firstName, Address address, String profileImage, ArrayList<User> favUsers)
    {
        this.username = username;
        this.firstName = firstName;
        this.address = address;
        this.profileImage = profileImage;
        this.favUsers = favUsers;
    }
    
    /**
     * 
     * @param username the users username
     * @param firstName the users first name
     * @param address the users address
     * @param profileImage the file name of the users profile image
     */
    public User(String username, String firstName, Address address, String profileImage)
    {
        this.username = username;
        this.firstName = firstName;
        this.address = address;
        this.profileImage = profileImage;
        this.favUsers = new ArrayList<>();
    }
    
    /**
     * @return the username of the user
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * @param username the username of the user set
     */
    public void setUsername(String username)
    {
        this.username = username;
    }

    /**
     * @return the first name of the user
     */
    public String getFirstName()
    {
        return firstName;
    }

    /**
     * @param firstName the first Name of the user to set
     */
    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    /**
     * @return the address of the user
     */
    public Address getAddress()
    {
        return address;
    }

    /**
     * @param address the address of the user to set
     */
    public void setAddress(Address address)
    {
        this.address = address;
    }

    /**
     * @return the file name of the users profile image
     */
    public String getProfileImage()
    {
        return profileImage;
    }

    /**
     * @param profileImage the file name of the users profile image to set
     */
    public void setProfileImage(String profileImage)
    {
        this.profileImage = profileImage;
    }

    /**
     * @return A list of the users favourite users
     */
    public ArrayList<User> getFavUsers()
    {
        return favUsers;
    }

    /**
     * @param favUsers the list of favourite users to set
     */
    public void setFavUsers(ArrayList<User> favUsers)
    {
        this.favUsers = favUsers;
    }
    
    /**
     * Add a user to the list of favourite users
     * @param favUser A user that this user has favourited
     */
    public void AddFavUser(User favUser)
    {
        favUsers.add(favUser);
    }
    
    /**
     * removes a user from the list of favourite users
     * @param favUser A user that will be removed
     */
    public void removeFavUser(User favUser)
    {
        favUsers.remove(favUser);
    }
    
    /**
     * 
     * @param favUserUsername the username of one of the favourited users
     * @return the favourited user from the stored favourite users. Null if the users isn't a favourite
     */
    public User getFavUser(String favUserUsername)
    {
        User returnUser = FileReader.findUser(favUserUsername, favUsers);;
        
        return returnUser;//return null if the user isn't found
    }
    
    /**
     * 
     * @return details about the User class in string format
     */
    @Override
    public String toString()
    {
        String returnString = "Username:\t\t\t" + username + "\nFirst name:\t\t\t" + firstName
                + "\nAddress:\t\t\t" + address + "\nProfile image file name:\t" 
                + profileImage + "\n\n" + username +"'s Favourite users:";
        
        //print out the usernames of all favourited users
        for (User favUser : favUsers)
        {
            returnString += "\n-" + favUser.getUsername();
        }
        
        return returnString;
    }
}
