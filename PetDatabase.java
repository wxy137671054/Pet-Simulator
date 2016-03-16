import java.io.*;
public class PetDatabase{
   private int numPet;
   private Pet list[];
   
   public PetDatabase(int userNum){
      
      loadPet(userNum);
      
   }
   
   public void loadPet(int userNum){
      String tempName, type;
      int tempID, tempCost, tempHealth, tempHygiene, tempHunger, tempMood;
      try{
         BufferedReader in = new BufferedReader(new FileReader("petData" + userNum + ".txt"));
         numPet = Integer.parseInt(in.readLine());
         list = new Pet[numPet];
         for (int i = 0; i < numPet; i ++){
            
            //Read in stats
            in.readLine();
            type = in.readLine();
            tempID = Integer.parseInt(in.readLine());
            tempName = in.readLine();
            tempCost = Integer.parseInt(in.readLine());
            tempHealth = Integer.parseInt(in.readLine());
            tempHygiene = Integer.parseInt(in.readLine());
            tempHunger = Integer.parseInt(in.readLine());
            tempMood = Integer.parseInt(in.readLine());
            
            //Check Type
            if (type.equals("Cat")){
               list[i] = new Cat(tempID, tempName, tempCost, tempHealth, tempHygiene, tempHunger, tempMood);
            } else if (type.equals("Turtle")){
               list[i] = new Turtle(tempID, tempName, tempCost, tempHealth, tempHygiene, tempHunger, tempMood);
            } else {
               list[i] = new Dog(tempID, tempName, tempCost, tempHealth, tempHygiene, tempHunger, tempMood);
            }
            
            //
            
         }//end of for loop
         in.close();   
      }
      catch (IOException iox){
         System.out.println("Error Loading File");
      }
   
   }
   
   public void savePet(int userNum){
   try{
         BufferedWriter out = new BufferedWriter(new FileWriter("petData" + userNum + ".txt", false));
         out.write(numPet+"\n");
         for (int i = 0; i < numPet; i ++){
            //empty line
            out.newLine();
            
            //Determine the type
            if (list[i] instanceof Cat){
            out.write("Cat\n");
            } else if (list[i] instanceof Turtle){
            out.write("Turtle\n");
            } else {
            out.write("Dog\n");
            }
            
            //Save all stats
            out.write(list[i].getPetID()+"\n");
            out.write(list[i].getName()+"\n");
            out.write(list[i].getCost()+"\n");
            out.write(list[i].getHealth()+"\n");
            out.write(list[i].getHygiene()+"\n");
            out.write(list[i].getHunger()+"\n");
            out.write(list[i].getMood()+"\n");

            
         }//end of for loop
         out.close();
         }catch(IOException iox){
         System.out.println("Error Writing File");
      }
   }
   
   public void sortByPetID(){
      //insertion sort
      Pet tempPet;
      for (int i = 1; i < numPet; i++){
         for (int j = i; j > 0; j--){
            if (list[i].compareTo(list[i-1]) < 0){
            tempPet = list[i];
            list[i] = list[i-1];
            list[i-1] = tempPet;
            }
         }
      }
   }
   
   public Pet findPet(int id){
      return list[id];
   }

}