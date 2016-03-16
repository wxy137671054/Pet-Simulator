public class Turtle extends Pet{
   private String favoriteFood = "Shrimp";
   private String favoriteHygiene = "Turtle Bodywash";
   private String favoriteVitamin = "Vitamin T";
   
   public Turtle (int ID, String name, int goldCost){
     super(ID, name, goldCost);
   }
   //Constructor for existing Pet
   public Turtle(int ID, String name, int goldCost, int pHealth, int pHygiene, int pHunger, int pMood){
     super(ID, name, goldCost, pHealth, pHygiene, pHunger, pMood);
   }   
//Accessor
   public int getPetID(){
      return petID;
   }
   
   public String getName(){
      return nickName;
   }
   
   public int getCost(){
      return cost;
   }
   
   public int getHealth(){
      return health;
   }
   
   public int getHygiene(){
      return hygiene;
   }
   
   public int getHunger(){
      return hunger;
   }
   
   public int getMood(){
      return mood;
   }
   
   
   //Mutator
   public void setHealth(int value){
      health += value;
   }
   public void setHygiene(int value){
      hygiene += value;
   }
   public void setHunger(int value){
      hunger += value;
   }
   public void setMood(int value){
      mood += value;
   }
   public void nameChange(String newName){
      nickName = newName;
   }
   
   public int compareTo(Pet other){
      return getPetID() - other.getPetID();
   }
}