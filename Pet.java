public abstract class Pet{
   protected int petID, cost, health, hygiene, hunger, mood;
   protected String nickName;
   
   //Constructor for new Pet
   public Pet(int ID, String name, int goldCost){
      petID = ID;
      nickName = name;
      cost = goldCost;
      health = 100;
      hygiene = 100;
      hunger = 100;
      mood = 100;
   }
   
   //Constructor for existing Pet
   public Pet(int ID, String name, int goldCost, int pHealth, int pHygiene, int pHunger, int pMood){
      petID = ID;
      nickName = name;
      cost = goldCost;
      health = pHealth;
      hygiene = pHygiene;
      hunger = pHunger;
      mood = pMood;
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