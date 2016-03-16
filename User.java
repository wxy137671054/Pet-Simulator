/*
   Class: User
   Date: Dec. 28th
*/

import java.util.*;

public class User{
   
   // fields
   private int userID;
   private String name;
   private String password;
   private int level;
   private int exp;
   private int gold;
   private PetDatabase pets;
   private Pet curPet;
   
   // constructor
   public User(int id, String n, String p){
      userID = id;
      name = n;
      password = p;
      level = 1;
      exp = 0;
      gold = 500;
   }
 
   public User(int id, String n, String p, int e, int g){
      userID = id;
      name = n;
      password = p;
      // level = 1;
      exp = e;
      gold = g;
   }
   
   // accessor and mutator
   public int getUserID(){
      return userID;
   }
   public void setUserID(int id){
      userID = id;
   }
   public String getName(){
      return name;
   }
   public void setName(String n){
      name = n;
   }
   public String getPassword(){
      return password;
   }
   public void setPassword(String p){
      password = p;
   }
   public int getExp(){
      return exp;
   }
   public void setExp(int e){
      exp = e;
   }
   public int getLevel(){
      return level;
   }
   public void setLevel(int l){
      level = l;
   }
   public int getGold(){
      return gold;
   }
   public void setGold(int g){
      gold = g;
   }
   public Pet getCurPet(){
      return curPet;
   }
   public void setCurPet(Pet pet){
      curPet = pet;
   }
   
   // methods
   
   public boolean checkLogin(String p){
      if(password.equals(p)){
         return true;
      }else{
         return false;
      }
   }
   
   public void loadPet(){
      pets = new PetDatabase(userID);
      
      selectPet();
      
   }
   
   public void selectPet(){
      Scanner sc = new Scanner(System.in);
      int id = sc.nextInt();
      setCurPet(pets.findPet(id));
   }
   
   public int compareID(User other){
      return userID - other.userID;
   }
   public int compareName(User other){
      return name.toLowerCase().compareTo(other.name.toLowerCase());
   }
   public int compareLevel(User other){
      return level - other.level;
   }
   public int compareGold(User other){
      return gold - other.gold;
   }
   
   public int updateLevel(){
      updateLevel(exp, 1);
   }
   
   private int updateLevel(int e, int l){
      if(e < 20){
         return l;
      }else{
         return updateLevel((e - l*20), l+1);
      }
   }
}