import java.util.ArrayList;

/**
 * Testing the User and Address class
 * @author 913613
 */
public class UserTest
{

    public static void main(String[] args)
    {
        
        
        ArrayList<User> userList;
        
        Address a1 = new Address("24","Zoo lane", "London", "LO28PT");
        Address a2 = new Address("28","Brynmill road", "Swansea", "SA28PT");
        
        User u1 = new User("userName1", "William", a1, "userName1PP.jpeg");
        User u2 = new User("SophieWilliams", "Sophie", a1, "userName3PP.jpeg");
        User u3 = new User("Ddog", "David", a2, "DdogPP.jpeg");
        
        u1.AddFavUser(u2);
        u1.AddFavUser(u3);
  
        userList = FileReader.createUserList();
        System.out.println(userList.get(0).toString() + "\n------------------------------------------------------------");
        System.out.println(userList.get(1).toString() + "\n------------------------------------------------------------");
        System.out.println(userList.get(2).toString() + "\n------------------------------------------------------------");
        
        FileWriter.updateUsers(userList, "Users.txt");
        
        userList.get(1).AddFavUser(u2);
        FileWriter.updateFavouriteUsers(userList, "FavUsers.txt");
    }
}
