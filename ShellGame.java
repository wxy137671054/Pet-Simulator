public class ShellGame extends Games{
  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    
    int upperBound = 3;
    int lowerBound = 1;
    int random;
    boolean start;
    final int COST=1;
    
    System.out.println("Playing with which pet?");
    
    String petName = sc.next();
    
    double coin = getCoins();
    System.out.println("You are left with "+coin+"coins, have fun!");
    
    
    do{
      System.out.println("Shall we start?");
      start=getResponse();
      
      //GRAPHICS: click "yes" or "no"
      
      if (start){
        random = (int) ((Math.random() * (upperBound - lowerBound + 1)) + lowerBound);
        
        System.out.println("Shuffling...");
        //display a shuffling animation
        shuffle();
        
        System.out.println("Pick a shell (1, 2 or 3):");
        
        int num = in.nextInt();
        if (random == 1)
        {
          showCup(1);
        }
        
        if (random == 2)
        {
          showCup(2);
        }
        
        if (random ==3)
        {
          showCup(3);
        }
        
        if (num == random)
          
        {
          win();
          
          
          
        }
        
        else
          
        {
          lose();
          
          
          
        }
      }
    }while (coin>=COST && start==true);
    
    
    
    System.out.println("You have run our of coins. See you next time.");
    
  }
  
  private void shuffle(){
    //output graphics of shuffling a cup
    
  }
  
  private void swap(int fromCup, int toCup){
    int temp=toCup;
    toCup=fromCup;
    fromCup=temp;
  }
  
  private boolean getResponse(){
    //mouse click yes or no button
  }
  
  private void showCup(int num){
    //animation to show if there is anything under the cup
  }
  
  /*ABSTRACT METHODS*/
  private abstract void win(){
    System.out.println("You win " +petName);
    
  }
  
  private abstract void lose(){
    System.out.println("You lose" +petName);
  }
}
