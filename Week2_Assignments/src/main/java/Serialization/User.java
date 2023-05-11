package Serialization;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class User implements Serializable {
    private String name;
    private int age;
    private String email;
    private String address;

    public static void saveUser(User user, String filePath){
        try{
            FileOutputStream fileOut = new FileOutputStream(filePath);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(user);
            objectOut.close();
            fileOut.close();
            System.out.println("User data saved to :"+filePath);
        }
        catch (IOException e){
            System.out.println("Error saving user data"+ e.getMessage());
        }
    }

    public static User loadUser(String filePath){
        User user = null;
        try{
            FileInputStream fileInp = new FileInputStream(filePath);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInp);
            user= (User) objectInputStream.readObject();
            objectInputStream.close();
            fileInp.close();
            System.out.println("User data loaded from "+filePath);
        }
        catch(IOException | ClassNotFoundException e){
            System.out.println("Error retrieving User data"+e.getMessage());
        }
        return user;
    }

    public static void main(String args[]){
        User user1 = new User("Anirudh",22,"anirudhhari24@gmail.com","Plot no 341");
        User user2 = new User("Manasa",22,"mannagin@gmail.com","Plot no 342");
        User user3 = new User("Ajay",22,"ajayb@gmail.com","Plot no 343");
        User user4 = new User("Monish",22,"monishisro@gmail.com","Plot no 344");

        saveUser(user1,"user.dat");
        saveUser(user2,"user.dat");
        saveUser(user3,"user.dat");
        saveUser(user4,"user.dat");

        //retriving and deserializing
        User userRead = loadUser("user.dat");

        if(userRead!=null)
            System.out.println(userRead.toString());


    }
}

