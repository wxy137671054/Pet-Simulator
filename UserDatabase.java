import java.io.*;
import java.util.*;

/*
   Class: UserDatabase
   Date: Dec. 31st
*/

public class UserDatabase{
   
   //fields
   ArrayList<User> userList = new ArrayList<User>();
   int numUser;
   User curUser;
   
   // constructor
   public UserDatabase(){
      numUser = 0;
      loadUser();
   }
   
   public void loadUser(){
      try{
         BufferedReader in = new BufferedReader(new FileReader("Users.txt"));
         
         String line = in.readLine();
         
         while(line != null){
            int id = Integer.parseInt(line);
            String name = in.readLine();
            String password = in.readLine();
            int exp = Integer.parseInt(in.readLine());
            int gold = Integer.parseInt(in.readLine());
            in.readLine();
            line = in.readLine();
            User user = new User(id, name, password, exp, gold);
            userList.add(user);
            numUser++;
         }
         in.close();
      }
      catch(IOException iox){
         System.out.println("Error accessing data");
      }
   }
   
   public void saveUser(){
      try{
         sortByUserID();
         BufferedWriter out = new BufferedWriter(new FileWriter("Users.txt"));
         for (int i = 0; i < numUser; i++){
            User user = userList.get(i);
            out.write(user.getUserID());
            out.write(user.getName());
            out.write(user.getPassword());
            out.write(user.getExp());
            out.write(user.getGold());
            out.newLine();
         }
         out.close();
      }
      catch(IOException iox){
         System.out.println("Error saving file");
      }
   }
   
   public void login(String name, String password){
      User user = searchUser(name);
      if(user == null){
         System.out.println("User does not exist");
      }else{
         if(user.checkLogin(password)){
            curUser = user;
         }else{
            System.out.println("Incorrect password");
         }
      }
   }
   
   public void newUser(String name, String password){
      if(searchUser(name) != null){
         System.out.println("name already exist");
      }
      else{
         User user = new User(numUser, name, password);
         userList.add(user);
         numUser++;
         curUser = user;
      }
   }
   
   public void sortByGold(){
      for (int i = 1; i < numUser; i++){
      
      User temp = userList.get(i);
      int j = i;
      
      while (j > 0 &&(userList.get(j-1).compareGold(temp) < 0)){
        userList.remove(j);
        userList.add(j,userList.get(j-1));
        j--;
      }
      userList.remove(j);
      userList.add(j,temp);
    }
   }
   
   public void sortByName(){
      for (int i = 1; i < numUser; i++){
      
      User temp = userList.get(i);
      int j = i;
      
      while (j > 0 &&(userList.get(j-1).compareName(temp) > 0)){
        userList.remove(j);
        userList.add(j,userList.get(j-1));
        j--;
      }
      userList.remove(j);
      userList.add(j,temp);
    }
   }
   
   public void sortByLevel(){
      for (int i = 1; i < numUser; i++){
      
      User temp = userList.get(i);
      int j = i;
      
      while (j > 0 &&(userList.get(j-1).compareLevel(temp) > 0)){
        userList.remove(j);
        userList.add(j,userList.get(j-1));
        j--;
      }
      userList.remove(j);
      userList.add(j,temp);
    }
   }
   
   public void sortByUserID(){
      for (int i = 1; i < numUser; i++){
      
      User temp = userList.get(i);
      int j = i;
      
      while (j > 0 &&(userList.get(j-1).compareID(temp) > 0)){
        userList.remove(j);
        userList.add(j,userList.get(j-1));
        j--;
      }
      userList.remove(j);
      userList.add(j,temp);
    }
   }
   
   private User searchUser(String name){
      
      boolean found = false;
      
      for(int i = 0; i < numUser && !found; i++){
         if(name.equals(userList.get(i).getName())){
            found = true;
            return userList.get(i);
         }
      }
      
      return null;
   }
   
   
}